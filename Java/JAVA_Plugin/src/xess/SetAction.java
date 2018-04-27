//
// $Id: $
//
package xess;

/**
 * {@link Action Actions} are used in the <b>{@link Rule#getThenActions() 
 * then}</b> and <b>{@link Rule#getElseActions() else}</b> parts of
 * a {@link Rule}.  The {@link SetAction} indicates that the value of a fact, 
 * field, or parameter in the system should be modified as the result of the
 * evaluation of a {@link Rule}.  The {@link SetAction#getName() name} in the
 * {@link SetAction} determines the name of the fact, field, or parameter to 
 * be set or modified; this may refer to a {@link Predicate} or a specific 
 * field within an {@link Instance}, or even one of the parameters passed into
 * the {@link Rule}.  Note that it is possible for the name to match multiple
 * entities within the system; in this case the normal rules of scope apply 
 * (first the {@link Rule#getParameters() parameters} are checked, then 
 * the system-level {@link Predicate predicates} and 
 * {@link Instance instances}. The {@link SetAction#getValue() value} of the 
 * {@link SetAction} determines the new value of the fact or field.<P>
 *
 * @author rstjacques
 */
public class SetAction implements Action {
	/**
	 * The name of the {@link Fact}, {@link Field}, or {@link Parameter} to be
	 * modified.
	 */
	private String name;
	
	/**
	 * The new value of the {@link Fact}, {@link Field}, or {@link Parameter}.
	 */
	private String value;
	
	/**
	 * Creates a new {@link SetAction} with the specified name and value. The
	 * {@link SetAction} may be added to the set of actions associated with 
	 * the <b>{@link Rule#getThenActions() then}</b> or 
	 * <b>{@link Rule#getElseActions() else}</b> parts of a {@link Rule}.
	 */
	public SetAction( String n, String v ) {
		setName( n );
		setValue( v );
	}
	
	/**
	 * Sets the name of the {@link Fact}, {@link Field}, or {@link Parameter}
	 * to be modified by the {@link SetAction}.  This is <b>not</b> the name 
	 * of the {@link SetAction} itself, and need not be unique.
	 * 
	 * @param n The name of the {@link Fact}, {@link Field}, or 
	 * {@link Parameter} to be modified by the {@link SetAction}.
	 */
	public void setName( String n ) {
		name = n;
	}
	
	/**
	 * Returns the name of the {@link Fact}, {@link Field}, or 
	 * {@link Parameter} that should be modified by the {@link SetAction}.
	 * 
	 * @return The name of the {@link Fact}, {@link Field}, or 
	 * {@link Parameter} that should be modified by the {@link SetAction}.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value to which the {@link Fact}, {@link Field}, or 
	 * {@link Parameter} should be modified in the event that the 
	 * {@link SetAction} is invoked.
	 * 
	 * @param v The value to which the {@link Fact}, {@link Field}, or 
	 * {@link Parameter} should be modified.
	 */
	public void setValue( String v ) {
		value = v;
	}
	
	/**
	 * Returns the value to which the {@link Fact}, {@link Field}, or 
	 * {@link Parameter} should be modified in the event that the 
	 * {@link SetAction} is invoked.
	 * 
	 * @return The value to which the {@link Fact}, {@link Field}, or 
	 * {@link Parameter} should be modified.
	 */
	public String getValue() {
		return value;
	}

	public String toXml() {
		StringBuffer buf = new StringBuffer( "<" );
		buf.append( SET );
		buf.append( " " );
		buf.append( NAME );
		buf.append( "=\"" );
		buf.append( getName());
		buf.append( "\" " );
		buf.append( VALUE );
		buf.append( "=\"" );
		buf.append( getValue());
		buf.append( "\"/>" );
		return buf.toString();
	}
} // SetAction
