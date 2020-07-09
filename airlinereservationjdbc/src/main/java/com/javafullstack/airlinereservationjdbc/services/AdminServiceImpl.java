package com.javafullstack.airlinereservationjdbc.services;

import java.util.List;

import com.javafullstack.airlinereservationjdbc.dao.AdminDAO;
import com.javafullstack.airlinereservationjdbc.dao.AdminDAOImpl;
import com.javafullstack.airlinereservationjdbc.dto.AdminInfo;
import com.javafullstack.airlinereservationjdbc.dto.BookingInfo;
import com.javafullstack.airlinereservationjdbc.dto.CancelInfo;
import com.javafullstack.airlinereservationjdbc.dto.FlightDetails;
import com.javafullstack.airlinereservationjdbc.dto.UserInfo;
import com.javafullstack.airlinereservationjdbc.factory.AdminFactory;


public class AdminServiceImpl implements AdminService {
	
	
	AdminDAO admindao = AdminFactory.getAdminDAOImplInstance();
	
	public boolean registerAdmin(AdminInfo admin) {
		// TODO Auto-generated method stub
		return admindao.registerAdmin(admin);
	}

	public AdminInfo authenticateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return admindao.authenticateAdmin(email, password);
		
	}

	public boolean addFlights(FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return admindao.addFlights(flightDetails);
	}

	public boolean removeFlight(int flightId) {
		// TODO Auto-generated method stub
		return admindao.removeFlight(flightId);
	}

	public List<FlightDetails> searchFlightByName(String flightname) {
		// TODO Auto-generated method stub
		return admindao.searchFlightByName(flightname);
	}

	public List<FlightDetails> searchFlightByarrivalCity(String arrivalCity) {
		// TODO Auto-generated method stub
		return admindao.searchFlightByarrivalCity(arrivalCity);
	}

	public List<FlightDetails> searchFlightBydepartureCity(String departureCity) {
		// TODO Auto-generated method stub
		return admindao.searchFlightBydepartureCity(departureCity);
	}

	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return admindao.getFlightDetails();
	}

	public boolean bookingStatus(UserInfo user, FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return admindao.bookingStatus(user, flightDetails);
	}

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
