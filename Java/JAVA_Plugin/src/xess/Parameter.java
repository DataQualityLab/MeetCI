//
// $Id: $
//
package xess;

/**
 * The {@link Parameter} class is used to define the input to a {@link Rule}.
 * Each {@link Rule} may contain zero or more {@link Parameter Parameters}.
 *
 * @author rstjacques
 */
public class Parameter implements XmlElement {
	/**
	 * The name of the {@link Parameter}.  This is used to refer to the
	 * {@link Parameter} from inside the {@link Rule}.
	 */
	private String name;
	
	/**
	 * The type of {@link Parameter}; this is used to specify the type of the
	 * expected {@link Parameter} so that the {@link Rule} can be generated
	 * accordingly.
	 */
	private String type;
	
	/**
	 * Creates a new {@link Parameter} with a null name, and a null type.
	 */
	public Parameter() {
		this( null, null );
	}
	
	/**
	 * Creates a new {@link Parameter} with the specified name and type.
	 * 
	 * @param n The name of the {@link Parameter}.  This is used to refer to 
	 * the {@link Parameter} from inside the {@link Rule}.
	 * @param t The type of {@link Parameter}; this is used to specify the 
	 * type of the expected {@link Parameter} so that the {@link Rule} can be
	 * generated accordingly.
	 */
	public Parameter( String n, String t ) {
		setName( n );
		setType( t );
	}

	/**
	 * Returns the name of the {@link Parameter}.  The name of the 
	 * {@link Parameter}.  This is used to refer to the {@link Parameter} from
	 * inside the {@link Rule}.
	 * 
	 * @return The name of the {@link Parameter}.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the {@link Parameter}.  The name of the 
	 * {@link Parameter}.  This is used to refer to the {@link Parameter} from
	 * inside the {@link Rule}.
	 * 
	 * @param n The value to which the name should be set.
	 */
	public void setName( String n ) {
		name = n;
	}
	
	/**
	 * Returns the type of the {@link Parameter}.  This is used to specify the
	 * type of the expected {@link Parameter} so that the {@link Rule} can be 
	 * generated accordingly.
	 * 
	 * @return The type of the {@link Parameter}.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the {@link Parameter}.  This is used to specify the
	 * type of the expected {@link Parameter} so that the {@link Rule} can be 
	 * generated accordingly.
	 * 
	 * @param t The value to which the type should be set.
	 */
	public void setType( String t ) {
		type = t;
	}
	
	/**
	 * Returns true iff the specified {@link Object} is a {@link Parameter}
	 * with the same {@link #getName() name} as this {@link Parameter}; 
	 * otherwise returns false.
	 * 
	 * @param obj The {@link Object} to which the {@link Parameter} should be
	 * compared.
	 * 
	 * @return True if the specified {@link Object} is a {@link Parameter} 
	 * with the same {@link #getName() name} as this {@link Parameter}; 
	 * otherwise returns false.
	 */
	public boolean equals( Object obj ) {
		boolean isEqual = false;
		if( obj instanceof Parameter ) {
			Parameter p = ( Parameter )obj;
			isEqual = p.getName().equals( getName());
		}
		return isEqual;
	}
	
	public String toXml() {
		StringBuffer b = new StringBuffer( "<" );
		b.append( XessParser.PARAMETER );
		b.append( " " );
		b.append( XessParser.NAME );
		b.append( "=\"" );
		b.append( getName());
		b.append( "\" " );
		b.append( XessParser.TYPE );
		b.append( "=\"" );
		b.append( getType());
		b.append( "\"/>" );
		return b.toString();
	}
} // Parameter

