//
// $Id: $
//
package xess;

/**
 * The {@link Field} class represents a value within a {@link Struct}, an
 * {@link Instance}, or a {@link SetInstanceAction}.  {@link Field Fields} are
 * typically name/value pairs but in some cases may also include type 
 * information or a default value.
 *
 * @author rstjacques
 */
public class Field implements XmlElement {
	/**
	 * The name of the {@link Field}.
	 */
	private String name;
	
	/**
	 * The type of the {@link Field}; this is rarely used.
	 */
	private String type;
	
	/**
	 * The value of the {@link Field}; in some cases this may be used to 
	 * specify a default value for the {@link Field} (as in a {@link Struct}).
	 */
	private String value;
	
	/**
	 * Creates a new {@link Field} with null properties.
	 */
	public Field() {
		this( null, null, null );
	}
	
	/**
	 * Creates a new {@link Field} with the specified properties.
	 * 
	 * @param n The name of the {@link Field}.
	 * @param t The type of {@link Field}; rarely used.
	 * @param v The value of the {@link Field}.
	 */
	public Field( String n, String t, String v ) {
		setName( n );
		setType( t );
		setValue( v );
	}

	/**
	 * Returns the name of the {@link Field}.  This name should be unique 
	 * within the context of the {@link Field}.  For example, {@link Field
	 * Fields} should be uniquely named within the same {@link Struct}, but
	 * different {@link Struct Structs} may have {@link Field Fields} with the
	 * same name.
	 * 
	 * @return The name of the {@link Field}.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the {@link Field} to the specified value.  This name
	 * should be unique within the context of the {@link Field}.  For example,
	 * {@link Field Fields} should be uniquely named within the same 
	 * {@link Struct}, but different {@link Struct Structs} may have 
	 * {@link Field Fields} with the same name.
	 * 
	 * @param n The new name of the {@link Field}.
	 */
	public void setName( String n ) {
		name = n;
	}
	
	/**
	 * Returns the {@link Field} type.  Because {@link Xess} does not 
	 * generally validate {@link Field} types (this task is best left to the
	 * {@link XessPlugin plug-ins} this field is rarely used as anything more
	 * than a comment.
	 * 
	 * @return The type of the {@link Field}.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the {@link Field} type to the specified value.  Because 
	 * {@link Xess} does not generally validate {@link Field} types (this
	 * task is best left to the {@link XessPlugin plug-ins} this field is
	 * rarely used as anything more than a comment.
	 * 
	 * @param t The type of the {@link Field}.
	 */
	public void setType( String t ) {
		type = t;
	}
	
	/**
	 * Returns the current value of the {@link Field} as a {@link String}.
	 * 
	 * @return The current value of the {@link Field} as a {@link String}.
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the current value of the {@link Field} to the specified value.
	 * 
	 * @param v The new value of the {@link Field}.
	 */
	public void setValue( String v ) {
		value = v;
	}
	
	/**
	 * Returns true iff the specified {@link Object} is a {@link Field} with
	 * the same {@link #getName() name} as this {@link Field}.
	 * 
	 * @param obj The {@link Object} to which the {@link Field} is compared.
	 * 
	 * @return True iff the specified {@link Object} is a {@link Field} with
	 * the same {@link #getName() name} as this {@link Field}.
	 */
	public boolean equals( Object obj ) {
		boolean isEqual = false;
		if( obj instanceof Field ) {
			Field f = ( Field )obj;
			isEqual = f.getName().equals( getName());
		}
		return isEqual;
	}
	
	public String toXml() {
		StringBuffer b = new StringBuffer( "<" );
		b.append( XessParser.FIELD );
		b.append( " " );
		b.append( XessParser.NAME );
		b.append( "=\"" );
		b.append( getName());
		b.append( "\" " );
		b.append( XessParser.TYPE );
		b.append( "=\"" );
		b.append( getType());
		b.append( "\" " );
		b.append( XessParser.VALUE );
		b.append( "=\"" );
		b.append( getValue());
		b.append( "\"/>" );
		return b.toString();
	}
} // Field
