//
// $Id: $
//
package xess;

/**
 * A {@link Clause} that is satisfied if the input value is greater than or 
 * equal to the {@link #getMinimum() minimum} value and less than or equal to
 * the {@link #getMaximum() maximum} value.
 *
 * @author rstjacques
 */
public class Between extends Clause {
	/**
	 * The minimum value.
	 */
	private String minimum;
	
	/**
	 * The maximum value.
	 */
	private String maximum;
	
	/**
	 * The value being checked against the min and the max.
	 */
	private String value;
	
	/**
	 * Creates a new {@link Between} with the specified minimum and maximum
	 * values.  The {@link Between} is only satisfied when the input value is
	 * greater than or equal to the specified minimum and less than or equal 
	 * to the maximum value.
	 * 
	 * @param min The minimum value.
	 * @param max The maximum value.
	 * @param value The value being checked against the min and the max.
	 */
	public Between( String min, String max, String value ) {
		this( null, min, max, value );
	}

	/**
	 * Creates a new {@link Between} with the specified description, and 
	 * minimum and maximum values.  The {@link Between} is only satisfied when
	 * the input value is greater than or equal to the specified minimum and
	 * less than or equal to the maximum value.
	 * 
	 * @param desc The description of the {@link Between}.
	 * @param min The minimum value.
	 * @param max The maximum value.
	 * @param value The value being checked against the min and the max.
	 */
	public Between( String desc, String min, String max, String value ) {
		super( desc );
		setMinimum( min );
		setMaximum( max );
		setValue( value );
	}
	
	/**
	 * Returns the current minimum value.
	 * 
	 * @return The current maximum value.
	 */
	public String getMinimum() {
		return minimum;
	}

	/**
	 * Sets the minimum value to the specified value.
	 * 
	 * @param min The new value for the minimum.
	 */
	public void setMinimum( String min ) {
		minimum = min;
	}
	
	/**
	 * Returns the current maximum value.
	 * 
	 * @return The current maximum value.
	 */
	public String getMaximum() {
		return maximum;
	}
	
	/**
	 * Sets the current maximum value to the specified value.
	 * 
	 * @param max The new value for the maximum.
	 */
	public void setMaximum( String max ) {
		maximum = max;
	}
	
	/**
	 * Returns the current value.
	 * 
	 * @return The current value.
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the current value.
	 * 
	 * @param v The value for the current value.
	 */
	public void setValue( String v ) {
		value = v;
	}
	
	public String getName() {
		return BETWEEN;
	}

	public String toXml() {
		StringBuffer buf = new StringBuffer();
		buf.append( "<" );
		buf.append( getName());
		String d = getDescription();
		if( d != null ) {
			buf.append( " " );
			buf.append( DESCRIPTION );
			buf.append( "=\"" );
			buf.append( d );
			buf.append( "\"" );
		}
		buf.append( " " );
		buf.append( MIN );
		buf.append( "=\"" );
		buf.append( getMinimum());
		buf.append( "\" " );
		buf.append( MAX );
		buf.append( "=\"" );
		buf.append( getMaximum());
		buf.append( "\"/>" );
		return buf.toString();
	}
} // Between
