import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */

/**
 * @author Ness'ti
 *
 */


@Entity
public class Virement extends Operation {

	@Id
	// toujours au dessus de l'id -> lors de la création de l'id il sera en auto-increment 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "BENEFICIAIRE")
	private String beneficiaire;

	public Virement() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}
