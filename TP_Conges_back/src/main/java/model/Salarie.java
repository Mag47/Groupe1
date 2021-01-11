package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("salarie")
public class Salarie extends Compte{
	
	@Enumerated(EnumType.STRING)
	@Column(name="service",nullable=false)
	private Service service;

	public Salarie() {
	}

	public Salarie(Integer id, String password, String mail, Service service) {
		super(id, password, mail);
		this.service=service;
	}

	public Salarie(String password, String mail, Service service) {
		super(password, mail);
		this.service=service;
		// TODO Auto-generated constructor stub
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	
	
	
}
