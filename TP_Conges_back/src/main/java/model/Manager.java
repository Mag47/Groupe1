package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("manager")

public class Manager extends Compte {
	
	

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Integer id, String password, String mail) {
		super(id, password, mail);
		// TODO Auto-generated constructor stub
	}

	public Manager(String password, String mail) {
		super(password, mail);
		// TODO Auto-generated constructor stub
	}
	
}
