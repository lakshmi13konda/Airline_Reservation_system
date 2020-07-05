package com.javafullstack.airlinereservationjdbc.dto;

import lombok.Data;

@Data
public class CancelInfo {

	private int flightId;
	private int userId;
	private int ticketno;
}
