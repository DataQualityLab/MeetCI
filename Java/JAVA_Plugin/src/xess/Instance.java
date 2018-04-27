//
// $Id: $
//
package xess;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * An {@link Instance} is a stateful object within an {@link Xess} system
 * that contains real values for the fields defined in its parent 
 * {@link Struct}.  Each {@link Struct} may have many {@link Instance 
 * Instances}, each with separate values for each {@link Field}.  An 
 * {@link Instance} inherits default values from its parent {@link Struct}, if
 * specified, but can specify independent values for each {@link Field} as 
 * well.
 *
 * @author rstjacques
 */
public class Instance extends Fact {
	/**
	 * Error message generated if an attempt is made to set a {@link Field} 
	 * that is not defined in the parent {@link Struct}.
	 */
	private static final String ERROR_NO_FIELD = 
		"Error: A field with the specified name does not exist in the parent structure: ";
	
	/**
	 * Error message generated if an attempt is made to construct an 
	 * {@link Instance} with a null parent {@link Struct}.
	 */
	private static final String ERROR_NULL_STRUCT =
		"Error: A new instance cannot be created with a null type.";

	/**
	 * The parent {@link Struct}.
	 */
	private final Struct type;
	
	/**
	 * The {@link Map} of {@link Field Fields} that have been set on the
	 * {@link Instance}.
	 */
	private final Map<String,Field> fields;
	
	/**
	 * Creates a new {@link Instance} with the specified parent 
	 * {@link Struct}.  The parent {@link Struct} cannot be null.
	 * 
	 * @param t The parent {@link Struct} for the new {@link Instance}.  This
	 * cannot be a null value.
	 */
	public Instance( Struct t ) {
		this( null, t );
	}

	/**
	 * Creates a new {@link Instance} with the specified parent 
	 * {@link Struct}.  The parent {@link Struct} cannot be null.
	 * 
	 * @param n The name of the {@link Instance}.
	 * @param t The parent {@link Struct} for the new {@link Instance}.  This
	 * cannot be a null value.
	 */
	public Instance( String n, Struct t ) {
		super( n );
		if( t == null ) {
			throw new IllegalArgumentException(	ERROR_NULL_STRUCT );
		}
		type = t;
		fields = new HashMap<String,Field>();
	}

	/**
	 * Gets the {@link Field} with the specified name.  If the {@link Field} 
	 * has not yet been set on the {@link Instance}, the default value of the
	 * {@link Field} as specified in the parent {@link Struct} is returned
	 * instead.
	 * 
	 * @param name The name of the {@link Field} to retrieve.
	 * 
	 * @return The {@link Field} with the specified name.
	 * 
	 * @exception IllegalArgumentException If no {@link Field} with the
	 * specified name exists in the {@link Instance} or the parent 
	 * {@link Struct}.
	 */
	public synchronized Field getField( String name ) {
		synchronized( fields ) {
			Field f;
			//get the field from the parent struct
			Field typeField = type.getField( name );
			if( typeField != null ) {
				//check to see if the field has been set locally
				f = fields.get( name );
				if( f == null ) {
					//create a new field with the default values
					f = new Field( typeField.getName(), typeField.getType(),
						typeField.getValue());
					fields.put( name, f );
				}
			}
			else {
				//remove the field if it exists in the instance (was removed
				//from the parent struct)
				fields.remove( name );
				//throw an exception
				throw new IllegalArgumentException( ERROR_NO_FIELD + name );
			}
			//return the field
			return f;
		}
	}
	
	/**
	 * Sets the specified {@link Field} on the {@link Instance}.
	 * 
	 * @param f The {@link Field} to set on the {@link Instance}.
	 * 
	 * @exception IllegalArgumentException If the {@link Field} with the
	 * specified name does not exist in the parent {@link Struct}.
	 */
	public void setField( Field f ) {
		synchronized( fields ) {
			Field typeField = type.getField( f.getName());
			if( typeField == null ) {
				throw new IllegalArgumentException( ERROR_NO_FIELD + 
					f.getName());
			}
			else {
				fields.put( f.getName(), f );
			}
		}
	}
	
	/**
	 * Returns the {@link Collection} of {@link Field Fields} contained in
	 * the {@link Instance}.  Only those {@link Field Fields} that have been
	 * set on the {@link Instance} and still exist in the parent 
	 * {@link Struct} are returned.
	 * 
	 * @return A {@link Collection} of {@link Field Fields} that have been set
	 * on the {@link Instance}.
	 */
	public Collection<Field> getFields() {
		Set<Field> copy = new HashSet<Field>();
		synchronized( fields ) {
			Iterator<String> it = fields.keySet().iterator();
			while( it.hasNext()) {
				String name = it.next();
				if( type.getField( name ) != null ) {
					copy.add( fields.get( name ));
				}
				else {
					fields.remove( name );
				}
			}
		}
		return copy;
	}
	
	/**
	 * Returns the parent {@link Struct} that defines the type of 
	 * {@link Instance}.
	 * 
	 * @return The parent {@link Struct} that defines the type of
	 * {@link Instance}.
	 */
	public Struct getType() {
		return type;
	}
	
	public String toXml() {
		StringBuffer buf = new StringBuffer( "<" );
		buf.append( INSTANCE );
		buf.append( " " );
		buf.append( TYPE );
		buf.append( "=\"" );
		buf.append( getType().getName());
		buf.append( "\">" );
		Iterator<Field> it = getFields().iterator();
		while( it.hasNext()) {
			Field f = it.next();
			buf.append( f.toXml());
		}
		buf.append( "</" );
		buf.append( INSTANCE );
		buf.append( ">" );
		return buf.toString();
	}
} // Instance
