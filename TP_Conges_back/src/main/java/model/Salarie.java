package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("employe")
public class Salarie extends Compte{
	
	@OneToOne
	private PC pc;

	public Salarie() {
	}
	
	public Salarie(String login, String password, String mail,PC pc) {
		super(login,password,mail);
		this.pc=pc;
	}
	
	public Salarie(Integer id,String login, String password, String mail,PC pc) {
		super(id,login,password,mail);
		this.pc=pc;
	}

	public PC getPc() {
		return pc;
	}

	public void setPc(PC pc) {
		this.pc = pc;
	}
	
	
}
