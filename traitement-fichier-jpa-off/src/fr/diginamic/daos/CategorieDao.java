/**
 * 
 */
package fr.diginamic.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Categorie;
import fr.diginamic.entities.Produit;

/**
 * @author Ness'ti
 *
 */
public class CategorieDao {

	/**
	 * @param args
	 * @return
	 */

	private EntityManager em;

	public CategorieDao(EntityManager em) {
		super();
		this.em = em;
	}

	public Categorie insertCateg(String tabCateg, Produit produit) {

		Categorie categorie = new Categorie();

		TypedQuery<Categorie> queryC = em.createQuery("SELECT c FROM Categorie c WHERE c.nom = ?1 ", Categorie.class);
		queryC.setParameter(1, tabCateg);
		List<Categorie> categories = queryC.getResultList();
		if (categories.size() == 0) { // pour gérer les doublons
			categorie.setNom(tabCateg);
			// em.persist -> pour demander l'enregistrement des entités
			em.persist(categorie);
		} else {
			categorie = categories.get(0); // si la categ existe déjà, elle devient celle 
		}
		return categorie;
	}
}
