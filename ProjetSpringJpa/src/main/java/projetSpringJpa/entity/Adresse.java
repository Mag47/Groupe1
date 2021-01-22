package projetSpringJpa.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Adresse implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rue;
	private Integer codePostal;
	private String ville;
	
	
	
	
	@ManyToOne
	private Client client;
	
	@Version
	private int version;
	
	public Adresse() {}

	public Adresse(String rue, Integer codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		
	}

	public Adresse(String rue, Integer codePostal, String ville, Client client) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
