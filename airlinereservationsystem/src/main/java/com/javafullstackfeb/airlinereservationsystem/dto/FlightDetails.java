package com.javafullstackfeb.airlinereservationsystem.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@SuppressWarnings(value = { "serial" })
@Data
public class FlightDetails implements Serializable{

	private int flightId;
	private String flightName;
	private String arrivalCity;
	private String departureCity;
	private int noofseatsavailable;
	private LocalDateTime arrivalDateTime;
	private LocalDateTime departureDateTime;
}
