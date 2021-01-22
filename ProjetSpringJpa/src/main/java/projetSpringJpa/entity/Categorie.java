package projetSpringJpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;


@Entity
public class Categorie implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Categorie(String nom, String description, List<Produit> produits) {
		this.nom = nom;
		this.description = description;
		this.produits = produits;
	}

	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits;
	
	@Version
	private int version;
	
	public Categorie() {}

	public Categorie(String nom, String description) {
		this.nom = nom;
		this.description = description;
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	

}
