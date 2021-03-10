/**
 * 
 */
package fr.diginamic.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Produit;

/**
 * @author Ness'ti
 *
 */
public class AdditifDao {

	/**
	 * @param args
	 */
	private EntityManager em;

	public AdditifDao(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertAdditif(String tabAdditi, Produit produit) {

		String[] decoupageAdditi = tabAdditi.split(",", -1); // decoupageAdditi = chaîne de carac tabAdditi splitée

		Additif additif = new Additif();

		for (int i = 0; i < decoupageAdditi.length; i++) {
			
			additif.setNom(decoupageAdditi[i]);
			produit.getListe_additifs().add(additif);
			
			TypedQuery<Additif> queryAd = em.createQuery("SELECT a FROM Additif a WHERE a.nom = ?1", Additif.class);
			queryAd.setParameter(1, decoupageAdditi[i]);
			List<Additif> additifs = queryAd.getResultList();
			if (additifs.size() == 0 && decoupageAdditi[i].length() <= 255) {
				additif.setNom(decoupageAdditi[i]);
				em.persist(additif);
			}
		}
	}
}
