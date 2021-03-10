/**
 * 
 */
package fr.diginamic.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Marque;

/**
 * @author Ness'ti
 *
 */
public class MarqueDao {

	/**
	 * @param args
	 */

	private EntityManager em;

	public MarqueDao(EntityManager em) {
		super();
		this.em = em;
	}
	

	public void insertMarq(String tabMarq) {
		Marque marque = new Marque();

		TypedQuery<Marque> queryM = em.createQuery("SELECT m FROM Marque m WHERE m.nom = ?1", Marque.class);
		queryM.setParameter(1, tabMarq);
		List<Marque> marques = queryM.getResultList();
		if (marques.size() == 0) { // pour gérer les doublons
			marque.setNom(tabMarq);
			// em.persist -> pour demander l'enregistrement des entités
			em.persist(marque);
		}
	}

}
