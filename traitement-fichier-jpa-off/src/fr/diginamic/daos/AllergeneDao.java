/**
 * 
 */
package fr.diginamic.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Allergene;
import fr.diginamic.entities.Produit;

/**
 * @author Ness'ti
 *
 */
public class AllergeneDao {

	/**
	 * @param args
	 */
	private EntityManager em;

	public AllergeneDao(EntityManager em) {
		super();
		this.em = em;
	}

	public Allergene insertAllergene(String tabAllerg, Produit produit) {

		String[] decoupageAllerg = tabAllerg.split(",", -1); // decoupageAdditi = chaîne de carac tabAdditi splitée

		Allergene allergene = new Allergene();

		for (int i = 0; i < decoupageAllerg.length; i++) {
			
			TypedQuery<Allergene> queryA = em.createQuery("SELECT a FROM Allergene a WHERE a.nom = ?1 ",
					Allergene.class);
			queryA.setParameter(1, decoupageAllerg[i]); // allergène courant dans ce qui est splité
			List<Allergene> allergenes = queryA.getResultList();
			allergene.setNom(decoupageAllerg[i]);
			produit.getListe_allergenes().add(allergene);
			
			if (allergenes.size() == 0) { // pour gérer les doublons
				allergene.setNom(decoupageAllerg[i]);
				// em.persist -> pour demander l'enregistrement des entités
				em.persist(allergene);
			} else {
				allergene = allergenes.get(0);
			}
		}
		return allergene;
	}
}
