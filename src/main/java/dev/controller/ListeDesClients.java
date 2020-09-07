package dev.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;

@RestController
public class ListeDesClients {
//	@RequestMapping(value = "/clients?start=X&size=Y", method = RequestMethod.GET, path = "clients")
//	public Client findClient(@PathVariable int clientId) {
//		return new Client();

	@GetMapping("/clients{start}/{size}")
	public List<Client> returnList(@PathVariable int start, @PathVariable int size) {
		return Arrays.asList(new Client());
	}
}
