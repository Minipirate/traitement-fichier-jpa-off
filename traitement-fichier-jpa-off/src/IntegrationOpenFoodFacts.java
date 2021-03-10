import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.io.FileUtils;

import fr.diginamic.daos.AdditifDao;
import fr.diginamic.daos.AllergeneDao;
import fr.diginamic.daos.CategorieDao;
import fr.diginamic.daos.IngredientDao;
import fr.diginamic.daos.MarqueDao;
import fr.diginamic.daos.ProduitDao;
import fr.diginamic.entities.Categorie;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.entities.Produit;

/**
 * 
 */

/**
 * @author Ness'ti
 *
 */
public class IntegrationOpenFoodFacts {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// Lecture du fichier CSV
		File file = new File("C:/workspaceJava/open-food-facts.csv");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-food");
		EntityManager em = factory.createEntityManager();

		// Pour encapsuler les opérations de la bdd dans une transaction
		EntityTransaction transac = em.getTransaction();

		transac.begin();

		// Pour parser le fichier
		List<String> lignes = FileUtils.readLines(file, "UTF-8");
		for (int i = 1; i < 200; i++) {

			// tab decoupage qui accueille ce qui est parsé
			String[] decoupage = lignes.get(i).split("\\|", -1);

			Produit produit = new Produit();

			// ------------------> CATEGORIES <------------------

			CategorieDao categDao = new CategorieDao(em);
			Categorie categorie = categDao.insertCateg(decoupage[0], produit);

			// ------------------> MARQUES <------------------

			MarqueDao marqDao = new MarqueDao(em);
			marqDao.insertMarq(decoupage[1]);

			// ------------------> INGREDIENTS <------------------

			IngredientDao ingredDao = new IngredientDao(em);
			Ingredient ingredient = ingredDao.insertIngred(decoupage[4], produit);

			// ------------------> PRODUITS <------------------

			ProduitDao prodDao = new ProduitDao(em);
			prodDao.insertProd(decoupage[2], ingredient, decoupage[5], decoupage[6], decoupage[3], decoupage[7],
					categorie, decoupage[8], decoupage[9], decoupage[10]);

			// ------------------> ALLERGENES <------------------

			AllergeneDao allergDao = new AllergeneDao(em);
			allergDao.insertAllergene(decoupage[28], produit);

			// ------------------> ADDITIFS <------------------

			AdditifDao additiDao = new AdditifDao(em);
			additiDao.insertAdditif(decoupage[29], produit);

		}

		transac.commit();
	}
}
