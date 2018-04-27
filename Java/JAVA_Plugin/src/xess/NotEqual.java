//
// $Id: $
//
package xess;

/**
 * A {@link NotEqual} negates an {@link Equal}; it is a {@link Clause} that
 * is satisfied when the {@link SimpleClause#getValue1() first value} is not
 * equal to the {@link SimpleClause#getValue2() second value} of the 
 * {@link NotEqual}.  
 *
 * @author rstjacques
 */
public class NotEqual extends SimpleClause {

	/**
	 * Creates a new {@link NotEqual} with the specified values.  The values 
	 * of the {@link NotEqual} must not be equal in order to satisfy the 
	 * {@link Clause}.
	 * 
	 * @param v1 The first value of the {@link NotEqual}.
	 * @param v2 The second value of the {@link NotEqual}.
	 */
	public NotEqual( String v1, String v2 ) {
		this( null, v1, v2 );
	}

	/**
	 * Creates a new {@link NotEqual} with the specified description and 
	 * values.  The values of the {@link NotEqual} must not be equal in order
	 * to satisfy the {@link Clause}.
	 * 
	 * @param desc The description of the {@link NotEqual}.
	 * @param v1 The first value of the {@link NotEqual}.
	 * @param v2 The second value of the {@link NotEqual}.
	 */
	public NotEqual( String desc, String v1, String v2 ) {
		super( desc, v1, v2 );
	}

	public String getName() {
		return NOT_EQUAL;
	}
} // NotEqual
