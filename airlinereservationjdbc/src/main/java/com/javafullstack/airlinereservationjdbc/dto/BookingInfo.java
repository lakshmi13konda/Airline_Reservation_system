package com.javafullstack.airlinereservationjdbc.dto;

import lombok.Data;

@Data
public class BookingInfo {

	private int flightId;
	private int noofpassengers;
	private int userId;
	private int ticketNo;
}
