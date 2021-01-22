package projetSpringJpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	private String nom;
	private String prenom;
	private String email;
	
	
	@OneToMany(mappedBy = "client")
	private List<Commande> commandes;
	
	@OneToMany(mappedBy = "client")
	private List<Adresse> adresses;
	
	@OneToOne(mappedBy = "client")
	private Login login;
	
	


	@Version
	private int version;
	
	public Client() {
		
	}


		
	public Client(Civilite civilite, String nom, String prenom, String email, List<Commande> commandes,
			List<Adresse> adresses, Login login) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.commandes = commandes;
		this.adresses = adresses;
		this.login = login;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}


	public List<Adresse> getAdresses() {
		return adresses;
	}


	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Civilite getCivilite() {
		return civilite;
	}


	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
