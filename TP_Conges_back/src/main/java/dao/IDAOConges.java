package dao;

import java.util.List;

import model.Conges;



public interface IDAOConges extends IDAO<Conges,Integer> {
	
	public List<Conges> findAllFilter(String name);

}
