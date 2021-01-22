package projetSpringJpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import projetSpringJpa.entity.Civilite;
import projetSpringJpa.entity.Client;
import projetSpringJpa.repository.RepositoryClient;
import projetSpringJpa.repository.RepositoryCommande;

@Service
public class ClientService {
	
	@Autowired
	private RepositoryClient clientRepo;
	
	@Autowired
	private RepositoryCommande commandeRepo;
	
	public void creationClient(Client c) {
		if (c.getPrenom() != null && !c.getPrenom().isEmpty() && c.getNom() != null && !c.getNom().isEmpty()) {
			clientRepo.save(c);
		} else {
			System.out.println("la client n'a pas toute les infos obligatoires");
		}
	}
	
	public void creationClient(String prenom, String nom) {
		creationClient(new Client(null, prenom, nom, nom, null, null, null));
	}
	public List<Client> allClient() {
		return clientRepo.findAll();
	}

	public void demo() {
		

		
		clientRepo.save(new Client(Civilite.Monsieur, "Manu"," tutu", "@yahoo.fr", null, null, null));
	
		//System.out.println(clientRepo.findAll());

		Optional<Client> opt = clientRepo.findById(10000L);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println(opt);
		}
		Client p = opt.isPresent() ? opt.get() : new Client(Civilite.Monsieur, "Rere"," Remi", "remi@yahoo.fr", null, null, null);

		/*clientRepo.findAll(Sort.by("prenom").descending()).stream().forEach(client -> {
			System.out.println(client.getPrenom() + " " + client.getNom());
		});
	}*/

}}