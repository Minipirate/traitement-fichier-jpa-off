/**
 * 
 */
package fr.diginamic.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Ingredient;
import fr.diginamic.entities.Produit;

/**
 * @author Ness'ti
 *
 */
public class IngredientDao {

	/**
	 * @param args
	 */

	private EntityManager em;

	public IngredientDao(EntityManager em) {
		super();
		this.em = em;
	}

	public Ingredient insertIngred(String tabIngred, Produit produit) {

		String[] decoupageIngred = tabIngred.split(",", -1); // decoupageIngred = chaîne de carac tabIngred splitée

		Ingredient ingredient = new Ingredient();

		for (int i = 0; i < decoupageIngred.length; i++) {

			TypedQuery<Ingredient> queryI = em.createQuery("SELECT i FROM Ingredient i WHERE i.nom = ?1",
					Ingredient.class);
			queryI.setParameter(1, decoupageIngred[i]);
			List<Ingredient> ingredients = queryI.getResultList();

			if (ingredients.size() == 0 && decoupageIngred[i].length() <= 255) {
				ingredient.setNom(decoupageIngred[i]);
				em.persist(ingredient);
			}
		}
		return ingredient;
	}
}
