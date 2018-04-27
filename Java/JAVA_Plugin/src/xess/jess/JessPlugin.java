//
// $Id: $
//
package xess.jess;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;

import jess.JessEvent;
import jess.JessException;
import jess.JessListener;
import jess.RU;
import jess.Rete;
import jess.Value;
import xess.Action;
import xess.And;
import xess.Between;
import xess.Clause;
import xess.Equal;
import xess.Fact;
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
import xess.XessPlugin;

public class JessPlugin implements XessPlugin {

	private static final String NAME = "JESS Plug-in";
	
	private final Rete rete;
	
	public JessPlugin() {
		//create the rete that is reused for each Xess that is executed
		//with this plug-in
		rete = new Rete();
		rete.setEventMask( XessJessListener.getEventMask());
	}

	public String process( String xmlFile, String outputLocation) throws IOException {
		xess.xmlpp.KXMLParser parser = new xess.xmlpp.KXMLParser();
		Xess xess = parser.parseXess(xmlFile);//"src\\examples\\xess_siblings_enhanced.xml" );//
		JessPlugin jpl = new JessPlugin();
		jpl.execute( xess );
		File outputDir = new File(outputLocation+File.separator+System.currentTimeMillis());//"src\\output"+File.separator+System.currentTimeMillis());
		if(outputDir.mkdir())
		{
			File outputFile = new File(outputDir.getAbsolutePath()+File.separator+"Jess_ExpertSystems");
			PrintWriter pw = new PrintWriter(outputFile);
			xess.dumpTrace(pw);//new java.io.PrintWriter( System.out ));
		}
		return outputDir.getAbsolutePath()+File.separator+"Jess_ExpertSystems";
	}
	
	public String getName() {
		return NAME;
	}

	public synchronized void execute( Xess x ) {
		XessJessListener xjl = new XessJessListener( x );
		try {
			//reset the engine
			rete.reset();
			//add the listener
			rete.addJessListener( xjl );
			//import the facts, and define a rule to assert them
			for( Fact f : x.getFacts()) {
				if( f instanceof Predicate ) {
					Predicate p = ( Predicate )f;
					StringBuffer assertion = new StringBuffer( "(assert (");
					assertion.append( f.getName());
					assertion.append( " " );
					assertion.append( getValue( p.getValue().toString()));
					assertion.append( "))" );
					rete.executeCommand( assertion.toString());
				}
				else
				if( f instanceof Struct ) {
					Struct s = ( Struct )f;
					String name = s.getName();
					StringBuffer template = new StringBuffer( "(deftemplate " );
					template.append( name );
					template.append( " \"" );
					template.append( name );
					template.append( "\" " );
					for( Field sf : s.getFields() ) {
						template.append( "(slot " );
						template.append( sf.getName());
						//set the type
						String type = sf.getType();
						if( type != null ) {
							//do something!
						}
						//set the default
						
						//finish the slot
						template.append( ")" );
					}
					template.append( ")" );
					//define the template by executeing the deftemplate command
					rete.executeCommand( template.toString());
				}
				else 
				if( f instanceof Instance ) {
					Instance in = ( Instance )f;
					StringBuffer instance = new StringBuffer( "(assert (" );
					instance.append( in.getType().getName());
					instance.append( " " );
					for( Field inf : in.getFields()) {
						instance.append( "(" );
						instance.append( inf.getName());
						instance.append( " " );
						Object v = inf.getValue();
						instance.append( v != null ? v.toString() : "nil" );
						instance.append( ")" );
					}
					instance.append( "))" );
					rete.executeCommand( instance.toString());
				}
			}
			
			Collection<Rule> rules = x.getRules();
			for( Rule r : rules ) {
				Collection<String> pNames = new HashSet<String>();
				StringBuffer rule = new StringBuffer( "(defrule " );
				rule.append( r.getName());
				rule.append( " " );
				for( Parameter p : r.getParameters()) { 
					String type = p.getType();
					String name = p.getName();
					pNames.add( name );
					Struct s = ( Struct )x.getFact( type );
					rule.append( "(" );
					rule.append( s.getName());
					for( Field f : s.getFields()) {
						String fName = f.getName();
						rule.append( " (" );
						rule.append( f.getName());
						rule.append( " " );
						rule.append( "?" );
						String fullName = name + "." + fName;
						pNames.add( fullName );
						rule.append( fullName );
						rule.append( ")" );
					}
					rule.append( ")" );
				}				
				//add the if clause
				rule.append( "(test " );
				StringBuffer clause = new StringBuffer();
				getClause( r.getIfClause(), pNames, clause );
				rule.append( clause );
				rule.append( ") => " );
				//add the then actions
				for( Action a : r.getThenActions()) {
					if( a instanceof SetAction ) {
						
					}
					else
					if( a instanceof SetInstanceAction ) {
						SetInstanceAction sia = ( SetInstanceAction )a;
						rule.append( "(assert (" );
						rule.append( sia.getType());
						rule.append( " " );
						for( Field f : sia.getFields()) {
							rule.append( "(" );
							rule.append( f.getName());
							rule.append( " ?" );
							rule.append( f.getValue());
							rule.append( ")" );
						}
						rule.append( "))" );
					}
				}
				//debug
				//rule.append( "(printout t \"Found a match for " + r.getName() + "(\" ?arg1.child \",\" ?arg2.child \")!!\" crlf)" );
				//close the rule
				rule.append( ")" );
				System.out.println( "rule: " + rule );
				rete.executeCommand( rule.toString());
			}			
			//rete.reset();
			int result = rete.run();
			x.trace( "Execution completed, " + result +  " rules fired." );
		}
		catch( JessException je ) {
			je.printStackTrace();
		}
		finally {
			rete.removeJessListener( xjl );
		}
	}
	
	private static Value getValue( String vString ) throws JessException {
		Value v = null;
		if( vString.equalsIgnoreCase( "true" )) {
			v = new Value( true );
		}
		else
		if( vString.equalsIgnoreCase( "false" )) {
			v = new Value( false );
		}
		else {
			try {
				v = new Value( Integer.parseInt( vString ), RU.INTEGER );
			}
			catch( NumberFormatException nfe ) {
				try {
					v = new Value( Double.parseDouble( vString ), RU.FLOAT );
				}
				catch( NumberFormatException nfe2 ) {
					v = new Value( vString, RU.STRING );
				}
			}
		}
		return v;
	}
	
	private static void getClause( Clause c, Collection<String> pNames, StringBuffer clause ) throws JessException {
		if( c instanceof And ) {
			And a = ( And )c;
			clause.append( "(and " );
			for( Clause ac : a.getClauses()) {
				getClause( ac, pNames, clause );
			}
			clause.append( ")" );
		}
		else
		if( c instanceof Or ) {
			Or o = ( Or )c;
			clause.append( "(or " );
			for( Clause oc : o.getClauses()) {
				getClause( oc, pNames, clause );
			}
			clause.append( ")" );
		}
		else
		if( c instanceof Equal ) {
			Equal e = ( Equal )c;
			clause.append( "(eq* " );
			clause.append( getValueString( pNames, e.getValue1().toString()));
			clause.append( " " );
			clause.append( getValueString( pNames, e.getValue2().toString()));
			clause.append( ")" );
		}
		else
		if( c instanceof NotEqual ) {
			NotEqual ne = ( NotEqual )c;
			clause.append( "(not (eq* " );
			clause.append( getValueString( pNames, ne.getValue1().toString()));
			clause.append( " " );
			clause.append( getValueString( pNames, ne.getValue2().toString()));
			clause.append( "))" );
		}
		else
		if( c instanceof LessThan ) {
			
		}
		else
		if( c instanceof LessThanOrEqual ) {
			
		}
		else
		if( c instanceof GreaterThan ) {
			
		}
		else
		if( c instanceof GreaterThanOrEqual ) {
			
		}
		else
		if( c instanceof Between ) {
			
		}
		else
		if( c instanceof NotBetween ) {
			
		}
	}
	
	private static String getValueString( Collection<String> pNames, String vString ) throws JessException {
		String v;
		if( pNames.contains( vString )) {
			v = "?" + vString;
		}
		else {
			//Value val = getValue( vString );
			//v = val.toString();
			v = vString;
		}
		return v;
	}
	
	/**
	 * Translates {@link JessEvent JessEvents} into trace messages on the
	 * {@link Xess} that is being executed.
	 *
	 * @author rstjacques
	 */
	private static class XessJessListener implements JessListener {
		/**
		 * The {@link Xess} on which events are traced.
		 */
		private final Xess xess; 
		
		/**
		 * Creates a new {@link XessJessListener} that is used to trace any
		 * {@link JessEvent JessEvents} that are received during execution.
		 * 
		 * @param x The {@link Xess} used to trace events.
		 */
		XessJessListener( Xess x ) {
			xess = x;
		}
		
		/**
		 * Called whenever an event is generated that matches the 
		 * {@link #getEventMask() mask} supplied to the {@link Rete} before 
		 * execution.
		 * 
		 * @param je The {@link JessEvent} that has been fired.
		 */
		public void eventHappened( JessEvent je ) throws JessException {
			String type;
			switch( je.getType()) {
			case JessEvent.ACTIVATION: 
				type = "Rule Activated";
				break;
			case JessEvent.CLEAR: 
				type = "Clear";
				break;
			case JessEvent.DEFCLASS: 
				type = "Class Defined";
				break;
			case JessEvent.DEFFACTS: 
				type = "Fact(s) Defined";
				break; 
			case JessEvent.DEFGLOBAL: 
				type = "Global Defined";
				break;
			case JessEvent.DEFINSTANCE: 
				type = "Instance Defined";
				break;
			case JessEvent.DEFRULE: 
				type = "Rule Defined";
				break;
			case JessEvent.DEFRULE_FIRED:
				type = "Rule Fired";
				break; 
			case JessEvent.DEFTEMPLATE:
				type = "Template Defined";
				break;
			case JessEvent.FACT: 
				type = "Fact Asserted";
				handleAssertion(( jess.Fact )je.getObject());
				break;
			case JessEvent.FOCUS:
				type = "Focus";
				break;
			case JessEvent.HALT:
				type = "Halted";
				break;
			case JessEvent.MODIFIED:
				type = "Modified";
				break;
			case JessEvent.REMOVED:
				type = "Removed";
				break;
			case JessEvent.RESET:
				type = "Reset";
				break;
			case JessEvent.RETE_TOKEN:
				type = "Rete Token (left)";
				break; 
			case JessEvent.RETE_TOKEN_RIGHT:
				type = "Rete token (right)";
				break; 
			case JessEvent.RUN:
				type = "Execution Started";
				break;
			case JessEvent.USERFUNCTION: 
				type = "User Function";
				break; 
			case JessEvent.USERFUNCTION_CALLED:
				type = "User Function Called";
				break;
			case JessEvent.USERPACKAGE: 
				type = "User Package";
				break;
			default: 
				type = "Unknown Type (" + je.getType() + ")";
				break;
			}
			StringBuffer buf = new StringBuffer( type );
			buf.append( " (" );
			buf.append( je.getObject());
			buf.append( ")" );
			xess.trace( buf.toString());
		}
		
		private void handleAssertion( jess.Fact jf ) {
			
		}
		
		/**
		 * Returns the event mask that is used to determine which events are
		 * fired during execution.
		 * 
		 * @return The event mask that defines which events are fired during
		 * execution.
		 */
		private static int getEventMask() {
			return JessEvent.ACTIVATION + JessEvent.CLEAR + 
				JessEvent.DEFCLASS + JessEvent.DEFFACTS + 
				JessEvent.DEFGLOBAL + JessEvent.DEFINSTANCE +
				JessEvent.DEFRULE + JessEvent.DEFRULE_FIRED + 
				JessEvent.DEFTEMPLATE + JessEvent.FACT + JessEvent.FOCUS +
				JessEvent.HALT + JessEvent.MODIFIED + JessEvent.REMOVED +
				JessEvent.RESET + JessEvent.RETE_TOKEN + 
				JessEvent.RETE_TOKEN_LEFT + JessEvent.RETE_TOKEN_RIGHT + 
				JessEvent.RUN + JessEvent.USERFUNCTION + 
				JessEvent.USERFUNCTION_CALLED + JessEvent.USERPACKAGE;
		}
	} // XessJessListener
}
