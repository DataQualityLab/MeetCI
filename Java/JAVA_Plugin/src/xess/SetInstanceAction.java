//
// $Id: $
//
package xess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link Action Actions} are used in the <b>{@link Rule#getThenActions() 
 * then}</b> and <b>{@link Rule#getElseActions() else}</b> parts of
 * a {@link Rule}.  The {@link SetInstanceAction} indicates that an 
 * {@link Instance} in the system should be set or modified as the result of
 * the evaluation of a {@link Rule}.  The 
 * {@link SetInstanceAction#getType() type} in the {@link SetInstanceAction}
 * determines the type of the {@link Instance} to be set or modified; this may
 * refer to a specified {@link Instance} in the system, or even one of the 
 * parameters passed into the {@link Rule}.  Note that it is possible for the
 * name to match multiple entities within the system; in this case the normal 
 * rules of scope apply (first the {@link Rule#getParameters() parameters} are
 * checked, then the system-level {@link Instance instances}.<P>
 *
 * @author rstjacques
 */
public class SetInstanceAction implements Action {
	/**
	 * The {@link List} of {@link Field Fields} that should be set on the 
	 * {@link Instance} if the {@link SetInstanceAction} is invoked.
	 */
	private final List<Field> fields;
	
	/**
	 * The type of {@link Instance} that should be created or modified.  This
	 * should correspond with the {@link Struct#getName() name} of an existing
	 * {@link Struct}.
	 */
	private String type;
	
	/**
	 * Creates a new {@link SetInstanceAction} with a blank name and no fields.
	 */
	public SetInstanceAction() {
		this( null );
	}

	/**
	 * Creates a new {@link SetInstanceAction} with the specified 
	 * {@link Struct#getName() type}.
	 * 
	 * @param t The type of {@link Instance} that should be created or 
	 * modified.  This should correspond with the 
	 * {@link Struct#getName() name} of an existing {@link Struct}.
	 */
	public SetInstanceAction( String t ) {
		fields = new LinkedList<Field>();
		setType( t );
	}
	
	/**
	 * Sets the type of {@link Instance} that should be created or modified.
	 * This should correspond with the {@link Struct#getName() name} of an 
	 * existing {@link Struct}.
	 * 
	 * @param t The value to which the type should be set.
	 */
	public void setType( String t ) {
		type = t;
	}
	
	/**
	 * Returns the type of {@link Instance} that should be created or 
	 * modified.
	 * 
	 * @return The type of {@link Instance} that should be created or
	 * modified.
	 * 
	 * @see #setType(String).
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Returns the {@link Field} with the specified name. 
	 * 
	 * @param name The name of the {@link Field} to retrieve.
	 * 
	 * @return The {@link Field} with the specified name, if it exists.
	 */
	public Field getField( String name ) {
		Field f = null;
		synchronized( fields ) {
			Iterator<Field> it = fields.iterator();
			while( f == null && it.hasNext()) {
				Field tmp = it.next();
				if( tmp.getName().equals( name )) {
					f = tmp;
				}
			}
		}
		return f;
	}
	
	/**
	 * Sets a {@link Field} on the {@link SetInstanceAction}.  Each 
	 * {@link Field} will be used to set a value on the {@link Instance} that
	 * is created or modified.
	 *   
	 * @param f The {@link Field} to set on the {@link SetInstanceAction}.
	 */
	public void setField( Field f ) {
		synchronized( fields ) {
			fields.add( f );
		}
	}
	
	/**
	 * Returns the {@link Collection} of {@link Field Fields} that will be set
	 * on the {@link Instance} that is created or modified as a result of the
	 * invokation of the {@link SetInstanceAction}.
	 * 
	 * @return The {@link Collection} of {@link Field Fields} that will be set
	 * on the {@link Instance}.
	 */
	public Collection<Field> getFields() {
		synchronized( fields ) {
			List<Field> f = new ArrayList<Field>( fields.size());
			f.addAll( fields );
			return f;
		}
	}
	
	public String toXml() {
		StringBuffer buf = new StringBuffer( "<" );
		buf.append( SET_INSTANCE );
		buf.append( " " );
		buf.append( TYPE );
		buf.append( "=\"" );
		buf.append( getType());
		buf.append( "\">" );
		synchronized( fields ) {
			Iterator<Field> it = getFields().iterator();
			while( it.hasNext()) {
				Field f = it.next();
				buf.append( "<" );
				buf.append( FIELD );
				buf.append( " " );
				buf.append( NAME );
				buf.append( "=\"" );
				buf.append( f.getName());
				buf.append( "\" " );
				buf.append( VALUE );
				buf.append( "=\"" );
				buf.append( f.getValue());
				buf.append( "\"/>" );
			}
		}
		buf.append( "</" );
		buf.append( SET_INSTANCE );
		buf.append( ">" );
		return buf.toString();
	}
} // SetInstanceAction
