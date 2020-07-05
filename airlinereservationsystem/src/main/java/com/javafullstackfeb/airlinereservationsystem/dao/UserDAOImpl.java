package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dto.BookingInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.CancelInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserInfo;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;
import com.javafullstackfeb.airlinereservationsystem.factory.UserFactory;
import com.javafullstackfeb.airlinereservationsystem.repository.AirlineDatabase;

public class UserDAOImpl implements UserDAO {

	public boolean registerUser(UserInfo user) {
		for (UserInfo u1 : AirlineDatabase.userinfo) {
			if ((u1.getEmailId()).equals(user.getEmailId())) {
				return false;
			}
		}
		AirlineDatabase.userinfo.add(user);
		return true;
	}

	public UserInfo authenticateUser(String emailId, String password) {
		for (UserInfo u2 : AirlineDatabase.userinfo) {
			if ((u2.getEmailId().equalsIgnoreCase(emailId)) && (u2.getPassword().equals(password))) {
				return u2;
			}
		}
		throw new AirlineException("Invalid Credentials");
	}

	public List<FlightDetails> searchFlightByName(String flightname) {
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
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
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineDatabase.flightdetails.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineDatabase.flightdetails.get(i);
			String retrievedFarrivalCity = retrievedFlight.getArrivalCity();
			if (arrivalCity.equals(retrievedFarrivalCity)) {
				searchList.add(retrievedFlight);
			}
		}
		if (searchList.size() == 0) {
			throw new AirlineException("Flight not found");
		} else {
			return searchList;
		}
	}

	public List<FlightDetails> searchFlightBydepartureCity(String departureCity) {
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
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
		return AirlineDatabase.flightdetails;
	}

	@Override
	public BookingInfo bookFlight(BookingInfo bookingInfo) {

		BookingInfo bookingInfo2 = new BookingInfo();
		int noOfSeats;

		for (UserInfo user : AirlineDatabase.userinfo) {
			if (bookingInfo.getUser().getUserId() == user.getUserId()) {
				bookingInfo2.setUser(user);
			}
		}

		for (BookingInfo checking : AirlineDatabase.bookingdetails) {
			if (checking.getUser().getUserId() == bookingInfo.getUser().getUserId()) {
				if (checking.getFlightDetail().getArrivalCity()
						.equalsIgnoreCase(bookingInfo.getFlightDetail().getArrivalCity())
						&& (checking.getFlightDetail().getDepartureCity()
								.equalsIgnoreCase(bookingInfo.getFlightDetail().getDepartureCity()))) {
					throw new AirlineException("You have Already booked the Flight");
				}
			}
		}

		for (FlightDetails info : AirlineDatabase.flightdetails) {
			if (info.getArrivalCity().equalsIgnoreCase(bookingInfo.getFlightDetail().getArrivalCity())
					&& info.getDepartureCity().equalsIgnoreCase(bookingInfo.getFlightDetail().getDepartureCity())
					&& info.getNoofseatsavailable() > 0) {
				noOfSeats = info.getNoofseatsavailable();
				noOfSeats--;
				info.setNoofseatsavailable(noOfSeats);
				bookingInfo2.setFlightDetail(info);
				AirlineDatabase.bookingdetails.add(bookingInfo2);
				return bookingInfo2;
			}

		}
		throw new AirlineException("Flight not found");
	}

	@Override
	public List<BookingInfo> myBooking(UserInfo user) {
		// TODO Auto-generated method stub
		List<BookingInfo> bookingInfos = new ArrayList<>();

		for (BookingInfo bookingInfo : AirlineDatabase.bookingdetails) {
			if (bookingInfo.getUser().getUserId() == user.getUserId()) {
				bookingInfos.add(bookingInfo);
			}

		}
		if (bookingInfos.isEmpty()) {
			throw new AirlineException("U haven't booked any flight");
		}
		return bookingInfos;
	}

	@Override
	public CancelInfo cancelFlight(BookingInfo bookingInfo) {

		CancelInfo cancelInfo = new CancelInfo();
//		for (UserInfo user : AirlineDatabase.userinfo) {
//			if (bookingInfo.getUser().getUserId() == user.getUserId()) {
//				bookingInfo.setUser(user);
//			}
//		}
		int noOfSeats;
		for (BookingInfo bookingInfo2 : AirlineDatabase.bookingdetails) {
			if (bookingInfo2.getTicketNo() == bookingInfo.getTicketNo()) {
				if (bookingInfo2.getUserid() == bookingInfo.getUserid()) {

					cancelInfo.setFlightDetails(bookingInfo2.getFlightDetail());
					cancelInfo.setTicketno(bookingInfo2.getTicketNo());
					cancelInfo.setUserInfo(bookingInfo2.getUser());
					AirlineDatabase.cancelInfos.add(cancelInfo);
					for (FlightDetails info : AirlineDatabase.flightdetails) {
						if (info.getFlightId() == bookingInfo2.getFlightDetail().getFlightId()) {
							noOfSeats = info.getNoofseatsavailable();
							noOfSeats++;
							info.setNoofseatsavailable(noOfSeats);
							break;
						}
					}

					AirlineDatabase.bookingdetails.remove(bookingInfo2);
					return cancelInfo;

				}

			}

		}

		throw new AirlineException("Invalid TicketNo");
	}

}
