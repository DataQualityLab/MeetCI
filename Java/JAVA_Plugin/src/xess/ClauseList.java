//
// $Id: $
//
package xess;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A {@link ClauseList} is a {@link Clause} that contains a {@link Collection}
 * of {@link Clause sub-clauses}, some combination of which must be satisfied
 * in order to satisfy the {@link ClauseList}.
 *
 * @author rstjacques
 */
public abstract class ClauseList extends Clause {
	/**
	 * The {@link Clause sub-Clauses} of the {@link ClauseList}.
	 */
	private Collection<Clause> clauses;
	
	/**
	 * Creates a new {@link ClauseList} with the specified {@link Collection}
	 * of {@link Clause sub-Clauses}.
	 * 
	 * @param c The {@link Collection} of {@link Clause sub-Clauses}.
	 */
	public ClauseList( Collection<Clause> c ) {
		this( null, c );
	}

	/**
	 * Creates a new {@link ClauseList} with the specified description and 
	 * {@link Collection} of {@link Clause sub-Clauses}.
	 * 
	 * @param desc The descrition of the {@link ClauseList}.
	 */
	public ClauseList( String desc, Collection<Clause> c ) {
		super( desc );
		//copy the clauses
		clauses = new LinkedList<Clause>();
		setClauses( c );
	}
	
	/**
	 * Sets the {@link Collection} of {@link Clause sub-Clauses} that make up
	 * the {@link ClauseList} to the specified value.
	 * 
	 * @param c The {@link Collection} of {@link Clause sub-Clauses} that make
	 * up the {@link ClauseList}.
	 */
	public void setClauses( Collection<Clause> c ) {
		clauses.clear();
		clauses.addAll( c );
	}
	
	/**
	 * Returns the {@link Collection} of {@link Clause sub-Clauses} that make
	 * up the {@link ClauseList}.
	 * 
	 * @return The {@link Collection} of {@link Clause sub-Clauses} that make
	 * up the {@link ClauseList}.
	 */
	public Collection<Clause> getClauses() {
		return clauses;
	}
	
	/**
	 * Adds the specified {@link Clause} to the {@link Collection} of
	 * {@link Clause sub-Clauses} that make up the {@link ClauseList}.
	 * 
	 * @param clause The {@link Clause} to be added.
	 */
	public void addClause( Clause clause ) {
		clauses.add( clause );
	}
	
	/**
	 * Removes the specified {@link Clause} from the {@link Collection} of
	 * {@link Clause sub-Clauses} that make up the {@link ClauseList}.
	 * 
	 * @param clause The {@link Clause} to be removed.
	 */
	public void removeClause( Clause clause ) {
		clauses.remove( clause );
	}
	
	public String toXml() {
		StringBuffer buf = new StringBuffer();
		String n = getName();
		buf.append( "<" );
		buf.append( n );
		String d = getDescription();
		if( d != null ) {
			buf.append( " " );
			buf.append( XessParser.DESCRIPTION );
			buf.append( "=\"" );
			buf.append( d );
			buf.append( "\"" );
		}
		buf.append( ">" );
		Iterator<Clause> it = getClauses().iterator();
		while( it.hasNext()) {
			Clause subClause = it.next();
			buf.append( subClause.toXml());
		}
		buf.append( "</" );
		buf.append( n );
		buf.append( ">" );
		return buf.toString();
	}
} // ListClause
