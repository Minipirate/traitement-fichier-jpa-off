/**
 * 
 */
package fr.diginamic.singleton;


/**
 * @author Ness'ti
 *
 */
public class SingletonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ConfigSingleton config = ConfigSingleton.getInstance();
		String url = config.getValue("db.url");
		String user = config.getValue("db.user");
		String password = config.getValue("db.password");
		
		System.out.println(url);
		System.out.println(password);
		System.out.println(user);
	}
}