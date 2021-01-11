package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import config.Context;
import model.Conges;
import model.Manager;
import model.Salarie;
import model.Service;
import model.TypeConges;

public class Test {

	
	public static void initBDD() 
	{
		
		
		
		Manager manager=new Manager("ajc","j.abid@ajc.fr");
		Salarie salarie1 = new Salarie("123r","re@gmail.com", Service.RH );
		Salarie salarie2=new Salarie("123ra","Raul@gmail.com", Service.informatique);
		
		Context.getInstance().getDaoManager().save(manager);
		Context.getInstance().getDaoSalarie().save(salarie1);
		Context.getInstance().getDaoSalarie().save(salarie2);
		
		Conges cp= new Conges("Maurice",LocalDate.parse("2020-08-08"),LocalDate.parse("2020-08-16"),8,"RAS",TypeConges.congesPayes,Service.RH, LocalDateTime.now(ZoneId.systemDefault()));
		
		Context.getInstance().getDaoConges().save(cp);
		
	}
	public static void main(String[] args) {
	
		
		initBDD();
		Context.getInstance().closeEmf();
	}

}
