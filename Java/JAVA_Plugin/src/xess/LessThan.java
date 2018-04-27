//
// $Id: $
//
package xess;

/**
 * A {@link LessThan} is a {@link Clause} that is satisfied when the 
 * {@link SimpleClause#getValue1() first value} is less than the 
 * {@link SimpleClause#getValue2() second value} of the {@link LessThan}. 
 *
 * @author rstjacques
 */
public class LessThan extends SimpleClause {
	/**
	 * Creates a new {@link LessThan} with the specified values.  The first 
	 * value to the {@link LessThan} must be strictly less than the second 
	 * value in order to satisfy the {@link Clause}.
	 * 
	 * @param v1 The first value of the {@link LessThan}.
	 * @param v2 The second value of the {@link LessThan}.
	 */
	public LessThan( String v1, String v2 ) {
		this( null, v1, v2 );
	}

	/**
	 * Creates a new {@link LessThan} with the specified description and 
	 * values.  The first value to the {@link LessThan} must be strictly less
	 * than the second value in order to satisfy the {@link Clause}.
	 * 
	 * @param desc The description of the {@link LessThan}.
	 * @param v1 The first value of the {@link LessThan}.
	 * @param v2 The second value of the {@link LessThan}.
	 */
	public LessThan( String desc, String v1, String v2 ) {
		super( desc, v1, v2 );
	}

	public String getName() {
		return LESS_THAN;
	}
} // LessThan
