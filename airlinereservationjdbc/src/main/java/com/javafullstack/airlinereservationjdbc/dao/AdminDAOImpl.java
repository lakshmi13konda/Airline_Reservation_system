package com.javafullstack.airlinereservationjdbc.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.javafullstack.airlinereservationjdbc.dto.AdminInfo;
import com.javafullstack.airlinereservationjdbc.dto.BookingInfo;
import com.javafullstack.airlinereservationjdbc.dto.CancelInfo;
import com.javafullstack.airlinereservationjdbc.dto.FlightDetails;
import com.javafullstack.airlinereservationjdbc.dto.UserInfo;
import com.javafullstack.airlinereservationjdbc.exception.AirlineException;
import com.javafullstack.airlinereservationjdbc.jdbcutility.JdbcUtility;

public class AdminDAOImpl implements AdminDAO {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties properties = new Properties();
	JdbcUtility dbConnector = new JdbcUtility();

	public boolean registerAdmin(AdminInfo admin) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3305/airlines_reservation?useSSL=false&user=root&password=rootStudent4091@lakshmi";
			conn = DriverManager.getConnection(dburl);
			PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.insertQuery);
			preparedstatement.setInt(1, admin.getId());
			preparedstatement.setString(2, admin.getName());
			preparedstatement.setString(3, admin.getEmailId());
			preparedstatement.setString(4, admin.getPassword());
			preparedstatement.setLong(5, admin.getMobileNo());
			preparedstatement.setString(6, admin.getRole());
			preparedstatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AirlineException("cann't register");
		}
		return true;
	}

	public AdminInfo authenticateAdmin(String email, String password) {
//		conn = JdbcUtility.getConnection();
//		try {
//			PreparedStatement ptadmin = conn.prepareStatement(QueryMapper.adminLogin);
//			ptadmin.setString(1, email);
//			ptadmin.setString(2, password);
//		} catch(Exception e) {
//			
//		}
		AdminInfo adminInfo = new AdminInfo();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3305/airlines_reservation?useSSL=false&user=root&password=rootStudent4091@lakshmi";
			conn = DriverManager.getConnection(dburl);
			PreparedStatement pstmt = conn.prepareStatement(QueryMapper.adminLogin);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			try {
				System.out.println("20");
				ResultSet rs = pstmt.executeQuery();
				System.out.println("resultset before");
				while (rs.next()) {
					System.out.println("resultset after");
					System.out.println(15);
					adminInfo.setEmailId(rs.getString("useremailId"));
					adminInfo.setPassword(rs.getString("userPassword"));

					return adminInfo;
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

	public boolean addFlights(FlightDetails flightDetails) {
		
		
		conn = JdbcUtility.getConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3305/airlines_reservation?useSSL=false&user=root&password=rootStudent4091@lakshmi";
			conn = DriverManager.getConnection(dburl);
			PreparedStatement pstmt = conn.prepareStatement(QueryMapper.addFlight);
			pstmt.setInt(1, flightDetails.getFlightId());
			pstmt.setString(2, flightDetails.getFlightName());
			pstmt.setString(3, flightDetails.getArrivalCity());
			pstmt.setString(4, flightDetails.getDepartureCity());
			pstmt.setInt(5, flightDetails.getNoofseatsavailable());
			pstmt.setDate(6,  flightDetails.getArrivalDate());
			pstmt.setDate(7,  flightDetails.getDepartureDate());
			pstmt.setTime(8, java.sql.Time.valueOf(flightDetails.getArrivalTime()));
			pstmt.setTime(9, java.sql.Time.valueOf(flightDetails.getDepartureTime()));
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new AirlineException("Invalid credentials");
		}

		return true;
	}

	public boolean removeFlight(int flightId) {
		conn = JdbcUtility.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(QueryMapper.deleteQuery);
			pstmt.setInt(1, flightId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AirlineException("Invalid Id");
		}
		return false;
	}

	public List<FlightDetails> searchFlightByName(String flightname) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = JdbcUtility.getConnection();
				PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.searchFlightBySource);) {
			preparedstatement.setString(1, flightname);
			try (ResultSet resultSet = preparedstatement.executeQuery();) {
				if (resultSet.next()) {
					flight = new FlightDetails();
					flight.setFlightId(resultSet.getInt("flightId"));
					flight.setFlightName(resultSet.getString("flightName"));
					flight.setArrivalCity(resultSet.getString("flightArrivalcity"));
					flight.setDepartureCity(resultSet.getString("flightDeparturecity"));
					flight.setNoofseatsavailable(resultSet.getInt("noOfseatsAvailiable"));
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


	public List<FlightDetails> searchFlightByarrivalCity(String arrivalCity) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = JdbcUtility.getConnection();
				PreparedStatement preparedstatement = conn.prepareStatement(QueryMapper.searchFlightBySource);) {
			preparedstatement.setString(1, arrivalCity);
			try (ResultSet resultSet = preparedstatement.executeQuery();) {
				if (resultSet.next()) {
					flight = new FlightDetails();
					flight.setFlightId(resultSet.getInt("flightId"));
					flight.setFlightName(resultSet.getString("flightName"));
					flight.setArrivalCity(resultSet.getString("flightArrivalcity"));
					flight.setDepartureCity(resultSet.getString("flightDeparturecity"));
					flight.setNoofseatsavailable(resultSet.getInt("noOfseatsAvailiable"));
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
				PreparedStatement pstmt = conn.prepareStatement(QueryMapper.searchFlightByDestination);) {
			pstmt.setString(1, departureCity);
			try (ResultSet resultSet = pstmt.executeQuery();) {
				if (resultSet.next()) {
					flight = new FlightDetails();
					flight.setFlightId(resultSet.getInt("flightId"));
					flight.setFlightName(resultSet.getString("flightName"));
					flight.setNoofseatsavailable(resultSet.getInt("noOfseatavailable"));
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
		throw new AirlineException("Flight Not Found in the Airline with the Given Flight Destination");
	}

	public List<FlightDetails> getFlightDetails() {
		List<FlightDetails> flightList = new LinkedList<FlightDetails>();
		try (Connection conn = JdbcUtility.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(QueryMapper.showFlights)) {
			while (resultSet.next()) {
				FlightDetails info = new FlightDetails();
				info.setFlightId(resultSet.getInt("flightId"));
				info.setFlightName(resultSet.getString("flightName"));
				info.setNoofseatsavailable(resultSet.getInt("noOfseatavailable"));
				info.setArrivalCity(resultSet.getString("arrivalcity"));
				info.setDepartureCity(resultSet.getString("departurecity"));
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

	public boolean bookingStatus(UserInfo user, FlightDetails flightDetails) {
		List<BookingInfo> bookingList = new LinkedList<BookingInfo>();
		try (Connection conn = JdbcUtility.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(QueryMapper.showBooking)) {
			while (resultSet.next()) {
				BookingInfo info = new BookingInfo();
				info.setFlightId(resultSet.getInt("flightId"));
				info.setUserId(resultSet.getInt("userId"));
				info.setTicketNo(resultSet.getInt("ticketNo"));
				bookingList.add(info);
			}
			if (bookingList.isEmpty()) {
				throw new AirlineException("No Booking Status Present in the Airline");
			} else {
				return bookingList != null;
			}
		} catch (Exception e) {
			throw new AirlineException(e.getMessage());
		}
	}

	public List<BookingInfo> userBookings() {
		List<BookingInfo> bookingInfos = new ArrayList<BookingInfo>();
		try (Connection conn = JdbcUtility.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(QueryMapper.showBooking)) {
			while (resultSet.next()) {
				UserInfo info = new UserInfo();
				info.getUserId();
				info.getUserName();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AirlineException("Booking not found");
		}
		return null;
	}

	public List<CancelInfo> cancelledFlight() {
		
		return null;
		
	}

}
