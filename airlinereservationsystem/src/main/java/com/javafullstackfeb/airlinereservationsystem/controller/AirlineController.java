package com.javafullstackfeb.airlinereservationsystem.controller;

import org.apache.log4j.Logger;

import com.javafullstackfeb.airlinereservationsystem.repository.AirlineDatabase;

public class AirlineController {

	public static final Logger LOGGER = Logger.getLogger(SubAirlineController.class);
	public static void main(String[] args) {
		AirlineDatabase.addToDataBase();
		SubAirlineController.airlineReservationOperations();
	}
}