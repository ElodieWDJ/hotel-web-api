package dev.hotel.service;

import java.util.List;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

public class ClientService {

	private ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public List<Client> listerClients(Integer numeroPage, Integer taille) {

	}

}
