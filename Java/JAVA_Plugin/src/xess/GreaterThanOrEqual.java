//
// $Id: $
//
package xess;

/**
 * A {@link GreaterThanOrEqual} is a {@link Clause} that is satisfied when the
 * {@link SimpleClause#getValue1() first value} is greater than or equal to 
 * the {@link SimpleClause#getValue2() second value} of the 
 * {@link GreaterThanOrEqual}.
 *
 * @author rstjacques
 */
public class GreaterThanOrEqual extends SimpleClause {
	/**
	 * Creates a new {@link GreaterThanOrEqual} with the specified values.  
	 * The first value to the {@link GreaterThanOrEqual} must be greater than
	 * or equal to the second value in order to satisfy the {@link Clause}.
	 * 
	 * @param v1 The first value of the {@link GreaterThanOrEqual}.
	 * @param v2 The first value of the {@link GreaterThanOrEqual}.
	 */
	public GreaterThanOrEqual( String v1, String v2 ) {
		this( null, v1, v2 );
	}

	/**
	 * Creates a new {@link GreaterThanOrEqual} with the specified description
	 * and values.  The first value to the {@link GreaterThanOrEqual} must be 
	 * greater than or equal to the second value in order to satisfy the 
	 * {@link Clause}.
	 * 
	 * @param desc The description of the {@link GreaterThanOrEqual}.
	 * @param v1 The first value of the {@link GreaterThanOrEqual}.
	 * @param v2 The first value of the {@link GreaterThanOrEqual}.
	 */
	public GreaterThanOrEqual( String desc, String v1, String v2 ) {
		super( desc, v1, v2 );
	}

	public String getName() {
		return GREATER_THAN_OR_EQUAL;
	}
} // GreaterThanOrEqual
