package projetSpringJpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import projetSpringJpa.entity.Commande;
import projetSpringJpa.service.ClientService;
import projetSpringJpa.service.CommandeService;

public class AppSpring {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CommandeService commandeService;

	public void run(String[] args) {
		clientService.demo();
		commandeService.creationCommande(new Commande(4,25.0,LocalDate.parse("2021-05-12")));
	}
}
