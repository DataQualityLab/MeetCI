//
// $Id: $
//
package xess;

/**
 * A {@link NotBetween} negates a {@link Between}; it is only satisfied if the
 * input value is less than the {@link Between#getMinimum() minimum} or 
 * greater than the {@link Between#getMaximum() maximum}.
 *
 * @author rstjacques
 */
public class NotBetween extends Between {
	/**
	 * Creates a new {@link NotBetween} with the specified minimum and maximum
	 * values.  The {@link NotBetween} is only satisfied when the input value
	 * is less than minimum value or greater than the maximum value.
	 * 
	 * @param min The minimum value.
	 * @param max The maximum value.
	 * @param value The value being checked against the min and the max.
	 */
	public NotBetween( String min, String max, String value ) {
		this( null, min, max, value );
	}

	/**
	 * Creates a new {@link NotBetween} with the specified description, and 
	 * minimum and maximum values.  The {@link NotBetween} is only satisfied
	 * when the input value is less than minimum value or greater than the 
	 * maximum value.
	 * 
	 * @param min The minimum value.
	 * @param max The maximum value.
	 * @param value The value being checked against the min and the max.
	 */
	public NotBetween( String desc, String min, String max, String value ) {
		super( desc, min, max, value );
	}

	public String getName() {
		return NOT_BETWEEN;
	}
} // NotBetween
