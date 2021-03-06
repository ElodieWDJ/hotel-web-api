package dev.hotel.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;
import dev.hotel.service.ClientService;

@RestController
public class ClientController {
//	@RequestMapping(value = "/clients?start=X&size=Y", method = RequestMethod.GET, path = "clients")
//	public Client findClient(@PathVariable int clientId) {
//		return new Client();

//	@GetMapping("/clients{start}/{size}")
//	public List<Client> returnList(@PathVariable int start, @PathVariable int size) {
//		return Arrays.asList(new Client());

	private ClientRepository clientRepository;

	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	// GET/clients
	@RequestMapping(method = RequestMethod.GET, path = "clients")
	public List<Client> listerClients(@RequestParam Integer start, @RequestParam Integer size) {
		return clientRepository.findAll(PageRequest.of(start, size)).getContent();
	}

	// GET/clients/uuid
	@RequestMapping(method = RequestMethod.GET, path = "clients/{uuid}")
	public ResponseEntity<?> getClientUuid(@PathVariable UUID uuid) {

		if (clientRepository.findById(uuid).isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).header("message", "cool").body(clientRepository.findById(uuid));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez entrer un autre identifiant client");
		}
	}

	// POST/clients

	@PostMapping
	public ResponseEntity<?> creerClient(@RequestBody @Valid CreerClientRequestDto client,
			BindingResult resultatValidation) {

		if (resultatValidation.hasErrors()) {
			return ResponseEntity.badRequest().body("Erreur");
		}

		return ResponseEntity
				.ok(new CreerClientResponseDto(ClientService.creerNouveauClient(client.getNom(), client.getPrenoms())));
	}

}
