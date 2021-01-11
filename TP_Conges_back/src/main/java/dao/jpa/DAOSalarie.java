package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOSalarie;
import model.Salarie;


public class DAOSalarie implements IDAOSalarie{

	@Override
	public Salarie save(Salarie t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Salarie");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Salarie t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Salarie");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Salarie findById(Integer id) {
		Salarie sal=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{sal=em.find(Salarie.class,id);}
		catch(Exception e) {System.out.println("Error find Salarie");}
		
		em.close();
		return sal;
	}

	@Override
	public List<Salarie> findAll() {
		List<Salarie> salaries = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Salarie",Salarie.class);
			salaries=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Salarie");}
		em.close();
		return salaries;
	}
	
	@Override
	public List<Salarie> findAllFilter(String service) {
		List<Salarie> salaries = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Salarie s where s.service like :filter",Salarie.class);
			query.setParameter("filter", "%"+service+"%");
			salaries=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAlFilter Salarie");}
		em.close();
		return salaries;
	}

}
