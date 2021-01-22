package projetSpringJpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import projetSpringJpa.entity.Civilite;
import projetSpringJpa.entity.Commande;
import projetSpringJpa.repository.RepositoryCommande;


@Service
public class CommandeService {
	
	
	
	@Autowired
	private RepositoryCommande commandeRepo;
	
	public void creationCommande(Commande c) {
		/*if (c.getNbProduits() != null && !c.getPrixTotal()().isEmpty() && c.getNom() != null && !c.getNom().isEmpty()) {
			commandeRepo.save(c);
		} else {
			System.out.println("la commande n'a pas toute les infos obligatoires");
		}
	}
	*/}
	/*public void creationCommande(String prenom, String nom) {
		creationCommande(new Commande(null, prenom, nom, nom, null, null, null));
	}
	public List<Commande> allCommande() {
		return commandeRepo.findAll();
	}

	public void demo() {
		

		
		//commandeRepo.save(new Commande(Civilite.Monsieur, "Manu"," tutu", "@yahoo.fr", null, null, null));
	
		//System.out.println(commandeRepo.findAll());

		Optional<Commande> opt = commandeRepo.findById(10000L);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println(opt);
		}
		//Commande p = opt.isPresent() ? opt.get() : new Commande(Civilite.Monsieur, "Rere"," Remi", "remi@yahoo.fr", null, null, null);

		/*commandeRepo.findAll(Sort.by("prenom").descending()).stream().forEach(commande -> {
			System.out.println(commande.getPrenom() + " " + commande.getNom());
		});
	}*/

}