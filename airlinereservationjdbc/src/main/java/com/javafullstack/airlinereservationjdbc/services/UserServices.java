package com.javafullstack.airlinereservationjdbc.services;

import java.util.List;

import com.javafullstack.airlinereservationjdbc.dto.BookingInfo;
import com.javafullstack.airlinereservationjdbc.dto.CancelInfo;
import com.javafullstack.airlinereservationjdbc.dto.FlightDetails;
import com.javafullstack.airlinereservationjdbc.dto.UserInfo;

public interface UserServices {

	boolean registerUser(UserInfo user);

	UserInfo authenticateUser(String emailId, String password);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightByarrivalCity(String arrivalCity);

	List<FlightDetails> searchFlightBydepartureCity(String departureCity);

	List<FlightDetails> getFlightDetails();

	List<BookingInfo> myBooking(UserInfo userBean);

	BookingInfo bookFlight(BookingInfo bookingInfo);
	
	CancelInfo cancelFlight(BookingInfo bookingInfo);
}
