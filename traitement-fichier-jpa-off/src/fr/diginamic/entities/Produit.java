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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Ness'ti
 *
 */
@Entity
@Table(name = "PRODUIT")
public class Produit {

	@Id
	// annotation qui indique que la clef primaire est générée de façon auto lors de
	// l'insertion en bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "NUTRITION_GRADE_FR")
	private String nutrition_grade_fr;

	@Column(name = "ENERGIE_100_G")
	private double energie_100_g;

	@Column(name = "GRAISSE_100_G")
	private double graisse_100_g;

	@Column(name = "SUCRES_100_G")
	private double sucres_100_g;

	@Column(name = "FIBRES_100_G")
	private double fibres_100_g;

	@Column(name = "PROTEINES_100_G")
	private double proteines_100_g;

	@Column(name = "SEL_100_G")
	private double sel_100_g;
	
	

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id"))
	List<Ingredient> liste_ingredients = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "compo1", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"))
	List<Allergene> liste_allergenes = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "compo2", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_additif", referencedColumnName = "id"))
	List<Additif> liste_additifs = new ArrayList<>();

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "prod_id")
	private Marque marque;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "categ_id")
	private Categorie categorie;

	public Produit() {

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

	public String getNutrition_grade_fr() {
		return nutrition_grade_fr;
	}

	public void setNutrition_grade_fr(String nutrition_grade_fr) {
		this.nutrition_grade_fr = nutrition_grade_fr;
	}

	public double getEnergie_100_g() {
		return energie_100_g;
	}

	public void setEnergie_100_g(double energie_100_g) {
		this.energie_100_g = energie_100_g;
	}

	public double getGraisse_100_g() {
		return graisse_100_g;
	}

	public void setGraisse_100_g(double graisse_100_g) {
		this.graisse_100_g = graisse_100_g;
	}

	public double getSucres_100_g() {
		return sucres_100_g;
	}

	public void setSucres_100_g(double sucres_100_g) {
		this.sucres_100_g = sucres_100_g;
	}

	public double getFibres_100_g() {
		return fibres_100_g;
	}

	public void setFibres_100_g(double fibres_100_g) {
		this.fibres_100_g = fibres_100_g;
	}

	public double getProteines_100_g() {
		return proteines_100_g;
	}

	public void setProteines_100_g(double proteines_100_g) {
		this.proteines_100_g = proteines_100_g;
	}

	public double getSel_100_g() {
		return sel_100_g;
	}

	public void setSel_100_g(double sel_100_g) {
		this.sel_100_g = sel_100_g;
	}

	public List<Ingredient> getListe_ingredients() {
		return liste_ingredients;
	}

	public void setListe_ingredients(List<Ingredient> liste_ingredients) {
		this.liste_ingredients = liste_ingredients;
	}

	public List<Allergene> getListe_allergenes() {
		return liste_allergenes;
	}

	public void setListe_allergenes(List<Allergene> liste_allergenes) {
		this.liste_allergenes = liste_allergenes;
	}

	public List<Additif> getListe_additifs() {
		return liste_additifs;
	}

	public void setListe_additifs(List<Additif> liste_additifs) {
		this.liste_additifs = liste_additifs;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
