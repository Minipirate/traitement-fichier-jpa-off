/**
 * 
 */
package fr.diginamic.singleton;

import java.util.ResourceBundle;

/**
 * @author Ness'ti
 *
 */
public class ConfigSingleton {
	
	private ResourceBundle bundle;

	private ConfigSingleton() {
		bundle = ResourceBundle.getBundle("configuration");
	}
	
	private static ConfigSingleton instance = new ConfigSingleton();
	
	public static ConfigSingleton getInstance() {
		return instance;
	}
	
	public String getValue(String clefParam) {
		return bundle.getString(clefParam);
	}
	
}
