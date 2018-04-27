//
// $Id: $
//
package xess;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link Action Actions} are used in the <b>{@link Rule#getThenActions() 
 * then}</b> and <b>{@link Rule#getElseActions() else}</b> parts of
 * a {@link Rule}.  The {@link RunRuleAction} indicates a {@link Rule} should
 * be invoked as the result of the evaluation of another {@link Rule}.  The 
 * {@link RunRuleAction#getName() name} in the {@link RunRuleAction} 
 * determines the name of the {@link Rule} to be invoked, and the 
 * {@link RunRuleAction#getArgumentNames() arguments} specify the input to the
 * {@link Rule} to be invoked.<P>
 * 
 * @deprecated The {@link RunRuleAction} is not necessary in (or directly 
 * supported by) many expert system shells that search the universe of 
 * discorse for any facts matching the input of the defined 
 * {@link Rule Rules}.  In such systems it is difficult, if not impossible, to
 * explicitly call another {@link Rule}.
 *
 * @author rstjacques
 */
public class RunRuleAction implements Action {
	/**
	 * The name of the {@link Rule} that should be executed.
	 */
	private String name;
	
	/**
	 * The {@link Collection} of name/value pairs that specify the arguments
	 * that should be used to invoke the {@link Rule}.
	 */
	private final Map<String,String> arguments;
	
	/**
	 * Creates a new {@link RunRuleAction} that can be used to execute the
	 * {@link Rule} with the specified {@link Rule#getName() name}.
	 * 
	 * @param n The {@link Rule#getName() name} of the {@link Rule} to 
	 * execute.
	 */
	public RunRuleAction( String n ) {
		setName( n );
		arguments = new HashMap<String,String>();
	}

	/**
	 * Returns the {@link Rule#getName() name} of the {@link Rule} that should
	 * be invoked.
	 * 
	 * @return The {@link Rule#getName() name} of the {@link Rule} that should
	 * be invoked.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the {@link Rule#getName() name} of the {@link Rule} that should
	 * be invoked.
	 * 
	 * param n The {@link Rule#getName() name} of the {@link Rule} that should
	 * be invoked.
	 */
	public void setName( String n ) {
		name = n;
	}
	
	/**
	 * Sets the argument with the specified name to the specified value.  If 
	 * an argument with the specified name does not already exists, a new 
	 * argument is added; otherwise the existing argument is replaced. 
	 * 
	 * @param n The name of the argument to add or replace.
	 * @param v The value of the argument.
	 */
	public void setArgument( String n, String v ) {
		synchronized( arguments ) {
			arguments.put( n, v );
		}
	}
	
	/**
	 * Returns the value of the argument with the specified name.
	 * 
	 * @param n The name of the argument for which the value should be 
	 * retrieved.
	 * 
	 * @return The value of the argument with the specified name.
	 */
	public String getArgument( String n ) {
		synchronized( arguments ) {
			return arguments.get( n );
		}
	}
	
	/**
	 * Removes the argument with the specified name.
	 * 
	 * @param n The name of the argument to remove.
	 */
	public void removeArgument( String n ) {
		synchronized( arguments ) {
			arguments.remove( n );
		}
	}
	
	/**
	 * Returns a {@link Collection} containing the names of the arguments to
	 * the {@link Rule} that should be invoked.
	 * 
	 * @return A {@link Collection} of the names of the arguments to the
	 * {@link Rule} that should be invoked.
	 */
	public Collection<String> getArgumentNames() {
		synchronized( arguments ) {
			return arguments.keySet();
		}
	}
	
	/**
	 * Clears all of the arguments from the {@link RunRuleAction}.
	 */
	public void clearArguments() {
		synchronized( arguments ) {
			arguments.clear();
		}
	}
	
	public String toXml() {
		StringBuffer buf = new StringBuffer( "<" );
		buf.append( RUN_RULE );
		buf.append( " " );
		buf.append( NAME );
		buf.append( "=\"" );
		buf.append( getName());
		buf.append( "\"" );
		synchronized( arguments ) {
			Collection<String> names = getArgumentNames();
			if( names.size() > 0 ) {
				buf.append( ">" );
				for( String name : names ) {
					String value = getArgument( name );
					buf.append( "<" );
					buf.append( ARGUMENT );
					buf.append( " " );
					buf.append( NAME );
					buf.append( "=\"" );
					buf.append( name );
					buf.append( "\" " );
					buf.append( VALUE );
					buf.append( "=\"" );
					buf.append( value );
					buf.append( "\"/>" );
				}
				buf.append( "</" );
				buf.append( RUN_RULE );
				buf.append( ">" );
			}
			else {
				buf.append( "/>" );
			}
		}
		return buf.toString();
	}
} // RunRuleAction
