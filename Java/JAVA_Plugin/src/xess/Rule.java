//
// $Id: $
//
package xess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * An {@link Xess} system is composed of a knowledge base (which itself is 
 * composed from {@link Fact Facts}), and a set of {@link Rule Rules} that 
 * operate on those {@link Fact Facts}.  The {@link Rule} class defines the
 * properties that make up an {@link Xess} {@link Rule}. 
 *
 * @author rstjacques
 */
public class Rule implements XmlElement {
	/**
	 * Each {@link Rule} has a single <i>if {@link Clause}</i>.  If the <i>if
	 * {@link Clause}</i> is satisfied, the {@link #getThenActions() then 
	 * action(s)} will be executed.  If the <i>if {@link Clause}</i> fails to
	 * be satisfied, the {@link #getElseActions() else action(s)} will be
	 * executed (if any). 
	 */
	private Clause ifClause;
	
	/**
	 * A {@link Collection} of {@link Parameter Parameters} that define the
	 * expected input to the {@link Rule}.
	 */
	private final Collection<Parameter> parameters;
	
	/**
	 * A {@link Collection} of {@link Action Actions} that will be taken if 
	 * the <i>if {@link Clause}</i> is satisfied.
	 */
	private final Collection<Action> thenActions;
	
	/**
	 * A {@link Collection} of {@link Action Actions} that will be taken if 
	 * the <i>if {@link Clause}</i> fails to be satisfied.
	 */
	private final Collection<Action> elseActions;
	
	/**
	 * The name of the {@link Rule}; this name must be unique within the 
	 * {@link Xess} to which the {@link Rule} belongs.
	 */
	private final String name;
	
	/**
	 * Creates a new {@link Rule} with the specified name.
	 * 
	 * @param n The name of the new {@link Rule}.
	 */
	public Rule( String n ) {
		name = n;
		parameters = new HashSet<Parameter>();
		thenActions = new LinkedList<Action>();
		elseActions = new LinkedList<Action>();
	}

	public String toXml() {
		//open the rule tag
		StringBuffer buf = new StringBuffer( "<" );
		buf.append( RULE );
		buf.append( " " );
		buf.append( NAME );
		buf.append( "=\"" );
		buf.append( getName());
		buf.append( "\">" );
		//parameters
		synchronized( parameters ) {
			for( Parameter p : parameters ) {
				buf.append( p.toXml());
			}
		}
		//if clause
		Clause c = getIfClause();
		buf.append( "<" );
		buf.append( IF );
		buf.append( ">" );
		buf.append( c.toXml());
		buf.append( "</" );
		buf.append( IF );
		buf.append( ">" );
		//then
		synchronized( thenActions ) {
			Iterator<Action> it = thenActions.iterator();
			if( it.hasNext()) {
				buf.append( "<" );
				buf.append( THEN );
				buf.append( ">" );
				while( it.hasNext()) {
					Action action = it.next();
					buf.append( action.toXml());
				}
				buf.append( "</" );
				buf.append( THEN );
				buf.append( ">" );
			}
		}
		//else
		synchronized( elseActions ) {
			Iterator<Action> it = elseActions.iterator();
			if( it.hasNext()) {
				buf.append( "<" );
				buf.append( ELSE );
				buf.append( ">" );
				while( it.hasNext()) {
					Action action = it.next();
					buf.append( action.toXml());
				}
				buf.append( "</" );
				buf.append( ELSE );
				buf.append( ">" );
			}
		}
		//close the rule tag
		buf.append( "</" );
		buf.append( RULE );
		buf.append( ">" );
		
		return buf.toString();
	}
	
	public String getName() {
		return name;
	}
	
	//
	// parameters
	//
	
	/**
	 * Sets the specified {@link Parameter} on the {@link Rule}.  If no other
	 * {@link Parameter Parameters} with the specified name exist, the new
	 * {@link Parameter} is added.  If a {@link Parameter} with the specified
	 * name does already exist, it is replaced by the new {@link Parameter}.
	 * 
	 * @param p The {@link Parameter} to set on the {@link Rule}.
	 */
	public void setParameter( Parameter p ) {
		synchronized( parameters ) {
			parameters.add( p );
		}
	}
	
	/**
	 * Returns a {@link Collection} containing the current {@link Parameter
	 * Parameters} for the {@link Rule}.
	 * 
	 * @return A {@link Collection} containing the current {@link Parameter
	 * Parameters} for the {@link Rule}. 
	 */
	public Collection<Parameter> getParameters() {
		synchronized( parameters ) {
			return new HashSet<Parameter>( parameters );
		}
	}
	
	/**
	 * Removes the specified {@link Parameter} from the set of 
	 * {@link Parameter Parameters} for the {@link Rule}.
	 * 
	 * @param p The {@link Parameter} to remove from the {@link Rule}.
	 */
	public void removeParameter( Parameter p ) {
		synchronized( parameters ) {
			parameters.remove( p );
		}
	}
	
	//
	// if clause
	//
	
	/**
	 * Sets the <i>if {@link Clause}</i> for the {@link Rule}.  Each 
	 * {@link Rule} has a single <i>if {@link Clause}</i>.  If the <i>if
	 * {@link Clause}</i> is satisfied, the {@link #getThenActions() then 
	 * action(s)} will be executed.  If the <i>if {@link Clause}</i> fails to
	 * be satisfied, the {@link #getElseActions() else action(s)} will be
	 * executed (if any). 
	 * 
	 * @param ifc The value to which the <i>if {@link Clause}</i> should be 
	 * set.  This value should not be null.
	 */
	public void setIfClause( Clause ifc ) {
		ifClause = ifc;
	}
	
	/**
	 * Returns the <i>if {@link Clause}</i> for the {@link Rule}.
	 * 
	 * @return The <i>if {@link Clause}</i> for the {@link Rule}.
	 * 
	 * @see #setIfClause(Clause).
	 */
	public Clause getIfClause() {
		return ifClause;
	}
	
	//
	// then actions
	//
	
	/**
	 * Adds the specified {@link Action} to the {@link Collection} of
	 * {@link Action Actions} that will be executed in the event that the
	 * {@link #getIfClause() if clause} is satisfied.
	 * 
	 * @param a The {@link Action} that should be added to the 
	 * {@link Collection} of <i>then {@link Action Actions}</i>.
	 */
	public void addThenAction( Action a ) {
		synchronized( thenActions ) {
			thenActions.add( a );
		}
	}
	
	/**
	 * Removes the specified {@link Action} from the {@link Collection} of
	 * {@link Action Actions} that will be executed in the event that the
	 * {@link #getIfClause() if clause} is satisfied.
	 * 
	 * @param a The {@link Action} that should be removed from the 
	 * {@link Collection} of <i>then {@link Action Actions}</i>.
	 */
	public void removeThenAction( Action a ) {
		synchronized( thenActions ) {
			thenActions.remove( a );
		}
	}
	
	/**
	 * Returns the {@link Collection} of {@link Action Actions} that will be
	 * executed in the event that the {@link #getIfClause() if clause} is 
	 * satisfied.
	 * 
	 * @return The {@link Collection} of <i>then {@link Action Actions}</i>.
	 */
	public Collection<Action> getThenActions() {
		synchronized( thenActions ) {
			return new ArrayList<Action>( thenActions );
		}
	}
	
	/**
	 * Clears all of the current <i>then {@link Action Actions}</i> from the
	 * {@link Rule}.
	 */
	public void clearThenActions() {
		synchronized( thenActions ) {
			thenActions.clear();
		}
	}
	
	//
	// else actions
	//
	
	/**
	 * Adds the specified {@link Action} to the {@link Collection} of
	 * {@link Action Actions} that will be executed in the event that the
	 * {@link #getIfClause() if clause} fails to be satisfied.
	 * 
	 * @param a The {@link Action} that should be added to the 
	 * {@link Collection} of <i>else {@link Action Actions}</i>.
	 */
	public void addElseAction( Action a ) {
		synchronized( elseActions ) {
			elseActions.add( a );
		}
	}
	
	/**
	 * Removes the specified {@link Action} from the {@link Collection} of
	 * {@link Action Actions} that will be executed in the event that the
	 * {@link #getIfClause() if clause} fails to be satisfied.
	 * 
	 * @param a The {@link Action} that should be removed from the 
	 * {@link Collection} of <i>else {@link Action Actions}</i>.
	 */
	public void removeElseAction( Action a ) {
		synchronized( elseActions ) {
			elseActions.remove( a );
		}
	}
	
	/**
	 * Returns the {@link Collection} of {@link Action Actions} that will be
	 * executed in the event that the {@link #getIfClause() if clause} fails 
	 * to be satisfied.
	 * 
	 * @return The {@link Collection} of <i>else {@link Action Actions}</i>.
	 */
	public Collection<Action> getElseActions() {
		synchronized( elseActions ) {
			return new ArrayList<Action>( elseActions );
		}
	}
	
	/**
	 * Clears all of the current <i>else {@link Action Actions}</i> from the
	 * {@link Rule}.
	 */
	public void clearElseActions() {
		synchronized( elseActions ) {
			elseActions.clear();
		}
	}
}  // Rule
