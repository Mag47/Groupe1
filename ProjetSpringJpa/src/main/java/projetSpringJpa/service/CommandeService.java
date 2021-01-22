package projetSpringJpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import projetSpringJpa.entity.Civilite;
import projetSpringJpa.entity.Commande;
import projetSpringJpa.repository.RepositoryCommande;
import projetSpringJpa.repository.RepositoryLigneCommande;


@Service
public class CommandeService {
	
	
	
	@Autowired
	private RepositoryCommande commandeRepo;
	
	@Autowired
	private RepositoryLigneCommande ligneCommandeRepo;
	
	public void creationCommande(Commande commande) {
	commandeRepo.save(commande);
	
	}
	
}