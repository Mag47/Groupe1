package projetSpringJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetSpringJpa.entity.Adresse;
import projetSpringJpa.entity.Client;

public interface RepositoryAdresse extends JpaRepository<Adresse, Integer>{
	
/*	public List<Adresse> findByPrenomContaining(String prenom);

	@Query("select c from Client c where c.prenom=:param")
	public List<Adresse> findAllOlivier(@Param("param") String param);*/
}


