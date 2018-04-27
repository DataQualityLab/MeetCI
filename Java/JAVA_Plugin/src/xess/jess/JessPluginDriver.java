//
// $Id: $
//
package xess.jess;

import xess.XessPlugin;
import xess.XessPluginDriver;

/**
 * An implementation of the {@link XessPluginDriver} interface that creates
 * plug-ins that interface with the Java Expert System Shell (JESS).
 * 
 *
 * @author rstjacques
 */
public class JessPluginDriver implements XessPluginDriver {
	/**
	 * The name of the driver.
	 */
	private static final String NAME = "JESS Plug-in Driver";
	
	public JessPluginDriver() {
		
	}

	/**
	 * Returns the name of the driver.
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * Creates and returns a new {@link XessPlugin} that can execute 
	 * {@link xess.Xess} instances on JESS.
	 * 
	 * @return An implementation of the {@link XessPlugin} interface that
	 * is capable of executing {@link xess.Xess} instances using JESS.
	 */
	public XessPlugin getPlugin() {
		// TODO Auto-generated method stub
		return null;
	}
} // JessPLuginDriver
