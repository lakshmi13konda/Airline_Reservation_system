package com.javafullstackfeb.airlinereservationsystem.dto;

import lombok.Data;

@Data
public class CancelInfo {

	private FlightDetails flightDetails;
	private UserInfo userInfo;
	private int ticketno;
	
}
