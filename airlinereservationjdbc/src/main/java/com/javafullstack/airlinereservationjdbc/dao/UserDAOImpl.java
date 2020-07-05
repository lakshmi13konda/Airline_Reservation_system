package com.javafullstack.airlinereservationjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.javafullstack.airlinereservationjdbc.dto.BookingInfo;
import com.javafullstack.airlinereservationjdbc.dto.CancelInfo;
import com.javafullstack.airlinereservationjdbc.dto.FlightDetails;
import com.javafullstack.airlinereservationjdbc.dto.UserInfo;
import com.javafullstack.airlinereservationjdbc.exception.AirlineException;
import com.javafullstack.airlinereservationjdbc.jdbcutility.JdbcUtility;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserDAOImpl implements UserDAO {

	PreparedStatement preparedstatement = null;
	Connection conn = null;
	ResultSet rs = null;

	public boolean registerUser(UserInfo user) {
		conn = JdbcUtility.getConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3305/airlines_reservation?useSSL=false&user=root&password=rootStudent4091@lakshmi";
			conn = DriverManager.getConnection(dburl);
			PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.insertQuery);
			preparedstatement.setInt(1, user.getUserId());
			preparedstatement.setString(2, user.getUserName());
			preparedstatement.setString(3, user.getEmailId());
			preparedstatement.setString(4, user.getPassword());
			preparedstatement.setLong(5, user.getMobileNumber());
			preparedstatement.setString(6, user.getRole());
			preparedstatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new AirlineException("Email already exists");
		}
		return true;
	}

	public UserInfo authenticateUser(String emailId, String password) {
		UserInfo bean = new UserInfo();
		conn = JdbcUtility.getConnection();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3305/airlines_reservation?useSSL=false&user=root&password=rootStudent4091@lakshmi";
			conn = DriverManager.getConnection(dburl);
			PreparedStatement pstmt = conn.prepareStatement(QueryMapper.userLogin);
			pstmt.setString(1, emailId);
			pstmt.setString(2, password);
			try {
				System.out.println("20");
				ResultSet rs = pstmt.executeQuery();
				System.out.println("resultset before");
				while (rs.next()) {
					System.out.println("resultset after");
					System.out.println(15);
					bean.setEmailId(rs.getString("useremailId"));
					bean.setPassword(rs.getString("userPassword"));
					bean.setUserId(rs.getInt("userId"));
					bean.setUserName(rs.getString("userName"));
					bean.setMobileNumber(rs.getLong("userMobileNum"));
					bean.setRole(rs.getString("role"));
					return bean;
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new AirlineException("Invalid Login Credentials, Please provide valid details");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AirlineException("Invalid Login Credentials, Please provide valid details");

		}
		throw new AirlineException("Invalid Login Credentials, Please provide valid details");

	}

	public List<FlightDetails> searchFlightByName(String flightname) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = JdbcUtility.getConnection();
				PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.searchFlightByName);) {
			preparedstatement.setString(1, flightname);
			try (ResultSet resultSet = preparedstatement.executeQuery();) {
				while (resultSet.next()) {
					flight = new FlightDetails();
					flight.setFlightId(resultSet.getInt("flightId"));
					flight.setFlightName(resultSet.getString("flightName"));
					flight.setArrivalCity(resultSet.getString("flightArrivalcity"));
					flight.setDepartureCity(resultSet.getString("flightDeparturecity"));
					flight.setNoofseatsavailable(resultSet.getInt("noofseatsAvailiable"));
					flight.setArrivalDate(resultSet.getDate("arrivalDate"));
					flight.setDepartureDate(resultSet.getDate("departureDate"));
					flight.setArrivalTime(resultSet.getTime("arrivalTime").toLocalTime());
					flight.setDepartureTime(resultSet.getTime("departureTime").toLocalTime());
					searchList.add(flight);
					
				}
			}
		} catch (Exception e) {
			throw new AirlineException(e.getMessage());
		}
		return searchList;
	}

	public List<FlightDetails> searchFlightByarrivalCity(String flightArraivalcity) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = JdbcUtility.getConnection();
				PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.searchFlightBySource);) {
			preparedstatement.setString(1, flightArraivalcity);
			try (ResultSet resultSet = preparedstatement.executeQuery();) {
				if (resultSet.next()) {
					flight = new FlightDetails();
					flight.setFlightId(resultSet.getInt("flightId"));
					flight.setFlightName(resultSet.getString("flightName"));
					flight.setArrivalCity(resultSet.getString("flightArrivalcity"));
					flight.setDepartureCity(resultSet.getString("flightDeparturecity"));
					flight.setNoofseatsavailable(resultSet.getInt("noofseatsAvailiable"));
					flight.setArrivalDate(resultSet.getDate("arrivalDate"));
					flight.setDepartureDate(resultSet.getDate("departureDate"));
					flight.setArrivalTime(resultSet.getTime("arrivalTime").toLocalTime());
					flight.setDepartureTime(resultSet.getTime("departureTime").toLocalTime());
					searchList.add(flight);
					return searchList;
				}
			}
		} catch (Exception e) {
			throw new AirlineException(e.getMessage());
		}
		throw new AirlineException("Cannot find any Flight With This Source");
	}

	public List<FlightDetails> searchFlightBydepartureCity(String departureCity) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = JdbcUtility.getConnection();
				PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.searchFlightByDestination)) {
			preparedstatement.setString(1, departureCity);
			try (ResultSet resultSet = preparedstatement.executeQuery();) {
				while (resultSet.next()) {
					flight = new FlightDetails();
					flight.setFlightId(resultSet.getInt("flightId"));
					flight.setFlightName(resultSet.getString("flightName"));
					flight.setArrivalCity(resultSet.getString("flightArrivalcity"));
					flight.setDepartureCity(resultSet.getString("flightDeparturecity"));
					flight.setNoofseatsavailable(resultSet.getInt("noofseatsAvailiable"));
					flight.setArrivalDate(resultSet.getDate("arrivalDate"));
					flight.setDepartureDate(resultSet.getDate("departureDate"));
					flight.setArrivalTime(resultSet.getTime("arrivalTime").toLocalTime());
					flight.setDepartureTime(resultSet.getTime("departureTime").toLocalTime());
					searchList.add(flight);
					
				}
			}
		} catch (Exception e) {
			throw new AirlineException(e.getMessage());
		}
		return searchList;
	}

	public List<FlightDetails> getFlightDetails() {
		List<FlightDetails> flightList = new LinkedList<FlightDetails>();
		try (Connection conn = JdbcUtility.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(QueryMapper.showFlights)) {
			while (resultSet.next()) {
				FlightDetails info = new FlightDetails();
				info = new FlightDetails();
				info.setFlightId(resultSet.getInt("flightId"));
				info.setFlightName(resultSet.getString("flightName"));
				info.setArrivalCity(resultSet.getString("flightArrivalcity"));
				info.setDepartureCity(resultSet.getString("flightDeparturecity"));
				info.setNoofseatsavailable(resultSet.getInt("noofseatsAvailiable"));
				info.setArrivalDate(resultSet.getDate("arrivalDate"));
				info.setDepartureDate(resultSet.getDate("departureDate"));
				info.setArrivalTime(resultSet.getTime("arrivalTime").toLocalTime());
				info.setDepartureTime(resultSet.getTime("departureTime").toLocalTime());
				flightList.add(info);
			}
			if (flightList.isEmpty()) {
				throw new AirlineException("No Flight Present in the Airline");
			} else {
				return flightList;
			}
		} catch (Exception e) {
			throw new AirlineException(e.getMessage());
		}
	}

	public BookingInfo bookFlight(BookingInfo bookingInfo) {

		int noofseats = 0;
		BookingInfo bookingInfo2 = new BookingInfo();
		try (Connection conn = JdbcUtility.getConnection();
				PreparedStatement stmt = conn.prepareStatement(QueryMapper.bookinginfo);) {
			stmt.setInt(1, bookingInfo.getFlightId());
			System.out.println(bookingInfo.getFlightId());
			stmt.setInt(2, bookingInfo.getUserId());
			System.out.println(bookingInfo.getUserId());
			stmt.setInt(3, bookingInfo.getTicketNo());
			System.out.println(bookingInfo.getTicketNo());
			stmt.setInt(4, bookingInfo.getNoofpassengers());
			System.out.println(bookingInfo.getNoofpassengers());
			stmt.executeUpdate();
			PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.noofseatsreduced);
			preparedstatement.setInt(1, bookingInfo.getFlightId());
			try (ResultSet resultSet = preparedstatement.executeQuery()) {
				while (resultSet.next()) {
					noofseats = resultSet.getInt("noofseatsAvailiable");
					noofseats = noofseats - bookingInfo.getNoofpassengers();
				}
			}
			PreparedStatement preparedstatement1 = conn.prepareStatement(QueryMapper.updateSeats);
			preparedstatement1.setInt(1, noofseats);
			preparedstatement1.setInt(2, bookingInfo.getFlightId());
			int resultSet = preparedstatement1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AirlineException(e.getMessage());
		}
		return bookingInfo2;

	}

	public List<BookingInfo> myBooking(UserInfo user) {
		
		
		
		List<BookingInfo> list = new ArrayList<BookingInfo>();
		try (Connection conn = JdbcUtility.getConnection();
				PreparedStatement stmt = conn.prepareStatement(QueryMapper.bookedflight);) {
				stmt.setInt(1, user.getUserId());
				ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("flight Id "+ resultSet.getInt("flightId") );
				BookingInfo bookingInfo2 = new BookingInfo();
				bookingInfo2.setFlightId(resultSet.getInt("flightId"));
				bookingInfo2.setUserId(resultSet.getInt("userId"));
				bookingInfo2.setTicketNo(resultSet.getInt("ticketNo"));
				bookingInfo2.setNoofpassengers(resultSet.getInt("noofpassengers"));
				list.add(bookingInfo2);
				
			}
		} catch (Exception e) {
			throw new AirlineException(e.getMessage());
		}
		return list;
	}

	public CancelInfo cancelFlight(BookingInfo bookingInfo) {
		int noofseats = 0;
		int fId = 0;
		int noofpass = 0;
		CancelInfo cancelInfo = new CancelInfo();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.cancelTicket);
			preparedstatement.setInt(1, bookingInfo.getTicketNo());
			try (ResultSet resultSet = preparedstatement.executeQuery();) {

				while (resultSet.next()) {
					fId = resultSet.getInt("flightId");
					noofpass = resultSet.getInt("noofpassengers");
				}
			}
			PreparedStatement preparedstatement2 = conn.prepareStatement(QueryMapper.noofseatsreduced);
			preparedstatement2.setInt(1, fId);
			try (ResultSet resultSet = preparedstatement2.executeQuery()) {
				while (resultSet.next()) {
					noofseats = resultSet.getInt("noofseatsAvailiable");
					noofseats = noofseats + noofpass;
				}
			}
			PreparedStatement preparedstatement1 = conn.prepareStatement(QueryMapper.updateSeats);
			preparedstatement1.setInt(1, noofseats);
			preparedstatement1.setInt(2, fId);
			int resultSet = preparedstatement1.executeUpdate();
//			PreparedStatement preparedstatement2 = conn.prepareStatement(QueryMapper.noofseatsreduced);
//			preparedstatement2.setInt(1, fId);
//			try (ResultSet resultSet = preparedstatement2.executeQuery();) {
//
//				while (resultSet.next()) {
//					noofseats = resultSet.getInt("noofseatsAvailiable");
//					System.out.println("before adding passengers"+noofseats);
//					noofseats = noofseats + noofpass;
////					FlightDetails info = new FlightDetails();
////					info.setNoofseatsavailable(noofseats);
//				}
//			}
//			
//			PreparedStatement preparedstatement3 = conn.prepareStatement(QueryMapper.updateSeats);
//			preparedstatement3.setInt(1, noofseats);
//			System.out.println("no of seats available "+ noofseats);
//			preparedstatement3.setInt(2, bookingInfo.getFlightId());
//			int resultSet = preparedstatement3.executeUpdate();
//			
			
			try (Connection conn = JdbcUtility.getConnection();
					PreparedStatement stmt = conn.prepareStatement(QueryMapper.deleteticket);) {
				stmt.setInt(1, bookingInfo.getTicketNo());
				
				stmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new AirlineException(e.getMessage());
		}
		return cancelInfo;

	}
}
