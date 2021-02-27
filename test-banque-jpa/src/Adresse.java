import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 */

/**
 * @author Ness'ti
 *
 */

// Pas de @Entity ici car c'est un regroupement de colonnes (donc pas de int ID non plus ici)


@Embeddable
public class Adresse {

	@Column(name = "NUMERO")
	private int numero;

	@Column(name = "RUE")
	private String rue;

	@Column(name = "CODE_POSTAL")
	private int codePostal;

	@Column(name = "VILLE")
	private String ville;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
