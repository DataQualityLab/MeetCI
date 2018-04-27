//
// $Id: $
//
package xess;

/**
 * A {@link GreaterThan} is a {@link Clause} that is satisfied when the 
 * {@link SimpleClause#getValue1() first value} is greater than the 
 * {@link SimpleClause#getValue2() second value} of the {@link GreaterThan}. 
 *
 * @author rstjacques
 */
public class GreaterThan extends SimpleClause {
	/**
	 * Creates a new {@link GreaterThan} with the specified values.  The first
	 * value of the {@link GreaterThan} must be strictly greater than the 
	 * second value in order to satisfy the {@link Clause}.
	 * 
	 * @param v1 The first value of the {@link GreaterThan}.
	 * @param v2 The second value of the {@link GreaterThan}.
	 */
	public GreaterThan( String v1, String v2 ) {
		this( null, v1, v2 );
	}

	/**
	 * Creates a new {@link GreaterThan} with the specified description and 
	 * values.  The first value of the {@link GreaterThan} must be strictly 
	 * greater than the second value in order to satisfy the {@link Clause}.
	 * 
	 * @param desc The description of the {@link GreaterThan}.
	 * @param v1 The first value of the {@link GreaterThan}.
	 * @param v2 The second value of the {@link GreaterThan}.
	 */
	public GreaterThan( String desc, String v1, String v2 ) {
		super( desc, v1, v2 );
	}
	
	public String getName() {
		return GREATER_THAN;
	}
} // GreaterThan
