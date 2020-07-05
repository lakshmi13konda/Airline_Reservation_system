package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dto.AdminInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.CancelInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserInfo;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;
import com.javafullstackfeb.airlinereservationsystem.repository.AirlineDatabase;

public class AdminDAOImpl implements AdminDAO {

	public boolean registerAdmin(AdminInfo admin) {
		// TODO Auto-generated method stub
		for (AdminInfo a1 : AirlineDatabase.adminInfo) {
			if ((a1.getEmailId()).equals(admin.getEmailId())) {
				return false;
			}
		}
		AirlineDatabase.adminInfo.add(admin);
		return true;
	}

	public AdminInfo authenticateAdmin(String email, String password) {
		for (AdminInfo a2 : AirlineDatabase.adminInfo) {
			if ((a2.getEmailId().equalsIgnoreCase(email)) && (a2.getPassword().equals(password))) {
				return a2;
			}
		}
		throw new AirlineException("Admin details not found");
	}

	public boolean addFlights(FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		for (FlightDetails b : AirlineDatabase.flightdetails ) {
			if (b.getFlightId() == flightDetails.getFlightId()) {
				return false;
			}
		}
		AirlineDatabase.flightdetails.add(flightDetails);
		return true;
	}

	public boolean removeFlight(int flightId) {
		// TODO Auto-generated method stub
		boolean removeStatus = false;
		for (int i = 0; i <= AirlineDatabase.flightdetails.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineDatabase.flightdetails.get(i);
			int retrievedId = retrievedFlight.getFlightId();
			if (flightId == retrievedId) {
				removeStatus = true;
				AirlineDatabase.flightdetails.remove(i);
				break;
			}
		}
		return removeStatus;
	}

	public List<FlightDetails> searchFlightByName(String flightname) {
		// TODO Auto-generated method stub
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineDatabase.flightdetails.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineDatabase.flightdetails.get(i);
			String retrievedFname = retrievedFlight.getFlightName();
			if (flightname.equals(retrievedFname)) {
				searchList.add(retrievedFlight);
				return searchList;
			}
		}
		if (searchList.size() == 0) {
			throw new AirlineException("Flight not found");
		} else {
			return searchList;
		}
	}

	public List<FlightDetails> searchFlightByarrivalCity(String arrivalCity) {
		
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		
		for (FlightDetails flightDetails : AirlineDatabase.flightdetails) {
//			System.out.println(flightDetails.toString());
			
			if(flightDetails.getArrivalCity().equalsIgnoreCase(arrivalCity)) {
				searchList.add(flightDetails);
				
			}
			
		}
		
		if (searchList.isEmpty()) {
			throw new AirlineException("Flight not found");
		} else {
			return searchList;
		}
	}

	public List<FlightDetails> searchFlightBydepartureCity(String departureCity) {
		// TODO Auto-generated method stub
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineDatabase.flightdetails.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineDatabase.flightdetails.get(i);
			String retrievedFdepartureCity = retrievedFlight.getDepartureCity();
			if (departureCity.equals(retrievedFdepartureCity)) {
				searchList.add(retrievedFlight);
			}
		}
		if (searchList.size() == 0) {
			throw new AirlineException("Flight not found");
		} else {
			return searchList;
		}
	}

	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return AirlineDatabase.flightdetails;
	}

	public boolean bookingStatus(UserInfo user, FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<BookingInfo> userBookings() {
		// TODO Auto-generated method stub
		List<BookingInfo> bookingInfos = new ArrayList<>();
		for (BookingInfo list : AirlineDatabase.bookingdetails) {
			bookingInfos.add(list);
		}
		if(bookingInfos.isEmpty()) {
			throw new AirlineException("No user booked the flight");
		}
		return bookingInfos;
	}

	@Override
	public List<CancelInfo> cancelledFlight() {
		// TODO Auto-generated method stub
		List<CancelInfo> cancelled = new ArrayList<>();
		for (CancelInfo list : AirlineDatabase.cancelInfos) {
			cancelled.add(list);
		}
		if(cancelled.isEmpty()) {
			throw new AirlineException("No user booked the flight");
		}
		return cancelled;
	}

	
	

}
