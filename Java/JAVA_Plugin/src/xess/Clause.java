//
// $Id: $
//
package xess;

/**
 * The abstract parent of all clauses; a clause is a conditional statement
 * within a rule that evaluates to true or false.
 *
 * @author rstjacques
 */
public abstract class Clause implements XmlElement {
	/**
	 * A description of the {@link Clause}.
	 */
	private String description;
	
	/**
	 * Creates a new {@link Clause} with a null description.
	 */
	public Clause() {
		this( null );
	}
	
	/**
	 * Creates a new {@link Clause} with the specified description.
	 * 
	 * @param desc The description of this {@link Clause}.
	 */
	public Clause( String desc ) {
		setDescription( desc );
	}
	
	/**
	 * Returns the {@link String} describing the {@link Clause}.  This value
	 * may be null as descriptions are optional.
	 * 
	 * @return The description of the {@link Clause}.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the {@link String} describing the {@link Clause} to the specified
	 * value.  This value may be null as descriptions are optional.
	 * 
	 * @param desc The description of the {@link Clause}.
	 */
	public void setDescription( String desc ) {
		description = desc;
	}
	
	/**
	 * Returns the name of the {@link Clause}.
	 * 
	 * @return The name of the {@link Clause}.
	 */
	public abstract String getName();
} // Clause
