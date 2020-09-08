package dev.hotel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

public class ClientService {

	private static ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		ClientService.clientRepository = clientRepository;
	}

	public List<Client> listerClients(Integer numeroPage, Integer taille) {
		return clientRepository.findAll(PageRequest.of(numeroPage, taille)).getContent();
	}

	public Optional<Client> recupererClient(UUID uuid) {
		return clientRepository.findById(uuid);
	}

	@Transactional
	public static Client creerNouveauClient(String nom, String prenoms) {
		Client nouveauClient = new Client(nom, prenoms);
		return clientRepository.save(nouveauClient);
	}
}
