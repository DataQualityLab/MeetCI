//
// $Id: $
//
package xess;

/**
 * An {@link Equal} is a {@link Clause} that is satisfied when the 
 * {@link SimpleClause#getValue1() first value} is exactly equal to the
 * {@link SimpleClause#getValue2() second value} of the {@link Equal}.  
 *
 * @author rstjacques
 */
public class Equal extends SimpleClause {

	/**
	 * Creates a new {@link Equal} with the specified values. The values of 
	 * the {@link Equal} must be equal in order to satisfy the {@link Clause}.
	 * 
	 * @param v1 The first value of the {@link Equal}.
	 * @param v2 The second value of the {@link Equal}.
	 */
	public Equal( String v1, String v2 ) {
		super( v1, v2 );
	}

	/**
	 * Creates a new {@link Equal} with the specified description and values.
	 * The values of the {@link Equal} must be equal in order to satisfy the 
	 * {@link Clause}.
	 * 
	 * @param desc The description of the {@link Equal}.
	 * @param v1 The first value of the {@link Equal}.
	 * @param v2 The second value of the {@link Equal}.
	 */
	public Equal( String desc, String v1, String v2 ) {
		super( desc, v1, v2 );
	}

	public String getName() {
		return XessParser.EQUAL;
	}
} // Equal
