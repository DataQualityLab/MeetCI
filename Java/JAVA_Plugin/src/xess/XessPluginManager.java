//
// $Id: $
//
package xess;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * A singleton class that provides a simple API for managing {@link XessPlugin
 * XessPlugins} through the use of {@link XessPluginDriver XessPluginDrivers}.
 *
 * @author rstjacques
 */
public final class XessPluginManager {
	/**
	 * The {@link Set} of registered {@link XessPLugin XessPlugins}.
	 */
	private static final Set<XessPluginDriver> DRIVERS = 
		new TreeSet<XessPluginDriver>( new DriverComparator());
	
	/**
	 * Registers the specified {@link XessPluginDriver} with the manager.  The 
	 * driver will be used to return an {@link XessPlugin plug-in} whenever a
	 * matching {@link XessPluginDriver#getName() name} is passed into the 
	 * {@link #getPlugin(String)} method.  If another {@link XessPluginDriver}
	 * has been registered with the same name, the new {@link XessPluginDriver
	 * driver} will replace the previously registered {@link XessPluginDriver
	 * driver}.
	 * 
	 * @param driver The {@link XessPluginDriver} to add to the manager.
	 */
	public static void registerDriver( XessPluginDriver driver ) {
		synchronized( DRIVERS ) {
			if( DRIVERS.contains( driver )) {
				deregisterDriver( driver );
			}
			DRIVERS.add( driver );
		}
	}
	
	/**
	 * Removes the specified {@link XessPluginDriver} from the manager.  The
	 * {@link XessPluginDriver driver} will no longer be returned whenever a 
	 * matching name is passed to the {@link #getPlugin(String)} method, 
	 * though no other action is taken against the {@link XessPluginDriver} to
	 * invalidate any references that may have been returned previously.
	 * 
	 * @param driver The {@link XessPluginDriver} to be removed.
	 */
	public static void deregisterDriver( XessPluginDriver driver ) {
		synchronized( DRIVERS ) {
			DRIVERS.remove( driver );
		}
	}
	
	/**
	 * Iterates over the registered {@link XessPluginDriver XessPluginDrivers}
	 * until a {@link XessPluginDriver driver} matching the specified 
	 * {@link XessPluginDriver#getName() name} is found.  If such a 
	 * {@link XessPluginDriver driver} is found, the 
	 * {@link XessPluginDriver#getPlugin()} method is used to return a
	 * {@link XessPlugin}.  If no such {@link XessPluginDriver driver} exists,
	 * a null value is returned instead. 
	 * 
	 * @param name The name of the desired {@link XessPluginDriver}.
	 * 
	 * @return The {@link XessPlugin} created by the {@link XessPluginDriver}
	 * with the specified name, if such an {@link XessPluginDriver driver} 
	 * exists; null otherwise.
	 */
	public static XessPlugin getPlugin( String name ) {
		synchronized( DRIVERS ) {
			XessPlugin plugin = null;
			for( XessPluginDriver driver : DRIVERS ) {
				if( name.equals( driver.getName())) {
					plugin = driver.getPlugin();
					break;
				}
			}
			return plugin;
		}
	}
	
	/**
	 * Compares {@link XessPluginDriver XessPluginDriverss} by name; null 
	 * names are allowed and two {@link XessPluginDriver drivers} with null 
	 * names are considered equivalent.
	 */
	private static class DriverComparator implements Comparator<XessPluginDriver> {
		/**
		 * Compares two {@link XessPlugin XessPlugins} by 
		 * {@link XessPlugin#getName() name}.  The {@link XessPlugin plug-ins}
		 * cannot be null, but the names may be null.  Two {@link XessPlugin
		 * plug-ins} with null names are considered equivalent; in all other 
		 * cases a null name is considered smaller than a non-null name.
		 * 
		 * @param d1 The first {@link XessPluginDriver} to compare.
		 * @param d2 The second {@link XessPluginDriver} to compare.
		 * 
		 * @return An integer value representing the result of the comparison;
		 * 0 for two equivalent plug-ins (exact name matches), greater than 0 
		 * if the first is canonically greater than the second, and less than 
		 * 0 if the first is canonically less than the second.
		 */
		public int compare( XessPluginDriver d1, XessPluginDriver d2 ) {
			int result;
			String n1 = d1.getName();
			String n2 = d2.getName();
			if( n1 != null ) {
				result = ( n2 != null ? n1.compareTo( n2 ) : 1 );
			}
			else {
				result = ( n2 == null ? 0 : -1 );
			}
			//return the result
			return result;
		}
	} // DriverComparator
} // XessPluginManager
