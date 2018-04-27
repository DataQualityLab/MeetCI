//
// $Id: $
//
package xess.xmlpp;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import xess.And;
import xess.Between;
import xess.Clause;
import xess.Equal;
import xess.Field;
import xess.GreaterThan;
import xess.GreaterThanOrEqual;
import xess.Instance;
import xess.LessThan;
import xess.LessThanOrEqual;
import xess.NotBetween;
import xess.NotEqual;
import xess.Or;
import xess.Parameter;
import xess.Predicate;
import xess.Rule;
import xess.SetAction;
import xess.SetInstanceAction;
import xess.Struct;
import xess.Xess;
import xess.Action;
import xess.XessParser;

/**
 * An implementation of the {@link XessParser} that uses the KXML 2.0 
 * implementaion if the XML Pull Parser API to parse {@link Xess} documents.
 *
 * @author rstjacques
 */
public class KXMLParser implements XessParser {
	/**
	 * Test method to parse an {@link Xess} document and display the results.
	 * 
	 * @param argv The location of the file that should be parsed.
	 * 
	 * @throws IOException If the file cannot be parsed.
	 */
	public static final void main( String[] argv ) throws IOException {
		XessParser parser = new KXMLParser();
		Xess xess = parser.parseXess( argv[0] );
		System.out.println( xess.toXml());

	}
	
	public Xess parseXess( String filename ) throws IOException {
		return parseXess( new FileReader( filename ));
	}

	public Xess parseXess( InputStream is ) throws IOException {
		return parseXess( new InputStreamReader( is ));
	}

	public Xess parseXess( Reader r ) throws IOException {
		//create a new, empty Xess
		Xess xess = new Xess();
		try {
			//load the processor
			XmlPullParser xmlpp = new KXmlParser();
			xmlpp.setInput( r );
			//validate the document
			nextTag( xmlpp );
			if( xmlpp.getName().equals( "MeetCI" ) == false ) {
				throw getUnexpectedTagException( "MeetCI", xmlpp.getName());
			}
			nextTag( xmlpp );
			if( xmlpp.getName().equals( XESS ) == false ) {
				throw getUnexpectedTagException( XESS, xmlpp.getName());
			}
			while( nextTag( xmlpp ) != XmlPullParser.END_TAG ) {
				String tag = xmlpp.getName();
				if( tag.equals( PREDICATE )) {
					xess.addFact( parsePredicate( xmlpp ));
				}
				else
				if( tag.equals( STRUCT )) {
					xess.addFact( parseStruct( xmlpp ));
				}
				else
				if( tag.equals( INSTANCE )) {
					xess.addFact( parseInstance( xmlpp, xess ));
				}
				else
				if( tag.equals( RULE )) {
					xess.addRule( parseRule( xmlpp ));
				}
				else {
					throw getUnexpectedTagException( XESS, tag );
				}
			}
			return xess;
		}
		catch( XmlPullParserException xmlppe ) {
			xmlppe.printStackTrace();
			throw new IOException( xmlppe.getMessage());
		}		
	}
	
	//
	// facts (knowledge base)
	//
	
	/**
	 * Assumes that the specified {@link XmlPullParser} is positioned on the 
	 * {@link XmlPullParser.START_TAG} for a {@link Predicate}, and parses the 
	 * {@link Predicate} from the XML data.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the 
	 * {@link Predicate}.
	 * 
	 * @return The {@link Predicate} that has been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static Predicate parsePredicate( XmlPullParser xmlpp ) 
		throws XmlPullParserException, IOException {
		String pName = null;
		String pValue = null;
		int paCount = xmlpp.getAttributeCount();
		for( int i=0; i<paCount; i++ ) {
			String n = xmlpp.getAttributeName( i );
			String v = xmlpp.getAttributeValue( i );
			if( n.equals( NAME )) {
				pName = v;
			}
			else
			if( n.equals( VALUE )) {
				pValue = v;
			}
			else {
				//invalid attributes are bad
				throw getInvalidAttributeException( PREDICATE, n, v );
			}
		}
		nextTag( xmlpp );
		return new Predicate( pName, pValue );
	}
	
	/**
	 * Assumes that the specified {@link XmlPullParser} is positioned on the 
	 * {@link XmlPullParser.START_TAG} for a {@link Struct}, and parses the 
	 * {@link Struct} from the XML data.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the {@link Struct}.
	 * 
	 * @return The {@link Struct} that has been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static Struct parseStruct( XmlPullParser xmlpp ) throws XmlPullParserException, IOException {
		//extract the name of the struct
		String sName = null;
		int saCount = xmlpp.getAttributeCount();
		for( int i=0; i<saCount; i++ ) {
			String n = xmlpp.getAttributeName( i );
			String v = xmlpp.getAttributeValue( i );
			if( n.equals( NAME )) {
				sName = v;
			}
			else {
				throw getInvalidAttributeException( STRUCT, n, v );
			}
		}
		//create the new struct
		Struct str = new Struct( sName );
		//parse the fields
		while( nextTag( xmlpp ) != XmlPullParser.END_TAG ) {
			String subTag = xmlpp.getName();
			if( subTag.equals( FIELD )) {
				//parse the field
				str.setField( parseField( xmlpp ));
			}
			else {
				throw getUnexpectedTagException( STRUCT, subTag );
			}			
		}
		return str;
	}
	
	/**
	 * Assumes that the specified {@link XmlPullParser} is positioned on the 
	 * {@link XmlPullParser.START_TAG} for an {@link Instance}, and parses the 
	 * {@link Instance} from the XML data.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the {@link Instance}.
	 * @param xess The {@link Xess} that must contain the parent 
	 * {@link Struct} for the {@link Instance} to be parsed.
	 * 
	 * @return The {@link Instance} that has been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static Instance parseInstance( XmlPullParser xmlpp, Xess xess )
		throws XmlPullParserException, IOException {
		String iName = null;
		String iType = null;
		int iaCount = xmlpp.getAttributeCount();
		for( int i=0; i<iaCount; i++ ) {
			String n = xmlpp.getAttributeName( i );
			String v = xmlpp.getAttributeValue( i );
			if( n.equals( NAME )) {
				iName = v;
			}
			else
			if( n.equals( TYPE )) {
				iType = v;
			}
			else {
				throw getInvalidAttributeException( INSTANCE, n, v );
			}
		}
		Struct parent = ( Struct )xess.getFact( iType );
		Instance inst = new Instance( iName, parent );
		while( nextTag( xmlpp ) != XmlPullParser.END_TAG ) {
			String subTag = xmlpp.getName();
			if( subTag.equals( FIELD )) {
				inst.setField( parseField( xmlpp ));
			}
			else {
				throw getUnexpectedTagException( INSTANCE, subTag );
			}
		}
		return inst;
	}
	
	/**
	 * Assumes that the specified {@link XmlPullParser} is positioned on the 
	 * {@link XmlPullParser.START_TAG} for a {@link Field}, and parses the 
	 * {@link Field} from the XML data.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the {@link Field}.
	 * 
	 * @return The {@link Field} that has been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static Field parseField( XmlPullParser xmlpp ) 
		throws XmlPullParserException, IOException {
		String fName = null;
		String fType = null;
		String fValue = null;
		int faCount = xmlpp.getAttributeCount();
		for( int i=0; i<faCount; i++ ) {
			String n = xmlpp.getAttributeName( i );
			String v = xmlpp.getAttributeValue( i );
			if( n.equals( NAME )) {
				fName = v;
			}
			else
			if( n.equals( TYPE )) {
				fType = v;
			}
			else
			if( n.equals( VALUE )) {
				fValue = v;
			}
			else {
				//invalid attributes are bad
				throw getInvalidAttributeException( FIELD, n, v );
			}
		}
		//move to the end of the tag
		nextTag( xmlpp );
		return new Field( fName, fType, fValue );
	}
	
	//
	// rules
	//
	
	/**
	 * Assumes that the specified {@link XmlPullParser} is positioned on the 
	 * {@link XmlPullParser.START_TAG} for a {@link Rule}, and parses the 
	 * {@link Rule} from the XML data.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the {@link Rule}.
	 * 
	 * @return The {@link Rule} that has been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static final Rule parseRule( XmlPullParser xmlpp ) throws XmlPullParserException, IOException {
		//extract the name of the rule
		String rName = null;
		int raCount = xmlpp.getAttributeCount();
		for( int i=0; i<raCount; i++ ) {
			String n = xmlpp.getAttributeName( i );
			String v = xmlpp.getAttributeValue( i );
			if( n.equals( NAME )) {
				rName = v;
			}
			else {
				throw getInvalidAttributeException( RULE, n, v );
			}
		}
		Rule r = new Rule( rName );
		//parse the parameters, if, then, else...
		while( nextTag( xmlpp ) != XmlPullParser.END_TAG ) {
			String subTag = xmlpp.getName();
			if( subTag.equals( PARAMETER )) {
				//parse the parameter
				r.setParameter( parseParameter( xmlpp ));
			}
			else
			if( subTag.equals( IF )) {
				//parse the if clause
				nextTag( xmlpp );
				r.setIfClause( parseClause( xmlpp ));
				nextTag( xmlpp );
			}
			else
			if( subTag.equals( THEN )) {
				//parse the then actions
				while( nextTag( xmlpp ) != XmlPullParser.END_TAG ) {
					r.addThenAction( parseAction( xmlpp ));
				}
				while( xmlpp.getName().equals( THEN ) == false ) {
					nextTag( xmlpp );
				}
			}
			else
			if( subTag.equals( ELSE )) {
				//parse the else actions
				while( nextTag( xmlpp ) != XmlPullParser.END_TAG ) {
					r.addElseAction( parseAction( xmlpp ));
				}
				while( xmlpp.getName().equals( ELSE ) == false ) {
					nextTag( xmlpp );
				}
			}
			else {
				throw getUnexpectedTagException( RULE, subTag );
			}			
		}
		return r;
	}
	
	/**
	 * Assumes that the specified {@link XmlPullParser} is positioned on the 
	 * {@link XmlPullParser.START_TAG} for a {@link Parameter}, and parses the 
	 * {@link Parameter} from the XML data.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the 
	 * {@link Parameter}.
	 * 
	 * @return The {@link Predicate} that has been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static final Parameter parseParameter( XmlPullParser xmlpp ) throws XmlPullParserException, IOException {
		String pName = null;
		String pType = null;
		int paCount = xmlpp.getAttributeCount();
		for( int i=0; i<paCount; i++ ) {
			String n = xmlpp.getAttributeName( i );
			String v = xmlpp.getAttributeValue( i );
			if( n.equals( NAME )) {
				pName = v;
			}
			else
			if( n.equals( TYPE )) {
				pType = v;
			}
			else {
				//invalid attributes are bad
				throw getInvalidAttributeException( PARAMETER, n, v );
			}
		}
		//move to the end of the tag
		nextTag( xmlpp );
		return new Parameter( pName, pType );
	}
	
	/**
	 * Assumes that the specified {@link XmlPullParser} is positioned on the 
	 * {@link XmlPullParser.START_TAG} for a {@link Clause}, and parses the 
	 * {@link Clause} from the XML data.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the {@link Clause}.
	 * 
	 * @return The {@link Clause} that has been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static final Clause parseClause( XmlPullParser xmlpp ) throws IOException,
		XmlPullParserException {
		boolean nextTag = true;
		Clause clause = null;
		String cName = xmlpp.getName();
		if( cName.equals( AND )) {
			Collection<Clause> subClauses = parseSubClauses( xmlpp );
			clause = new And( subClauses );
			nextTag = false;
		}
		else
		if( cName.equals( OR )) {
			Collection<Clause> subClauses = parseSubClauses( xmlpp );
			clause = new Or( subClauses );
			nextTag = false;
		}
		else
		if( cName.equals( EQUAL )) {
			ValuePair vp = parseValuePair( xmlpp );
			clause = new Equal( vp.value1, vp.value2 );
		}
		else
		if( cName.equals( NOT_EQUAL )) {
			ValuePair vp = parseValuePair( xmlpp );
			clause = new NotEqual( vp.value1, vp.value2 );
		}
		else
		if( cName.equals( GREATER_THAN )) {
			ValuePair vp = parseValuePair( xmlpp );
			clause = new GreaterThan( vp.value1, vp.value2 );
		}
		else
		if( cName.equals( GREATER_THAN_OR_EQUAL )) {
			ValuePair vp = parseValuePair( xmlpp );
			clause = new GreaterThanOrEqual( vp.value1, vp.value2 );
		}
		else
		if( cName.equals( LESS_THAN )) {
			ValuePair vp = parseValuePair( xmlpp );
			clause = new LessThan( vp.value1, vp.value2 );
		}
		else
		if( cName.equals( LESS_THAN_OR_EQUAL )) {
			ValuePair vp = parseValuePair( xmlpp );
			clause = new LessThanOrEqual( vp.value1, vp.value2 );
		}
		else
		if( cName.equals( BETWEEN )) {
			MinMax mm = parseMinMax( xmlpp );
			clause = new Between( mm.min, mm.max, mm.value );
		}
		else
		if( cName.equals( NOT_BETWEEN )) {
			MinMax mm = parseMinMax( xmlpp );
			clause = new NotBetween( mm.min, mm.max, mm.value );
		}
		else {
	
		}
		if( nextTag ) {
			nextTag( xmlpp );
		}
		return clause;
	}
	
	/**
	 * Parses the sub-clauses within an {@link And} or {@link Or} 
	 * {@link Clause}.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the sub-clauses.
	 * 
	 * @return The {@link Collection} of sub-clauses that have been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static final Collection<Clause> parseSubClauses( XmlPullParser xmlpp ) 
		throws IOException, XmlPullParserException {
		List<Clause> subClauses = new LinkedList<Clause>();
		while( nextTag( xmlpp ) != XmlPullParser.END_TAG ) {
			subClauses.add( parseClause( xmlpp ));
		}
		return subClauses;
	}
	
	/**
	 * Parses a pair of value attributes from the tag at which the specified
	 * {@link XmlPullParser} is currently positioned.  Such attributes are
	 * used for many of the {@link Clause clauses} in an {@link Xess} 
	 * document.
	 *  
	 * @param xmlpp The {@link XmlPullParser} that is used to parse the value
	 * attributes.
	 * 
	 * @return The {@link ValuePair} that contains the value attributes.
	 */
	private static final ValuePair parseValuePair( XmlPullParser xmlpp ) {
		ValuePair vp = new ValuePair();
		int count = xmlpp.getAttributeCount();
		for( int i=0; i<count; i++ ) {
			String n = xmlpp.getAttributeName( i );
			String v = xmlpp.getAttributeValue( i );
			if( n.equals( VALUE1 )) {
				vp.value1 = v;
			}
			else
			if( n.equals( VALUE2 )) {
				vp.value2 = v;
			}
		}
		return vp;
	}
	
	/**
	 * Parses a pair of min/max attributes from the tag at which the specified
	 * {@link XmlPullParser} is currently positioned.  Such attributes are
	 * used for many of the {@link Clause clauses} in an {@link Xess} 
	 * document.
	 *  
	 * @param xmlpp The {@link XmlPullParser} that is used to parse the 
	 * min/max attributes.
	 * 
	 * @return The {@link MinMax} that contains the min/max attributes.
	 */
	private static final MinMax parseMinMax( XmlPullParser xmlpp ) {
		MinMax mm = new MinMax();
		int count = xmlpp.getAttributeCount();
		for( int i=0; i<count; i++ ) {
			String n = xmlpp.getAttributeName( i );
			String v = xmlpp.getAttributeValue( i );
			if( n.equals( VALUE )) {
				mm.value = v;
			}
			else
			if( n.equals( MIN )) {
				mm.min = v;
			}
			else
			if( n.equals( MAX )) {
				mm.max = v;
			}
		}
		return mm;
	}
	
	/**
	 * Assumes that the specified {@link XmlPullParser} is positioned on the 
	 * {@link XmlPullParser.START_TAG} for an {@link Action}, and parses the 
	 * {@link Action} from the XML data.
	 * 
	 * @param xmlpp The {@link XmlPullParser} used to parse the 
	 * {@link Action}.
	 * 
	 * @return The {@link Action} that has been parsed.
	 * 
	 * @throws XmlPullParserException If the {@link XmlPullParser parser} 
	 * generates an exception.
	 * @throws IOException If the XML contains invalid tags or attributes. 
	 */
	private static Action parseAction( XmlPullParser xmlpp ) 
		throws XmlPullParserException, IOException {
		Action action = null;
		String aName = xmlpp.getName();
		if( aName.equals( SET ) || aName.equals( SET_PREDICATE )) {
			String sName = null;
			String sValue = null;
			int saCount = xmlpp.getAttributeCount();
			for( int i=0; i<saCount; i++ ) {
				String n = xmlpp.getAttributeName( i );
				String v = xmlpp.getAttributeValue( i );
				if( n.equals( NAME )) {
					sName = v;
				}
				else
				if( n.equals( VALUE )) {
					sValue = v;
				}
				else {
					throw getInvalidAttributeException( aName, n, v );
				}
			}
			action = new SetAction( sName, sValue );
		}
		else
		if( aName.equals( SET_INSTANCE )) {
			//create the action
			String siType = null;
			int siaCount = xmlpp.getAttributeCount();
			for( int i=0; i<siaCount; i++ ) {
				String n = xmlpp.getAttributeName( i );
				String v = xmlpp.getAttributeValue( i );
				if( n.equals( TYPE )) {
					siType = v;
				}
				else {
					throw getInvalidAttributeException( aName, n, v );
				}
			}
			SetInstanceAction sia = new SetInstanceAction( siType );
			//parse the fields
			while( nextTag( xmlpp ) != XmlPullParser.END_TAG ) {
				String subTag = xmlpp.getName();
				if( subTag.equals( FIELD )) {
					sia.setField( parseField( xmlpp ));
				}
				else {
					throw getUnexpectedTagException( INSTANCE, subTag );
				}
			}
			action = sia;
		}
		else
		if( aName.equals( RUN_RULE )) {
			
		}
		else {
			throw getUnexpectedTagException( RULE, aName );
		}
		return action;
	}
	
	//
	// misc
	// 
	
	/**
	 * Advances the specified {@link XmlPullParser} to the next tag.
	 * 
	 * @param xmlpp The {@link XmlPullParser} to move to the next tag.
	 * 
	 * @throws XmlPullParserException If the parser cannot be moved to the 
	 * next tag.
	 * @throws IOException If the parser cannot be moved to the next tag.
	 */
	private static final int nextTag( XmlPullParser xmlpp ) 
		throws XmlPullParserException, IOException {
		return xmlpp.nextTag();
	}
	
	//
	// errors
	//
	
	/**
	 * Generates an {@link IOException} that can be used in the event that an
	 * unexpected tag is encountered in the XML data.
	 * 
	 * @param parent The name of the parent tag.
	 * @param tag The name of the unexpected tag.
	 * 
	 * @return The {@link IOException} describing the context of the 
	 * unexpected tag.
	 */
	private static IOException getUnexpectedTagException( String parent, String tag ) {
		StringBuffer buf = new StringBuffer( "Unexpected tag '" );
		buf.append( tag );
		buf.append( "' in '" );
		buf.append( parent );
		buf.append( "'." );
		return new IOException( buf.toString());
	}
	
	/**
	 * Generates an {@link IOException} that can be used in the event that an
	 * unexpected attribute is encountered in the XML data.
	 * 
	 * @param tag The name of the tag containing the attribute.
	 * @param name The name of the invalid attribute.
	 * @param value The value of the invalid attribute.
	 * 
	 * @return The {@link IOException} describing the context of the 
	 * unexpected attribute.
	 */
	private static IOException getInvalidAttributeException( String tag, String name, String value ) {
		StringBuffer buf = new StringBuffer( "Invalid '" );
		buf.append( tag );
		buf.append( "' attribute: " );
		buf.append( name );
		buf.append( "=" );
		buf.append( value );
		return new IOException( buf.toString());
	}
	
	//
	// support classes
	//
	
	/**
	 * A simple class used to wrap the value attributes of a tag with two 
	 * values.
	 */
	private static class ValuePair {
		/**
		 * The first value; usually contained in the "value1" attribute.
		 */
		private String value1 = null;
		
		/**
		 * The second value; usually contained in the "value2" attribute.
		 */
		private String value2 = null;
	} // ValuePair
	
	/**
	 * A simple class used to wrap the min/max attributes of a tag that
	 * contains such attributes.
	 */
	private static class MinMax {
		/**
		 * The value; typically checked to see if it is between the min and 
		 * the max values; usally contained in the "value" attribute.
		 */
		private String value;
		
		/**
		 * The minimum; typically checked to see if it is less than (or equal
		 * to) the value; usally contained in the "min" attribute.
		 */
		private String min;
		
		/**
		 * The maximum; typically checked to see if it is greater than (or
		 * equal to) the value; usally contained in the "max" attribute.
		 */
		private String max;
	} // MinMax
} // KXMLParser
