package com.javafullstackfeb.airlinereservationsystemhibernate.service;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystemhibernate.factory.AirlineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.validation.Validation;


public class UserServiceJPAImpl implements UserService{

	private UserDAO dao = AirlineFactory.getUserDAOImplInstance();
	private Validation validation = new Validation();
	
	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		if (validation.validatedName(flightname)) {
			return dao.searchFlightByName(flightname);
		}
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		if (validation.validatedSource(source)) {
			return dao.searchFlightBySource(source);
		}
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		if (validation.validatedDestination(destination)) {
			return dao.searchFlightByDestination(destination);
		}
		return null;
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		return dao.getFlightDetails();
	}

	@Override
	public BookingStatus bookRequest(BookingStatus bookingStatus) {
		if (bookingStatus!=null) {
			return dao.bookRequest(bookingStatus);
		}
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		if (validation.validatedSource(source)) {
			if (validation.validatedDestination(destination)) {
				return dao.searchFlightBySourceAndDestination(source, destination);
			}
		}
		return null;
	}

	@Override
	public boolean cancelTicket(int ticketId) {
		if (validation.validatedId(ticketId)) {
			return dao.cancelTicket(ticketId);
		}
		return false;
	}

	@Override
	public List<BookingStatus> getTicketDetails(int userId) {
		if(validation.validatedId(userId)) {
			return dao.getTicketDetails(userId);
			}
			return null;
	}

}
