package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOManager;
import dao.IDAOSalarie;
import dao.jpa.DAOCompte;
import dao.jpa.DAOManager;
import dao.jpa.DAOSalarie;


public class Context {

	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("conges");
	
	//Factory
	private IDAOCompte daoCompte=new DAOCompte();
	private IDAOSalarie daoSalarie=new DAOSalarie();
	private IDAOManager daoManager=new DAOManager();

	
	private Context() {}
	
	public static Context getInstance()
	{
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
	}
	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public void closeEmf() 
	{
		emf.close();
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	public IDAOSalarie getDaoSalarie() {
		return daoSalarie;
	}

	public void setDaoSalarie(IDAOSalarie daoSalarie) {
		this.daoSalarie = daoSalarie;
	}

	public IDAOManager getDaoManager() {
		return daoManager;
	}

	public void setDaoManager(IDAOManager daoManager) {
		this.daoManager = daoManager;
	}

	



	
	
	
	
}
