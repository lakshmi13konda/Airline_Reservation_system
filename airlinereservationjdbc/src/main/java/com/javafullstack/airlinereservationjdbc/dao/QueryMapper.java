package com.javafullstack.airlinereservationjdbc.dao;

public interface QueryMapper {

	String insertQuery = "insert into users_info (userId,userName,useremailId,userPassword,userMobileNum,role) values(?,?,?,?,?,?)";

	String adminLogin = "select * from users_info where useremailId = ? and userPassword = ? and role = \"admin\"";

	String userLogin = "select * from users_info where useremailId = ? and userPassword = ? and role=\"user\"";
	
	String showUsers = "select * from users_info";
	
	String getUser = "select * from users_info where userId = ?";

	String login =" select * from users_info where useremailId = ? and userPassword = ? and role=\"user\"";

	String showFlights = "select * from flight_details";

	String searchFlightByDestination = "select * from flight_details where flightDeparturecity = ?";

	String bookedflight = "select * from bookinginfo where userId =?";

	String searchFlightByName = "select * from flight_details where flightName = ?";

	String searchFlightBySource = "select * from flight_details where flightArrivalcity = ?";

	String cancelTicket = "select * from bookinginfo where ticketNo = ?";

	String deleteQuery = "delete from flight_details where flightId=?";
	
	String addFlight = "insert into flight_details (flightId,flightName,flightArrivalcity,flightDeparturecity,noOfseatsAvailiable,arrivalDate,departureDate,arrivalTime,departureTime) values(?,?,?,?,?,?,?,?,?)";

	String showBooking = "select * from flight_details";

	String bookinginfo = "insert into bookinginfo (flightId,userId,ticketNo,noofpassengers) values(?,?,?,?)";
	
	String noofseatsreduced = "select * from flight_details where flightId= ?";
	
	String  getFlightId ="select f.flightId from bookinginfo b , flightDetails f where b.ticketNo = ?";

	String updateSeats = "update flight_details set noOfseatsAvailiable = ? where flightId = ?";
	
	String deleteticket = "delete from bookinginfo where ticketNo = ?";
	
}
