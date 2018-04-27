//
// $Id: $
//
package xess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * A {@link Struct} is similar to a Java {@link Class}; it defines a structure
 * with a unique name and a collection of named {@link Field fields}.  Each
 * {@link Field field} has a name, and may specify a type and a default value.
 * Structs are instantiated as {@link Instance Instances} in an {@link Xess}
 * system.
 *
 * @author rstjacques
 */
public class Struct extends Fact {
	/**
	 * The {@link List} of {@link Field Fields} in the {@link Struct}.  Each
	 * {@link Field} has a name that is unique within the scope of the 
	 * {@link Struct}, and may also specify a type and a default value.
	 */
	private final List<Field> fields;
	
	/**
	 * Creates a new {@link Struct} with a blank {@link #getName() name} and
	 * no {@link Field fields}.
	 */
	public Struct() {
		this( null );
	}

	/**
	 * Creates a new {@link Struct} with the specified {@link #getName()}
	 * name} and no {@link Field fields}.
	 * 
	 * @param n The {@link #getName() name} of the {@link Struct}.
	 */
	public Struct( String n ) {
		super( n );
		fields = new LinkedList<Field>();
	}
	
	/**
	 * Returns the {@link Field} with the specified name, if it exists.
	 * 
	 * @param name The name of the {@link Field} to be retrieved.
	 * 
	 * @return The {@link Field} with the specified name, if it exists.
	 * 
	 * @see #setField(Field)
	 */
	public Field getField( String name ) {
		Field f = null;
		synchronized( fields ) {
			for( Field field : fields ) {
				if( field.getName().equals( name )) {
					f = field;
					break;
				}
			}
		}
		return f;
	}
	
	/**
	 * Sets the specified {@link Field} on the {@link Struct}.  If another
	 * {@link Field} with the same name already exists, it will be replaced
	 * by the new {@link Field}; otherwise the new {@link Field} is simply
	 * added to the {@link Struct}.
	 * 
	 * @param f The {@link Field} to set on the {@link Struct}.
	 */
	public void setField( Field f ) {
		synchronized( fields ) {
			int i = fields.indexOf( f );
			if( i >= 0 ) {
				fields.remove( i );
				fields.add( i, f );
			}
			else {
				fields.add( f );
			}
		}
	}
	
	/**
	 * Returns a {@link Collection} containing the {@link Field Fields} of the
	 * {@link Struct}.  
	 * 
	 * @return A {@link Collection} of the {@link Field Fields} of the 
	 * {@link Struct}.
	 */
	public Collection<Field> getFields() {
		synchronized( fields ) {
			List<Field> f = new ArrayList<Field>( fields );
			return f;
		}
	}
	
	/**
	 * Creates a new {@link Instance} of this {@link Struct}.  An 
	 * {@link Instance} inherits the defualt values for {@link Field fields}
	 * from the parent {@link Struct}.
	 * 
	 * @param n The {@link Instance#getName() name} of the new 
	 * {@link Instance}; this name should be unique among the 
	 * {@link Fact facts} in the {@link Xess} system, and should not be the
	 * same as the name of the {@link Struct}.
	 * 
	 * @return The newly created {@link Instance} with the specified name.
	 */
	public Instance newInstance( String n ) {
		return new Instance( n, this );
	}
	
	public String toXml() {
		StringBuffer buf = new StringBuffer( "<" );
		buf.append( STRUCT );
		buf.append( " " );
		buf.append( NAME );
		buf.append( "=\"" );
		buf.append( getName());
		buf.append( "\">" );
		synchronized( fields ) {
			for( Field field : getFields()) {
				buf.append( "<" );
				buf.append( FIELD );
				String type = field.getType();
				if( type != null ) {
					buf.append( " " );
					buf.append( TYPE );
					buf.append( "=\"" );
					buf.append( type );
					buf.append( "\"" );
				}
				String value = field.getValue();
				if( value != null ) {
					buf.append( " " );
					buf.append( INITIAL_VALUE );
					buf.append( "=\"" );
					buf.append( value );
					buf.append( "\"" );
				}
				buf.append( "/>" );
			}
		}
		buf.append( "</" );
		buf.append( STRUCT );
		buf.append( ">" );
		return buf.toString();
	}
} // Struct
