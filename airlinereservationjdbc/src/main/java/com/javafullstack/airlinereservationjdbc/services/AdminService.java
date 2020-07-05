package com.javafullstack.airlinereservationjdbc.services;

import java.util.List;

import com.javafullstack.airlinereservationjdbc.dto.AdminInfo;
import com.javafullstack.airlinereservationjdbc.dto.BookingInfo;
import com.javafullstack.airlinereservationjdbc.dto.CancelInfo;
import com.javafullstack.airlinereservationjdbc.dto.FlightDetails;
import com.javafullstack.airlinereservationjdbc.dto.UserInfo;

public interface AdminService {

	boolean registerAdmin(AdminInfo admin);

	AdminInfo authenticateAdmin(String email, String password);

	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightByarrivalCity(String arrivalCity);

	List<FlightDetails> searchFlightBydepartureCity(String departureCity);

	List<FlightDetails> getFlightDetails();

	boolean bookingStatus(UserInfo user, FlightDetails flightDetails);

	List<BookingInfo> userBooking();
	
	List<CancelInfo> cancelledFlight();
}
