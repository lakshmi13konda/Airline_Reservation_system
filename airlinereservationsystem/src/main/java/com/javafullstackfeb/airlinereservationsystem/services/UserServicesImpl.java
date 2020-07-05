package com.javafullstackfeb.airlinereservationsystem.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystem.dao.UserDAOImpl;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.CancelInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserInfo;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;
import com.javafullstackfeb.airlinereservationsystem.factory.AdminFactory;
import com.javafullstackfeb.airlinereservationsystem.factory.UserFactory;
import com.javafullstackfeb.airlinereservationsystem.validations.AirlineValidations;

public class UserServicesImpl implements UserServices {

	UserDAO dao = UserFactory.getUserDAOImplInstance();
	AirlineValidations validation = AdminFactory.getAirlineValidationsInstance();

	public boolean registerUser(UserInfo user) {
		// TODO Auto-generated method stub
		if (validation.validateId(user.getUserId())) {
			if (validation.nameValidation(user.getUserName())) {
				if (validation.emailValidation(user.getEmailId())) {

					return dao.registerUser(user);
				} else {
					throw new AirlineException("Please provide valid email");
				}
			} else {
				throw new AirlineException("Please provide valid name");
			}
		} else {
			throw new AirlineException("Please provide valid Id");
		}
	}

	public UserInfo authenticateUser(String emailId, String password) {
		if (validation.emailValidation(emailId)) {
			if (validation.validateLoginPassword(password)) {
			
				return dao.authenticateUser(emailId, password);
			} else {
				throw new AirlineException("Please provide valid password");
			}
		} else {
			throw new AirlineException("Please provide valid email");
		}

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

	@Override
	public BookingInfo bookFlight(BookingInfo bookingInfo) {
		// TODO Auto-generated method stub
		return dao.bookFlight(bookingInfo);
	}

	@Override
	public List<BookingInfo> myBooking(UserInfo user) {
		// TODO Auto-generated method stub
		return dao.myBooking(user);
	}

	@Override
	public CancelInfo cancelFlight(BookingInfo bookingInfo) {
		// TODO Auto-generated method stub
		return dao.cancelFlight(bookingInfo);
	}

}
