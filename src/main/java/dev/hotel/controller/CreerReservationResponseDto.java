package dev.hotel.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Reservation;

public class CreerReservationResponseDto {
	private UUID uuid;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private UUID clientId;
	private List<String> chambres;

	public CreerReservationResponseDto(Reservation reservation) {
		this.uuid = reservation.getUuid();
		this.dateDebut = reservation.getDateDebut();
		this.dateFin = reservation.getDateFin();
		this.clientId = reservation.getClient().getUuid();

		for (Chambre chambre : reservation.getChambres()) {
			chambres.add(chambre.getUuid().toString());
		}
	}

}
