package dev.hotel.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.repository.ReservationRepository;

public class ReservationService {
	private static ReservationRepository reservationRepository;
	private static ClientService clientService;

	public ReservationService(ReservationRepository repository, ClientService service) {
		ReservationService.reservationRepository = repository;
		ReservationService.clientService = service;

	}

	@Transactional
	public Reservation creerReservation(LocalDate dateDebut, LocalDate dateFin, Client client, List<Chambre> chambres) {
		// clientService.recupererClient(clientId);

		return reservationRepository.save(new Reservation(dateDebut, dateFin, client, chambres));

	}
}
