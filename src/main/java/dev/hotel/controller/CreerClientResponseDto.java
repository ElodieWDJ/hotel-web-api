package dev.hotel.controller;

import java.util.UUID;

import dev.hotel.entite.Client;

public class CreerClientResponseDto {
	private UUID uuid;

	public CreerClientResponseDto(Client client) {
		this.uuid = client.getUuid();
		this.setNom(client.getNom());
		this.setPrenoms(client.getPrenoms());
	}

	private void setPrenoms(String prenoms) {
		// TODO Auto-generated method stub

	}

	private void setNom(String nom) {
		// TODO Auto-generated method stub

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
