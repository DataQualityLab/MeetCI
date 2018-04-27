//
// $Id: $
//
package xess;

/**
 * A {@link SimpleClause} that is satisfied if the 
 * {@link SimpleClause#getValue1() first value} is less than or equal to the
 * {@link SimpleClause#getValue2() second value} of the clause.
 *
 * @author rstjacques
 */
public class LessThanOrEqual extends SimpleClause {

	/**
	 * Creates a new {@link LessThanOrEqual} with the specified values.  The 
	 * first value to the {@link LessThanOrEqual} must be less than or 
	 * equal to the second value in order to satisfy the {@link Clause}.
	 * 
	 * @param v1 The first value of the {@link LessThanOrEqual}.
	 * @param v2 The second value of the {@link LessThanOrEqual}.
	 */
	public LessThanOrEqual( String v1, String v2 ) {
		super( v1, v2 );
	}

	/**
	 * Creates a new {@link LessThanOrEqual} with the specified description
	 * and values.  The first value to the {@link LessThanOrEqual} must be 
	 * less than or equal to the second value in order to satisfy the 
	 * {@link Clause}.
	 * 
	 * @param desc The description of the {@link LessThanOrEqual}.
	 * @param v1 The first value of the {@link LessThanOrEqual}.
	 * @param v2 The second value of the {@link LessThanOrEqual}.
	 */
	public LessThanOrEqual( String desc, String v1, String v2 ) {
		super( desc, v1, v2 );
	}

	public String getName() {
		return LESS_THAN_OR_EQUAL;
	}
} // LessThanOrEqual
