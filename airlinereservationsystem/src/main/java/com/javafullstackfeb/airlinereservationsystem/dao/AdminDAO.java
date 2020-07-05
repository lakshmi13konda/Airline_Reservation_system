package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dto.AdminInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.CancelInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserInfo;

public interface AdminDAO {

	boolean registerAdmin(AdminInfo admin);

	AdminInfo authenticateAdmin(String email, String password);

	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightByarrivalCity(String arrivalCity);

	List<FlightDetails> searchFlightBydepartureCity(String departureCity);

	List<FlightDetails> getFlightDetails();

	boolean bookingStatus(UserInfo user, FlightDetails flightDetails);
	
	List<BookingInfo> userBookings();
	
	
	List<CancelInfo> cancelledFlight();

	
}
