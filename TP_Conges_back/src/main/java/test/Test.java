package test;

import java.time.LocalDate;

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
		
		salarie1.setNom("Maurice");
		salarie2.setNom("Manu");
		
		Context.getInstance().getDaoManager().save(manager);
		salarie1=Context.getInstance().getDaoSalarie().save(salarie1);
		salarie2=Context.getInstance().getDaoSalarie().save(salarie2);
		//em.merge(sal1)
		//Context.getInstance().getDaoSalarie().save(salarie2);
		
		Conges cp= new Conges(LocalDate.parse("2020-08-08"),LocalDate.parse("2020-08-16"),"RAS",TypeConges.congesPayes,salarie1);
		Conges cp2= new Conges(LocalDate.parse("2020-09-08"),LocalDate.parse("2020-09-16"),"RAS",TypeConges.absenceAutorisee,salarie2);
		Context.getInstance().getDaoConges().save(cp);
		Context.getInstance().getDaoConges().save(cp2);
		
	}
	public static void main(String[] args) {
	
		
		initBDD();
		Context.getInstance().closeEmf();
	}

}
