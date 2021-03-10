/**
 * 
 */
package fr.diginamic.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ness'ti
 *
 */
@Entity
@Table(name = "CATEGORIE")
public class Categorie {

	@Id
	// annotation qui indique que la clef primaire est générée de façon auto lors de l'insertion en bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	public Categorie() {

	}

	@OneToMany(mappedBy = "categorie", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Produit> produits;

	
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

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
