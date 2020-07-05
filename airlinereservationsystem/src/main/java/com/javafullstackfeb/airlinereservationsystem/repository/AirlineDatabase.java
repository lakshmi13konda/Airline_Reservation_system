package com.javafullstackfeb.airlinereservationsystem.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dto.AdminInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.CancelInfo;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserInfo;

public class AirlineDatabase {

	public static List<AdminInfo> adminInfo = new ArrayList<AdminInfo>();
	public static List<UserInfo> userinfo = new ArrayList<UserInfo>();
	public static List<FlightDetails> flightdetails = new ArrayList<FlightDetails>();
	public static List<BookingInfo> bookingdetails = new ArrayList<BookingInfo>();
	public static List<CancelInfo> cancelInfos=new ArrayList<CancelInfo>();
	public static void addToDataBase() {

		AdminInfo admin = new AdminInfo();
		admin.setId(301);
		admin.setEmailId("sridhar@gmail.com");
		admin.setMobileNo(9671283892l);
		admin.setName("Admin");
		admin.setPassword("Sri@4091");
		adminInfo.add(admin);

		UserInfo user = new UserInfo();
		user.setEmailId("rama@gmail.com");
		user.setMobileNumber(7981373816l);
		user.setPassword("Rama@1sri");
		user.setUserId(201);
		user.setUserName("Lakshmi");
		userinfo.add(user);

		UserInfo userin = new UserInfo();
		userin.setEmailId("siddusri654@gmail.com");
		userin.setMobileNumber(7981373816l);
		userin.setPassword("Sridhar@625");
		userin.setUserId(202);
		userin.setUserName("Sridhar");
		userinfo.add(userin);

		FlightDetails flightInfo = new FlightDetails();
		flightInfo.setArrivalCity("Delhi");
		flightInfo.setDepartureCity("Hyderabad");
		flightInfo.setFlightId(101);
		flightInfo.setFlightName("Indigo");
		flightInfo.setNoofseatsavailable(25);
		flightInfo.setArrivalDateTime(LocalDateTime.of(2020, 01, 29, 4, 30));
		flightInfo.setDepartureDateTime(LocalDateTime.of(2020, 01, 29, 7, 45));
		flightdetails.add(flightInfo);
		

		FlightDetails flightInfodet = new FlightDetails();
		flightInfodet.setArrivalCity("Mysore");
		flightInfodet.setDepartureCity("Hyderabad");
		flightInfodet.setFlightId(102);
		flightInfodet.setFlightName("SpiceJet");
		flightInfodet.setNoofseatsavailable(25);
		flightInfodet.setArrivalDateTime(LocalDateTime.of(2020, 02, 01, 12, 45));
		flightInfodet.setDepartureDateTime(LocalDateTime.of(2020, 05, 15, 4, 45));
		flightdetails.add(flightInfodet);
		

		FlightDetails flightInfodeta = new FlightDetails();
		flightInfodeta.setArrivalCity("Bangalore");
		flightInfodeta.setDepartureCity("Hyderabad");
		flightInfodeta.setFlightId(103);
		flightInfodeta.setFlightName("SpiceJet");
		flightInfodeta.setNoofseatsavailable(25);
		flightInfodeta.setArrivalDateTime(LocalDateTime.of(2020, 02, 01, 12, 45));
		flightInfodeta.setDepartureDateTime(LocalDateTime.of(2020, 05, 15, 4, 45));
		flightdetails.add(flightInfodeta);


		FlightDetails flightInf = new FlightDetails();
		flightInf.setArrivalCity("pune");
		flightInf.setDepartureCity("chennai");
		flightInf.setFlightId(104);
		flightInf.setFlightName("Indigo");
		flightInf.setNoofseatsavailable(25);
		flightInf.setArrivalDateTime(LocalDateTime.of(2020, 01, 29, 4, 30));
		flightInf.setDepartureDateTime(LocalDateTime.of(2020, 01, 29, 7, 45));
		flightdetails.add(flightInf);
		
		FlightDetails flight = new FlightDetails();
		flight.setArrivalCity("Vizag");
		flight.setDepartureCity("Bangalore");
		flight.setFlightId(105);
		flight.setFlightName("Indigo");
		flight.setNoofseatsavailable(25);
		flight.setArrivalDateTime(LocalDateTime.of(2020, 01, 29, 4, 30));
		flight.setDepartureDateTime(LocalDateTime.of(2020, 01, 29, 7, 45));
		flightdetails.add(flight);
		
		BookingInfo booking = new BookingInfo();
		booking.setFlightDetail(flightInfo);
		booking.setTicketNo(501);
		booking.setNoofpassengers(4);
		booking.setUser(userin);
		bookingdetails.add(booking);
		
		CancelInfo cancelInfo = new CancelInfo();
		cancelInfo.setFlightDetails(flight);
		cancelInfo.setTicketno(501);
		cancelInfo.setUserInfo(userin);
		cancelInfos.add(cancelInfo);
		
		CancelInfo cancelInfo2 = new CancelInfo();
		cancelInfo2.setFlightDetails(flightInf);
		cancelInfo2.setTicketno(502);
		cancelInfo2.setUserInfo(user);
		cancelInfos.add(cancelInfo2);
	}

}
