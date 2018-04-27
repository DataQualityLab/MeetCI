//
// $Id: $
//
package xess;

import java.util.Collection;

/**
 * A {@link Clause} that is only satisfied if every {@link Clause sub-clause}
 * is satisfied.
 *
 * @author rstjacques
 */
public class And extends ClauseList {
	/**
	 * Creates a new {@link And} with the specified {@link Collection} of
	 * {@link Clause sub-clauses}; all of the {@link Clause sub-clauses} must
	 * be satisfied for the {@link And} to be satisfied. 
	 * 
	 * @param c The {@link Collection} of {@link Clause sub-clauses} that must
	 * be satisfied.
	 */
	public And( Collection<Clause> c ) {
		super( c );
	}

	/**
	 * Creates a new {@link And} with the specified description and 
	 * {@link Collection} of {@link Clause sub-clauses}; all of the 
	 * {@link Clause sub-clauses} must be satisfied for the {@link And} to be
	 * satisfied. 
	 * 
	 * @param desc The description of the {@link And}.
	 * @param c The {@link Collection} of {@link Clause sub-clauses} that must
	 * be satisfied.
	 */
	public And(String desc, Collection<Clause> c) {
		super( desc, c );
	}

	public String getName() {
		return AND;
	}
} // And
