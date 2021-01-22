package projetSpringJpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;



@Entity
public class Produit implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Double prix;
	private String description;
	private Integer stock;
	
	@ManyToOne
	private Categorie categorie;
	
	@OneToMany(mappedBy = "produit")
	private List<LigneCommande> ligneCommandes;
	
	@Version
	private int version;
	
	public Produit() {}
	
	public Produit(String nom, Double prix, String description, Integer stock) {
	
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
	}
	

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public Produit(String nom, Double prix, String description, Integer stock, Categorie categorie,
			List<LigneCommande> ligneCommandes) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
		this.categorie = categorie;
		this.ligneCommandes = ligneCommandes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

}
