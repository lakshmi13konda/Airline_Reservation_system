package com.javafullstack.airlinereservationsystem.response;

import java.util.List;

import com.javafullstack.airlinereservationsystem.beans.AirportBeans;

import lombok.Data;
@Data
public class AirportResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<AirportBeans> searchAirport;
}
