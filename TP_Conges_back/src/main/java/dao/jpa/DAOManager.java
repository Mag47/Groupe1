package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOManager;
import model.Manager;

public class DAOManager implements IDAOManager{

	@Override
	public Manager save(Manager t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Manager");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Manager t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Manager");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Manager findById(Integer id) {
		Manager manager=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{manager=em.find(Manager.class,id);}
		catch(Exception e) {System.out.println("Error find Manager");}
		
		
		em.close();
		return manager;
	}

	@Override
	public List<Manager> findAll() {
		List<Manager> managers = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Manager",Manager.class);
			managers=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Manager");}
		em.close();
		return managers;
	}

}
