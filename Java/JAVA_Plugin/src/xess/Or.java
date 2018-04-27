//
// $Id: $
//
package xess;

import java.util.Collection;

/**
 * An {@link Or} is a {@link Clause} that is satisfied if one or more of the 
 * {@link Clause sub-clauses} is satisfied.
 *
 * @author rstjacques
 */
public class Or extends ClauseList {

	/**
	 * Creates a new {@link Or} with the specified {@link Collection} of
	 * {@link Clause sub-clauses}; one or more of the 
	 * {@link Clause sub-clauses} must be satisfied for the {@link Or} to be
	 * satisfied. 
	 * 
	 * @param c The {@link Collection} of {@link Clause sub-clauses}, at least
	 * one of which must be satisfied.
	 */
	public Or( Collection<Clause> c ) {
		super( c );
	}

	/**
	 * Creates a new {@link Or} with the specified description and 
	 * {@link Collection} of {@link Clause sub-clauses}; one or more of the
	 * {@link Clause sub-clauses} must be satisfied for the {@link Or} to be
	 * satisfied. 
	 * 
	 * @param c The {@link Collection} of {@link Clause sub-clauses}, at least
	 * one of which must be satisfied.
	 */
	public Or(String desc, Collection<Clause> c) {
		super( desc, c );
	}
	
	public String getName() {
		return OR;
	}
} // Or
