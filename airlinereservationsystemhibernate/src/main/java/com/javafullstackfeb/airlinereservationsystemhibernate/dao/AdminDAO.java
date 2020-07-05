package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.FlightDetails;

public interface AdminDAO {
	
	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();
	
	List<BookingStatus> getBookingStatus();

}
