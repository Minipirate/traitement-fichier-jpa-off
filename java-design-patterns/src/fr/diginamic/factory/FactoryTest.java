/**
 * 
 */
package fr.diginamic.factory;

/**
 * @author Ness'ti
 *
 */
public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ObjectConnecte objCoTab = ObjectConnecteFactory.getObjectConnecte(TypeObject.TABLETTE, 6);

		ObjectConnecte objCoEnc = ObjectConnecteFactory.getObjectConnecte(TypeObject.ENCEINTECONNECTEE, 10);

		ObjectConnecte objCoPort = ObjectConnecteFactory.getObjectConnecte(TypeObject.TELEPHONEPORTABLE, 5);

	}
}
