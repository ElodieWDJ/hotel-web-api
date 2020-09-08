package dev.hotel.controller;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

public class CreerReservationRequestDto {
	@NotBlank
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Integer clientId;
	private String chambre;

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param clientId
	 * @param chambre
	 */
	public CreerReservationRequestDto(@NotBlank LocalDate dateDebut, LocalDate dateFin, Integer clientId,
			String chambre) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.clientId = clientId;
		this.chambre = chambre;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the chambre
	 */
	public String getChambre() {
		return chambre;
	}

	/**
	 * @param chambre the chambre to set
	 */
	public void setChambre(String chambre) {
		this.chambre = chambre;
	}
}
