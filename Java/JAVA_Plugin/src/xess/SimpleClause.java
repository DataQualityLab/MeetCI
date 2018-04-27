//
// $Id: $
//
package xess;

/**
 * A {@link SimpleClause} represents a basic comparison between two values; 
 * whether or not the {@link Clause} is satisfied is based on the results of the
 * comparison defined by a sub-class.
 *
 * @author rstjacques
 */
public abstract class SimpleClause extends Clause {
	/**
	 * The first value in the comparison.
	 */
	private String value1;
	
	/**
	 * The second value in the comparison.
	 */
	private String value2;
	
	/**
	 * Creates a new {@link SimpleClause} with the specified values.
	 * 
	 * @param v1 The first value to be used in the comparison.
	 * @param v2 The second value to be used in the comparison.
	 */
	public SimpleClause( String v1, String v2 ) {
		this( null, v1, v2 );
	}

	/**
	 * Creates a new {@link SimpleClause} with the specified values.
	 * 
	 * @param desc A description of the claus.
	 * @param v1 The first value to be used in the comparison.
	 * @param v2 The second value to be used in the comparison.
	 */
	public SimpleClause( String desc, String v1, String v2 ) {
		super( desc );
		value1 = v1;
		value2 = v2;
	}

	/**
	 * Sets the first value to be used in the comparison.
	 * 
	 * @param v1 The first value to be compared.
	 */
	public void setValue1( String v1 ) {
		value1 = v1;
	}
	
	/**
	 * Returns the first value to be used in the comparison.
	 * 
	 * @return The first value to be compared.
	 */
	public String getValue1() {
		return value1;
	}
	
	/**
	 * Sets the second value to be used in the comparison.
	 * 
	 * @param v2 The second value to be compared.
	 */
	public void setValue2( String v2 ) {
		value2 = v2;
	}
	
	/**
	 * Returns the second value to be used in the comparison.
	 * 
	 * @return The second value to be compared.
	 */
	public String getValue2() {
		return value2;
	}
	
	public String toXml() {
		StringBuffer buf = new StringBuffer();
		buf.append( "<" );
		buf.append( getName());
		String d = getDescription();
		if( d != null ) {
			buf.append( " " );
			buf.append( DESCRIPTION );
			buf.append( "=\"" );
			buf.append( d );
			buf.append( "\"" );
		}
		buf.append( " " );
		buf.append( VALUE1 );
		buf.append( "=\"" );
		buf.append( getValue1());
		buf.append( "\" " );
		buf.append( VALUE2 );
		buf.append( "=\"" );
		buf.append( getValue2());
		buf.append( "\"/>" );
		return buf.toString();
	}
} // SimpleClause
