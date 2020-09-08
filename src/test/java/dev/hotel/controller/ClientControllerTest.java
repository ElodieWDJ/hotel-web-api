package dev.hotel.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@WebMvcTest(ClientController.class) // contrôleur à tester
public class ClientControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	ClientRepository clientRepository;

	public void testListerClientsAvec2Clients() throws Exception {
		Client c1 = new Client();
		c1.setNom("nom1");
		c1.setPrenoms("prenoms1");

		Client c2 = new Client();
		c2.setNom("nom2");
		c2.setPrenoms("prenoms2");

		when(clientRepository.findAll(PageRequest.of(10, 20))).thenReturn(new PageImpl<>(Arrays.asList(c1, c2)));

		// GET/clients
		mockMvc.perform(MockMvcRequestBuilders.get("/client?start=10&size=20"))
				.andExpect(MockMvcResultMatchers.jsonPath("[0].nom").value("Nom 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("[0].prenoms").value("Prénoms 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("[1].nom").value("Nom 2"));
	}

	// Get/clients/uuid
	@Test
	public void findByUuidTest() throws Exception {
		Client c1 = new Client("Dupont", "Jean");

		when(clientRepository.findById(UUID.fromString("dcf129f1-a2f9-47dc-8265-1d844244b192")))
				.thenReturn(Optional.of(c1));

		mockMvc.perform(MockMvcRequestBuilders.get("/clients/dcf129f1-a2f9-47dc-8265-1d844244b192"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Dupont"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.prenoms").value("Jean"));
	}

}
