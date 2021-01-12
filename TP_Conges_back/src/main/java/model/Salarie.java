package model;


import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("salarie")
public class Salarie extends Compte{
	
	@Enumerated(EnumType.STRING)
	private Service service;

	@OneToMany (mappedBy = "salarie")
	private List<Conges> conges;
	
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
	public List<Conges> getConges() {
		return conges;
	}

	public void setConges(List<Conges> conges) {
		this.conges = conges;
	}
	
	
	
}
