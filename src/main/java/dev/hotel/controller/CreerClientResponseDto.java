package dev.hotel.controller;

import java.util.UUID;

import dev.hotel.entite.Client;

public class CreerClientResponseDto {
	private UUID uuid;
	private String prenom;
	private String nom;

	public CreerClientResponseDto(Client client) {
		this.uuid = client.getUuid();
		this.nom = client.getNom();
		this.prenom = client.getPrenoms();
	}

	/**
	 * @return the uuid
	 */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
