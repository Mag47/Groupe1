package test;

import config.Context;


import model.Manager;
import model.Salarie;
import model.Service;

public class Test {

	
	public static void initBDD() 
	{
		
		
		
		Manager manager=new Manager("ajc","j.abid@ajc.fr");
		Salarie salarie1 = new Salarie("123r","re@gmail.com", Service.RH );
		Salarie salarie2=new Salarie("123ra","Raul@gmail.com", Service.informatique);
		
		Context.getInstance().getDaoManager().save(manager);
		Context.getInstance().getDaoSalarie().save(salarie1);
		Context.getInstance().getDaoSalarie().save(salarie2);
		
	}
	public static void main(String[] args) {
	
		
		initBDD();
	
	}

}
