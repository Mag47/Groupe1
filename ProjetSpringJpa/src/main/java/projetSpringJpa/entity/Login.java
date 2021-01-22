package projetSpringJpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;


@Entity
public class Login implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String motDePasse;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne
	private Client client;
	
	@Version
	private int version;
	
	
	public Login() {
		
	}



	public Login(String nom, String motDePasse, Role role, Client client) {
		this.nom = nom;
		this.motDePasse = motDePasse;
		this.role = role;
		this.client = client;
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


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	

}
