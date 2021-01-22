package projetSpringJpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;


@Entity
public class Commande implements Serializable {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer nbProduits;
	private Double prixTotal;
	private Adresse adresseLivraison;
	private Adresse adresseFacturation;
	
	@Column(columnDefinition = "DATE")
	private LocalDate date;
	
	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> ligneCommandes;
	
	@ManyToOne
	private Client client;
	
	
	
	@Version
	private int version;
	
	public Commande() {
		
	}

	public Commande(Integer nbProduits, Double prixTotal, Adresse adresseLivraison, Adresse adresseFacturation,
			LocalDate date, List<LigneCommande> ligneCommandes, Client client) {
		this.nbProduits = nbProduits;
		this.prixTotal = prixTotal;
		this.adresseLivraison = adresseLivraison;
		this.adresseFacturation = adresseFacturation;
		this.date = date;
		this.ligneCommandes = ligneCommandes;
		this.client = client;
	}

	public Commande(Integer nbProduits, Double prixTotal, LocalDate date) {
		this.nbProduits = nbProduits;
		this.prixTotal = prixTotal;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNbProduits() {
		return nbProduits;
	}

	public void setNbProduits(Integer nbProduits) {
		this.nbProduits = nbProduits;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
