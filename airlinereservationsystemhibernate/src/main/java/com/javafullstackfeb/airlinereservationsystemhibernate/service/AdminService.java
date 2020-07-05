package com.javafullstackfeb.airlinereservationsystemhibernate.service;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.FlightDetails;



public interface AdminService {
 
	

	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	List<BookingStatus> getBookingStatus();
	
	boolean validateFlightID(int flightid);
	
	boolean validateSource(String source);
	
	boolean validateDestination(String destination);
	
	boolean validateFlightName(String flightname);
}
