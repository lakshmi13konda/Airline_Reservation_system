package com.javafullstackfeb.airlinereservationsystem.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystem.dto.AdminInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.CancelInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserInfo;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;
import com.javafullstackfeb.airlinereservationsystem.factory.AdminFactory;
import com.javafullstackfeb.airlinereservationsystem.validations.AirlineValidations;


public class AdminServiceImpl implements AdminService {

	AdminDAO admindao = AdminFactory.getAdminDAOImplInstance();

	AirlineValidations validation = AdminFactory.getAirlineValidationsInstance();

	public boolean registerAdmin(AdminInfo admin) {
		if (validation.validateId(admin.getId())) {
			if (validation.nameValidation(admin.getName())) {
				if (validation.emailValidation(admin.getEmailId())) {
					if (validation.validatePassword(admin.getPassword())) {
						return admindao.registerAdmin(admin);
					}
				}
			}

		} else {
			throw new AirlineException("Something went wrong");
		}
		return false;
	}

	public AdminInfo authenticateAdmin(String email, String password) {
		if (validation.emailValidation(email)) {
			if (validation.validateLoginPassword(password)) {
				return admindao.authenticateAdmin(email, password);
			}
		} 
		return null;
	}

	public boolean addFlights(FlightDetails flightDetails) {

		return admindao.addFlights(flightDetails);
	}

	public boolean removeFlight(int flightId) {

		if (flightId != 0) {
			if (validation.validateId(flightId)) {
				return admindao.removeFlight(flightId);
			}
		}
		return false;
	}

	public List<FlightDetails> searchFlightByName(String flightname) {

		if (flightname != null) {
			if (validation.validateFlightName(" " + flightname)) {
				return admindao.searchFlightByName(flightname);
			}
		}
		return null;
	}

	public List<FlightDetails> searchFlightByarrivalCity(String arrivalCity) {

		if (validation.validateFlightName(arrivalCity)) {
			return admindao.searchFlightByarrivalCity(arrivalCity);
		}
		return null;
	}

	public List<FlightDetails> searchFlightBydepartureCity(String departureCity) {

		return admindao.searchFlightBydepartureCity(departureCity);
	}

	public List<FlightDetails> getFlightDetails() {
		return admindao.getFlightDetails();
	}

	public boolean bookingStatus(UserInfo user, FlightDetails flightDetails) {
		UserInfo userinfo = new UserInfo();
		if (validation.validateId(userinfo.getUserId())) {
			return admindao.bookingStatus(user, flightDetails);
		}
		return false;
	}

	@Override
	public List<BookingInfo> userBooking() {
		// TODO Auto-generated method stub
		return admindao.userBookings();
	}

	@Override
	public List<CancelInfo> cancelledFlight() {
		// TODO Auto-generated method stub
		return admindao.cancelledFlight();
	}

	
}
