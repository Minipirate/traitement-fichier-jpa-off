/**
 * 
 */
package fr.diginamic.factory;


/**
 * @author Ness'ti
 *
 */
public class ObjectConnecteFactory {

	public static ObjectConnecte getObjectConnecte(TypeObject type, int limiteVolts) {

		if (type.equals(TypeObject.ENCEINTECONNECTEE)) {
			return new EnceinteConnectee(limiteVolts);
		}
		
		if (type.equals(TypeObject.TABLETTE)) {
			return new Tablette(limiteVolts);
		}
		if (type.equals(TypeObject.TELEPHONEPORTABLE)) {
			return new TelephonePortable(limiteVolts);
		}
		return null;
	}
}
