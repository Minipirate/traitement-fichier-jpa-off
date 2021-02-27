import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 
 */

/**
 * @author Ness'ti
 *
 */
public class TestBanque {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		
		// pu-essai -> nom de la persistenceUnit
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = factory.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		
		transaction.begin();

		// *********** BANQUE ***********
		Banque banqueA = new Banque();
		banqueA.setNom("BANQUE A");

		// méthode persist qui envoie vers la bdd
		em.persist(banqueA);

		// *********** COMPTES ***********
		Compte compte1 = new Compte();
		compte1.setNumero(300255800);
		compte1.setSolde(250);

		Compte compte2 = new Compte();
		compte2.setNumero(300255400);
		compte2.setSolde(800);

		em.persist(compte1);
		em.persist(compte2);

		// *********** OPERATIONS ***********
		Operation operation1 = new Operation();
		operation1.setMontant(200);
		operation1.setMotif("Achat pain au chocolat");

		em.persist(operation1);

		// *********** CLIENTS ***********
		Client clientA = new Client();
		clientA.setNom("SOIREEDISCO");
		clientA.setPrenom("BORIS");
		clientA.getComptes().add(compte1);

		Adresse adresse1 = new Adresse();
		adresse1.setNumero(8);
		adresse1.setRue("rue du bout du monde");
		adresse1.setCodePostal(76000);
		adresse1.setVille("ROUEN");

		clientA.setAdresse(adresse1);

		em.persist(clientA);

		Client clientB = new Client();
		clientB.setNom("COOPER");
		clientB.setPrenom("Sheldon");
		clientB.getComptes().add(compte1);
		
		Adresse adresse2 = new Adresse();
		adresse2.setNumero(10);
		adresse2.setRue("rue de la fée");
		adresse2.setCodePostal(34000);
		adresse2.setVille("MONTPELLIER");
	
		clientB.setAdresse(adresse2);

		em.persist(clientB);

		Client clientC = new Client();
		clientC.setNom("WARRIOR");
		clientC.setPrenom("Banana");
		clientC.getComptes().add(compte2);
		
		Adresse adresse3 = new Adresse();
		adresse3.setNumero(8);
		adresse3.setRue("rue du quichou");
		adresse3.setCodePostal(34000);
		adresse3.setVille("MONTPELLIER");
		
		clientC.setAdresse(adresse3);
		
		em.persist(clientC);

		// *********** ASSURANCE VIE ***********
		AssuranceVie assuranceVie1 = new AssuranceVie();
		assuranceVie1.getClients().add(clientB);

		em.persist(assuranceVie1);

		// *********** LIVRET A ***********
		LivretA livretA1 = new LivretA();
		livretA1.getClients().add(clientB);

		em.persist(livretA1);

		transaction.commit();
	}
}
