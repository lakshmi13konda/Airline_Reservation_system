package com.javafullstack.airlinereservationjdbc.services;

import java.util.List;

import com.javafullstack.airlinereservationjdbc.dao.UserDAO;
import com.javafullstack.airlinereservationjdbc.dto.BookingInfo;
import com.javafullstack.airlinereservationjdbc.dto.CancelInfo;
import com.javafullstack.airlinereservationjdbc.dto.FlightDetails;
import com.javafullstack.airlinereservationjdbc.dto.UserInfo;
import com.javafullstack.airlinereservationjdbc.factory.UserFactory;

public class UserServicesImpl implements UserServices {

	UserDAO dao = UserFactory.getUserDAOImplInstance();
	
	public boolean registerUser(UserInfo user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}

	public UserInfo authenticateUser(String emailId, String password) {
		// TODO Auto-generated method stub
		return dao.authenticateUser(emailId, password);
	}

	public List<FlightDetails> searchFlightByName(String flightname) {
		// TODO Auto-generated method stub
		return dao.searchFlightByName(flightname);
	}

	public List<FlightDetails> searchFlightByarrivalCity(String arrivalCity) {
		// TODO Auto-generated method stub
		return dao.searchFlightByarrivalCity(arrivalCity);
	}

	public List<FlightDetails> searchFlightBydepartureCity(String departureCity) {
		// TODO Auto-generated method stub
		return dao.searchFlightBydepartureCity(departureCity);
	}

	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return dao.getFlightDetails();
	}

	public List<BookingInfo> myBooking(UserInfo userBean) {
		// TODO Auto-generated method stub
		return dao.myBooking(userBean);
	}

	public BookingInfo bookFlight(BookingInfo bookingInfo) {
		// TODO Auto-generated method stub
		return dao.bookFlight(bookingInfo);
	}

	@Override
	public CancelInfo cancelFlight(BookingInfo bookingInfo) {
		// TODO Auto-generated method stub
		return dao.cancelFlight(bookingInfo);
	}

}
