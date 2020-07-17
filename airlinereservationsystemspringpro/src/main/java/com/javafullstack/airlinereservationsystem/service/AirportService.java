package com.javafullstack.airlinereservationsystem.service;

import java.util.List;

import com.javafullstack.airlinereservationsystem.beans.AirportBeans;

public interface AirportService {
	
	public boolean addAirport(AirportBeans airport);

	public boolean updateAirport(AirportBeans airport);

	public boolean deleteAirport(String abbreviation);

	public List<AirportBeans> getAllAirport();
	

	
}
