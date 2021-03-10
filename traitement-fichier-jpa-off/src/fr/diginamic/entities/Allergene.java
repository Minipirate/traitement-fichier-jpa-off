/**
 * 
 */
package fr.diginamic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Ness'ti
 *
 */
@Entity
@Table(name = "ALLERGENE")
public class Allergene {

	@Id
	// annotation qui indique que la clef primaire est générée de façon auto lors de l'insertion en bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM") 
	private String nom;

	public Allergene() {

	}

	@ManyToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "compo1", joinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"))
	List<Allergene> allergenes = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

}
