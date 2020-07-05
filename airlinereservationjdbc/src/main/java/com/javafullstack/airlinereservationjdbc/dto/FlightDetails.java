package com.javafullstack.airlinereservationjdbc.dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

import lombok.Data;

@SuppressWarnings(value = { "serial" })
@Data
public class FlightDetails implements Serializable{

	private int flightId;
	private String flightName;
	private String arrivalCity;
	private String departureCity;
	private int noofseatsavailable;
	private Date arrivalDate;
	private Date departureDate;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
}
