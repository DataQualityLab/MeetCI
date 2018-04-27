//
// $Id: $
//
package xess;

/**
 * A simple interface designed to wrap one or more expert systems.  The 
 * {@link XessPlugin} is reposnsible for translating the facts and rules of
 * an {@link Xess} into a format understood by the underlying expert system,
 * and to execute those facts and rules on the system.  Whenever possible,
 * actions taken by the underlying expert system should be traced using the
 * trace functionality of the {@link Xess}.  The {@link XessPlugin} may be
 * stateful, retaining information about any {@link Xess} that has been
 * executed on it.
 *
 * @author rstjacques
 */
public interface XessPlugin {
	/**
	 * Returns the name, or type, of the {@link XessPlugin}.  The name should
	 * meet the following criteria:<BR>
	 * <UL>
	 * <LI><B>Consistent with the {@link XessPluginDriver Driver}</b>: The name
	 * should be the same as the value returned by the 
	 * {@link XessPluginDriver#getName()} method of the {@link XessPluginDriver
	 * driver} used to create the {@link XessPlugin plug-in}.
	 * <LI><B>Unique:</B> The name should be unique among all 
	 * {@link XessPlugin plug-ins} and {@link XessPluginDriver drivers}.<BR>
	 * <LI><B>Descriptive: </B> The name should be descriptive of the type of
	 * expert system(s) with which the {@link XessPlugin plug-in} interacts.
	 * </UL>
	 * 
	 * @return The name, or type, of the {@link XessPlugin}.
	 */
	public String getName();
	
	/**
	 * Executes the {@link Xess} by loading the facts and rules into the
	 * expert system(s) with which the {@link XessPlugin} interacts.  The
	 * execution need not be stateless; the {@link XessPlugin plug-in} may
	 * retain some information about previous executions, as may the 
	 * underlying expert system(s).
	 * 
	 * @param x The {@link Xess} to execute.
	 */
	public void execute(Xess x);
} // XessPlugin
