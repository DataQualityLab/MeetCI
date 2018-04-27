//
// $Id: $
//
package xess;

import java.util.EventObject;

/**
 * A {@link RuleEvent} is fired by a {@link XessPlugin} when rules are 
 * evaluated.  Some {@link XessPlugin plug-ins} may only fire events when a
 * rule "fires" (evaluates to true), but others may fire an event every time
 * a rule is checked, whether the end result is true or false.
 */
public class RuleEvent extends EventObject {
	/**
	 * The {@link XessPlugin} that generated the event.
	 */
	private final XessPlugin source;
	
	/**
	 * The {@link Xess} that contains the {@link Rule} that was evaluated.
	 */
	private final Xess xess;
	
	/**
	 * The name of the {@link Rule}.
	 */
	private final String name;
	
	/**
	 * The result of the {@link Rule}; true indicates that the rule evaluated
	 * to true, false means that the rule evaluated to false.
	 */
	private final boolean result;
	
	/**
	 * Creates a new {@link RuleEvent} with the specified properties.
	 *
	 * @param src The {@link XessPlugin} that generated the event.
	 * @param x The {@link Xess} containing the {@link Rule} that was 
	 * evaluated.
	 * @param n The name of the {@link Rule} that was evaluated.
	 * @param r The result of the evaluation; true if the {@link Rule}
	 * evaluated to true, false otherwise.
	 */
	public RuleEvent( XessPlugin src, Xess x, String n, boolean r ) {
		super( src );
		source = src;
		xess = x;
		name = n;
		result = r;
	}
	
	/**
	 * Returns the {@link XessPlugin} that generated the event.
	 * 
	 * @return The {@link XessPlugin} that generated the event.
	 */
	public XessPlugin getPlugin() {
		return source;
	}
	
	/**
	 * Returns the {@link Xess} containing the {@link Rule} that was 
	 * evaluated.
	 * 
	 * @return The {@link Xess} containing the {@link Rule} that was
	 * evaluated.
	 */
	public Xess getXess() {
		return xess;
	}
	
	/**
	 * Returns the name of the {@link Rule} that was evaluated.
	 * 
	 * @return The name of the {@link Rule} that was evaluated.
	 */
	public String getRuleName() {
		return name;
	}
	
	/**
	 * 
	 * @return The result of the rule firing.
	 */
	public boolean getResult() {
		return result;
	}
} // RuleEvent
