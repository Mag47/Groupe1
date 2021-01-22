package projetSpringJpa;

import org.springframework.beans.factory.annotation.Autowired;

import projetSpringJpa.service.ClientService;

public class AppSpring {

	@Autowired
	private ClientService clientService;

	public void run(String[] args) {
		clientService.creationClient("thierry","Dev");
	}
}
