package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOConges;
import model.Conges;
import model.Manager;

public class DAOConges implements IDAOConges {

	@Override
	public Conges save(Conges t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Conges");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Conges t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Conges");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Conges findById(Integer id) {
		Conges conges=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{conges=em.find(Conges.class,id);}
		catch(Exception e) {System.out.println("Error find Conges");}
		
		
		em.close();
		return conges;
	}

	@Override
	public List<Conges> findAll() {
		List<Conges> conges = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Conges",Conges.class);
			conges=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Conges");}
		em.close();
		return conges;
	}

}
