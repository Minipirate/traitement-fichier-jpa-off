/**
 * 
 */
package fr.diginamic.daos;

import javax.persistence.EntityManager;

import fr.diginamic.entities.Categorie;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.entities.Produit;

/**
 * @author Ness'ti
 *
 */
public class ProduitDao {

	/**
	 * @param args
	 */

	private EntityManager em;

	public ProduitDao(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertProd(String tabProd, Ingredient ingredient, String energie100g, String graisse100g,
			String nutritionGradeFr, String sucres100g, Categorie categorie, String fibres100g, String proteines100g,
			String sel100g) {

		Produit produit = new Produit();

		produit.setNom(tabProd);

		if (energie100g != "") {
			produit.setEnergie_100_g(Double.parseDouble(energie100g)); // pour passer en valeur numérique
		}

		if (graisse100g != "") {
			produit.setGraisse_100_g(Double.parseDouble(graisse100g));
		}

		if (sucres100g != "") {
			produit.setSucres_100_g(Double.parseDouble(sucres100g));
		}

		if (fibres100g != "") {
			produit.setFibres_100_g(Double.parseDouble(fibres100g));
		}

		if (proteines100g != "") {
			produit.setProteines_100_g(Double.parseDouble(proteines100g));
		}

		if (sel100g != "") {
			produit.setSel_100_g(Double.parseDouble(sel100g));
		}

		produit.setNutrition_grade_fr(nutritionGradeFr);

		produit.setCategorie(categorie);

		produit.getListe_ingredients().add(ingredient);

		// em.persist -> pour demander l'enregistrement des entités
		em.persist(produit);
	}
}
