package com.javafullstack.airlinereservationjdbc.dao;

import java.util.List;

import com.javafullstack.airlinereservationjdbc.dto.BookingInfo;
import com.javafullstack.airlinereservationjdbc.dto.CancelInfo;
import com.javafullstack.airlinereservationjdbc.dto.FlightDetails;
import com.javafullstack.airlinereservationjdbc.dto.UserInfo;

public interface UserDAO {

	boolean registerUser(UserInfo user);

	UserInfo authenticateUser(String emailId, String password);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightByarrivalCity(String arrivalCity);

	List<FlightDetails> searchFlightBydepartureCity(String departureCity);

	List<FlightDetails> getFlightDetails();
	
	BookingInfo bookFlight(BookingInfo bookingInfo);
	
	List<BookingInfo> myBooking(UserInfo user);
	
	CancelInfo cancelFlight(BookingInfo bookingInfo);
	
}
