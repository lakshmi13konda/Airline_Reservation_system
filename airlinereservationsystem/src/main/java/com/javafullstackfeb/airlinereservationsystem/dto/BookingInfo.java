package com.javafullstackfeb.airlinereservationsystem.dto;

import lombok.Data;

@Data
public class BookingInfo {

	private FlightDetails flightDetail;
	private UserInfo user;
	private int noofpassengers;
	private int userid;
	private int ticketNo;
	private double ticketprice;
}
