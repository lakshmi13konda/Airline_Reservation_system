package com.javafullstack.airlinereservationsystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity
@Table(name = "airlineExecutive")
public class AirlineExecutiveBeans {

	@Id
	@Column
	//@Pattern(regexp = "{A-Za-z0-9}*")
	private String flightNumber;

	@Column
	@Positive
	private long totalSeats;

	@Column
	@Positive
	private long totalBussinessClassSeats;

	@Column
	@Positive
	private long totalFirstClassSeats;

	@Column
	@Positive
	private int availableBussinessClassSeats;

	@Column
	@Positive
	private long bookedBussinessClassSeats;

	@Column
	@Positive
	private int availableFirstClassSeats;

	@Column
	@Positive
	private long bookedFirstClassSeats;

}
