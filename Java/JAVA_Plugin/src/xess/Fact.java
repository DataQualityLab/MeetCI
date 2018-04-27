//
// $Id: $
//
package xess;

/**
 * A {@link Fact} is an unconditional value in the system.  {@link Fact Facts}
 * may be as simple as <tt>X = Y</tt> or be specified as more complicated 
 * relations that establish a relationship between an unbounded set of atoms.  
 * The abstract {@link Fact} class is the parent of more specialized types of
 * {@link Fact Facts} that make up an expert system.
 *
 * @author rstjacques
 */
public abstract class Fact implements XmlElement {
	/**
	 * The name of the {@link Fact}.
	 */
	private String name;
	
	/**
	 * Creates a new {@link Fact} with a null name.
	 */
	public Fact() {
		this( null );
	}
	
	/**
	 * Creates a new {@link Fact} with the specified name.
	 * 
	 * @param n The name of the new {@link Fact}.
	 */
	public Fact( String n ) {
		setName( n );
	}

	/**
	 * Returns the name of the {@link Fact}.
	 * 
	 * @return The name of the {@link Fact}.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the {@link Fact} to the specified value.
	 * 
	 * @param n The new name for the {@link Fact}.
	 */
	public void setName( String n ) {
		name = n;
	}
} // Fact
