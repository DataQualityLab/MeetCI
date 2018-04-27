//
// $Id: $
//
package xess;

/**
 * The {@link XessPluginDriver} provides a layer of abstraction between the
 * {@link XessPluginManager} and individual {@link XessPlugin XessPlugins} 
 * that allows for the creation of multiple instances of the same kind of
 * {@link XessPlugin plug-in}.  This is useful in the event that a single
 * application is used to execute multiple {@link Xess} instances at the
 * same time, using the same type of {@link XessPlugin plug-in}, avoiding
 * problems such as rule name collisions.<P>
 * 
 * A "good" {@link XessPluginDriver driver} will automatically register 
 * itself with the {@link XessPluginManager} when the {@link XessPluginDriver
 * driver} class is loaded.  For example, the following line would load the
 * class and register the driver (similar to the expected behavior of JDBC
 * drivers):<P>
 * 
 * <tt>Class.forName( "SomeXessDriverImpl" );</tt><P>
 *
 * @author rstjacques
 */
public interface XessPluginDriver {
	/**
	 * Returns the name of the {@link XessPlugin} supported by the driver. 
	 * This may also be referred to as the {@link XessPlugin plug-in} type.
	 * 
	 * @return The name of the {@link XessPlugin} supported by the driver.
	 */
	public String getName();
	
	/**
	 * Returns an instance of the {@link XessPlugin} type supported by the
	 * driver.  This may be a new instance each time the method is called,
	 * or the same copy of the {@link XessPlugin}.
	 * 
	 * @return An instance of the {@link XessPlugin} type supported by the
	 * driver.
	 */
	public XessPlugin getPlugin();
} // XessPluginDriver
