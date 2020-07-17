package com.javafullstack.airlinereservationsystem.service;

import java.util.List;

import com.javafullstack.airlinereservationsystem.beans.FlightBooking;
import com.javafullstack.airlinereservationsystem.beans.FlightInformation;

public interface FlightService {

	public FlightInformation getFlight(String flightNumber);

	public boolean addFlight(FlightInformation flightInformation);

	public boolean updateFlight(FlightInformation flightInformation);

	public boolean deleteFlight(String flightNumber);

	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate);

	public List<FlightInformation> getAllFlights();

	public FlightBooking bookFlight(FlightBooking flightBooking);

	public List<FlightBooking> getAllBooking(String userId);
	
	public boolean deleteBooking(String bookingId);
}
