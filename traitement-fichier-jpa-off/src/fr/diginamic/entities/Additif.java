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
@Table(name = "ADDITIF")
public class Additif {

	@Id
	// annotation qui indique que la clef primaire est générée de façon auto lors de l'insertion en bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	
	@ManyToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "compo2", joinColumns = @JoinColumn(name = "id_additif", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"))
	List<Additif> additifs = new ArrayList<>();
	
	
	
	public Additif() {

	}

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

	public List<Additif> getAdditifs() {
		return additifs;
	}

	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}

}
