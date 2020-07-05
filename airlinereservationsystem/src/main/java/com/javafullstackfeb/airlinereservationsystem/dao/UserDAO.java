package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dto.BookingInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.CancelInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserInfo;

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
