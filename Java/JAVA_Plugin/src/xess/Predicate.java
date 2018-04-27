//
// $Id: $
//
package xess;

/**
 * A {@link Predicate} is the simplest form of {@link Fact}; it simply 
 * associates a name with a value (e.g. X=Y).
 *
 * @author rstjacques
 */
public class Predicate extends Fact {
	/**
	 * The value of the {@link Predicate}.
	 */
	private String value;
	
	/**
	 * Creates a new {@link Predicate} with the specified name and value.
	 * 
	 * @param n The name of the new {@link Predicate}.
	 * @param v The value of the new {@link Predicate}.
	 */
	public Predicate( String n, String v ) {
		super(n);
		setValue( v );
	}

	/**
	 * Sets the value of the {@link Predicate}.
	 * 
	 * @param v The new value of the {@link Predicate}.
	 */
	public void setValue( String v ) {
		value = v;
	}
	
	/**
	 * Returns the value of the {@link Predicate}.
	 * 
	 * @return The value of the {@link Predicate}.
	 */
	public String getValue() {
		return value;
	}
	
	public String toXml() {
		StringBuffer buf = new StringBuffer();
		buf.append( "<" );
		buf.append( PREDICATE );
		buf.append( " " );
		buf.append( NAME );
		buf.append( "=\"" );
		String n = getName();
		buf.append( n != null ? n : "" );
		buf.append( "\" " );
		buf.append( VALUE );
		buf.append( "=\"" );
		Object v = getValue();
		buf.append( v != null ? v : "" );
		buf.append( "\"/>" );
		return buf.toString();
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append( PREDICATE );
		buf.append( ": " );
		buf.append( getName());
		buf.append( "=" );
		buf.append( getValue());
		return buf.toString();
	}
} // Predicate
