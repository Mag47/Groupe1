package projetSpringJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import projetSpringJpa.entity.Client;

public interface RepositoryClient extends JpaRepository<Client, Integer>{
	
	public List<Client> findByPrenomContaining(String prenom);

	@Query("select c from Client c where c.prenom=:param")
	public List<Client> findAllOlivier(@Param("param") String param);
}


