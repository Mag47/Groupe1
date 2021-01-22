package projetSpringJpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class LigneCommande implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantite;
	private Double montant;
	
	@ManyToOne
	private Produit produit;
	
	@ManyToOne
	private Commande commande;
	
	@Version
	private int version;
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public LigneCommande(Integer quantite, Double montant, Produit produit, Commande commande) {
		this.quantite = quantite;
		this.montant = montant;
		this.produit = produit;
		this.commande = commande;
	}

	
	
	public LigneCommande() {
		
	}

	public LigneCommande(Integer quantite, Double montant) {
		this.quantite = quantite;
		this.montant = montant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
