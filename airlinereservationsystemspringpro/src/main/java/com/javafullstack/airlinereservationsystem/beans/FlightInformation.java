package com.javafullstack.airlinereservationsystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity
@Table(name = "flight_info")
public class FlightInformation {

	@Id
	@Column(name = "flightno")
	//@Pattern(regexp = "{A-Z0-9}*")
	private String flightNumber; // Each flight has a unique flight number.

	@Column(name = "departure_city")
	//@Pattern(regexp = "{A-Za-z}*")
	private String departureCity;

	@Column(name = "arrival_city")
	//@Pattern(regexp = "{A-Za-z}*")
	private String arrivalCity;

	@Column(name = "airline")
	//@Pattern(regexp = "{A-Za-z}*")
	private String airline;

	@Column(name = "dep_date")
	private String departureDate;

	@Column(name = "arr_date")
	private String arrivalDate;

	@Column(name = "dep_time")
	private String departureTime;

	@Column(name = "arr_time")
	private String arrivalTime;

	@Column(name = "first_seats")
	@Positive
	private int firstClassSeats;

	@Column(name = "first_fare")
	@Positive
	private double firstClassSeatFare;

	@Column(name = "buss_seats")
	@Positive
	private int bussinessClassSeats;

	@Column(name = " buss_Seats_Fare")
	@Positive
	private double bussinessClassFare;


}
