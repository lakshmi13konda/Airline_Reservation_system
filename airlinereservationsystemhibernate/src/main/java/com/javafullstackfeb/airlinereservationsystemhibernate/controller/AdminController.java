package com.javafullstackfeb.airlinereservationsystemhibernate.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafullstackfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.User;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.ARSException;
import com.javafullstackfeb.airlinereservationsystemhibernate.factory.AirlineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.service.AdminService;
import com.javafullstackfeb.airlinereservationsystemhibernate.service.AirlineService;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminController {
	public static void adminOperations() {


		boolean flag = false;
		String checkName = null;
		long checkMobile = 0;
		String checkEmail = null;
		String checkPassword = null;
		String role=null;
		int flightId = 0;
		String flightName = null;
		String flightSource = null;
		String flightDestination = null;
		int noofSeatsAvailable = 0;
		LocalDate arrivalDate = null;
		LocalDate departureDate = null;
		LocalTime departureTime = null;
		LocalTime arrivalTime = null;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		AdminService service = AirlineFactory.getAdminServiceImplInstance();
		 AirlineService airlineService =AirlineFactory.getAirlineServiceImplInstance();
		do {
			try {
				log.info("You have logged in successfully");
				log.info("Now you can perform the following operations:-");
				log.info("<--------------------------------------------------------------------->");
				log.info("[1]  ADD FLIGHTS");
				log.info("[2]  SEARCH FLIGHT BY SOURCE");
				log.info("[3]  SEARCH FLIGHT BY DESTINATION");
				log.info("[4]  SEARCH FLIGHT BY NAME");
				log.info("[5]  REMOVE FLIGHT");
				log.info("[6]  VIEW ALL FLIGHTDETAILS");
				log.info("[7] ISSUED BOOKING STATUS");
				log.info("[8] ADD NEW ADMIN or USER");
				log.info("[9] LOGOUT");
				log.info("<--------------------------------------------------------------------->");
				int choice1 = scanner.nextInt();
				switch (choice1) {
				case 1:

					do {

						try {
							log.info("Enter FlightID to add : ");
							flightId = scanner.nextInt();
							service.validateFlightID(flightId);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("Id should contains only digits");
							scanner.next();
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {

						try {
							log.info("Enter FlightName : ");
							flightName = scanner.next();
							service.validateFlightName(flightName);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("FlightName should contains only Alphabets");
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						try {
							log.info("Enter Source : ");
							flightSource = scanner.next();
							service.validateSource(flightSource);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("Source should contains only Alphabates");
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {

						try {
							log.info("Enter Destination : ");
							flightDestination = scanner.next();
							service.validateDestination(flightDestination);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Destination should contains only Alphabates");
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {

						try {
							System.out.println("Enter No.of seat Available in the Flight : ");
							noofSeatsAvailable = scanner.nextInt();
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("noofSeatsAvailable should contains only digits");
							scanner.next();
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						log.info("Enter  Flight Arrival Date (YYYY,MM,DD) : ");

						try {
							arrivalDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("its should be in the form of yyyy,mm,dd only in digits");
							scanner.next();
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						log.info("Enter  Flight Arrival Time(HOURS,MIN) : ");

						try {
							arrivalTime = LocalTime.of(scanner.nextInt(), scanner.nextInt());

							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("its should contains only digits");
							scanner.next();
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						log.info("Enter  Flight departure Date (YYYY,MM,DD) : ");

						try {
							departureDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("its should contains only digits ");
							scanner.next();
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						log.info("Enter  Flight departure Time(HOURS,MIN) : ");

						try {
							departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt());
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("its should contains only digits ");
							scanner.next();
						} catch (ARSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					FlightDetails bean1 = new FlightDetails();
					bean1.setFlightId(flightId);
					bean1.setFlightName(flightName);
					bean1.setSource(flightSource);
					bean1.setDestination(flightDestination);
					bean1.setNoofseatsavailable(noofSeatsAvailable);
					bean1.setArrivalDate(arrivalDate);
					bean1.setArrivalTime(arrivalTime);
					bean1.setDepartureDate(departureDate);
					bean1.setDepartureTime(departureTime);

					boolean check2 = service.addFlights(bean1);
					if (check2) {
						log.info("Flight added of id = " + flightId);
					} else {
						log.info("Flight already exist of id = " + flightId);
					}
					break;
				case 2:
					log.info("Search Flight Details by Source : ");
					String source = scanner.next();

					FlightDetails bean3 = new FlightDetails();
					bean3.setSource(source);
					List<FlightDetails> flightSource1 = service.searchFlightBySource(source);
					log.info("<--------------------------------------------------------------------->");
					log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
							"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "DepartureDate",
							"Departure Time", "NoofSeatAvailable"));
					for (FlightDetails flightBean : flightSource1) {
						if (flightBean != null) {
							log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
									flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
									flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
									java.sql.Time.valueOf(flightBean.getArrivalTime()),
									java.sql.Date.valueOf(flightBean.getDepartureDate()),
									java.sql.Time.valueOf(flightBean.getDepartureTime()),
									flightBean.getNoofseatsavailable()));
						} else {
							log.info("No Flights are available with this Source");
						}
					}
					break;
				case 3:
					log.info("Search flight by Destination : ");
					String destination = scanner.next();

					FlightDetails bean4 = new FlightDetails();
					bean4.setDestination(destination);
					List<FlightDetails> flightDestination1 = service.searchFlightByDestination(destination);
					log.info("<<--------------------------------------------------------------------->>");
					log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
							"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "DepartureDate",
							"Departure Time", "NoofSeatAvailable"));
					for (FlightDetails flightBean : flightDestination1) {
						if (flightBean != null) {
							log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
									flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
									flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
									java.sql.Time.valueOf(flightBean.getArrivalTime()),
									java.sql.Date.valueOf(flightBean.getDepartureDate()),
									java.sql.Time.valueOf(flightBean.getDepartureTime()),
									flightBean.getNoofseatsavailable()));
						} else {
							log.info("No Flights are available with this Destination");
						}
					}
					break;
				case 4:
					log.info(" SEARCH FLIGHT BY NAME : ");
					String name = scanner.next();

					FlightDetails bean5 = new FlightDetails();
					bean5.setFlightName(name);

					List<FlightDetails> fname = service.searchFlightByName(name);
					log.info("<--------------------------------------------------------------------->");
					log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
							"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "DepartureDate",
							"Departure Time", "NoofSeatAvailable"));
					for (FlightDetails flightBean : fname) {
						if (flightBean != null) {
							log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
									flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
									flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
									java.sql.Time.valueOf(flightBean.getArrivalTime()),
									java.sql.Date.valueOf(flightBean.getDepartureDate()),
									java.sql.Time.valueOf(flightBean.getDepartureTime()),
									flightBean.getNoofseatsavailable()));
						} else {
							log.info("No Flights are available with this Flight Name");
						}
					}
					break;
				case 5:
					log.info("REMOVE FLIGHT ");
					log.info("ENTER FLIGHT ID");
					try {
						int flightId3 = scanner.nextInt();
						service.validateFlightID(flightId3);
						if (flightId3 == 0) {
							log.info("Please Enter the Valid FlightId");
						} else {
							FlightDetails bean6 = new FlightDetails();
							bean6.setFlightId(flightId3);
							boolean remove = service.removeFlight(flightId3);
							if (remove) {
								log.info("The Flight is removed of Id = " + flightId3);
							} else {
								log.info("The Flight is not removed of Id = " + flightId3);
							}
						}
					} catch (InputMismatchException e) {
						log.error("Invalid entry valid Id");
						scanner.nextLine();
					} catch (ARSException e) {
						log.info(e.getMessage());
					}
					break;
				case 6:
					List<FlightDetails> info = service.getFlightDetails();
					log.info("<--------------------------------------------------------------------->");
					log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
							"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "Departure Date",
							"Departure Time", "NoofSeatAvailable"));
					for (FlightDetails flightBean : info) {
						if (flightBean != null) {
							log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
									flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
									flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
									java.sql.Time.valueOf(flightBean.getArrivalTime()),
									java.sql.Date.valueOf(flightBean.getDepartureDate()),
									java.sql.Time.valueOf(flightBean.getDepartureTime()),
									flightBean.getNoofseatsavailable()));
						} else {
							log.info("No Flight are available in the Flight Details");
						}
					}
					break;
				case 7:
					List<BookingStatus> booking = service.getBookingStatus();

					log.info("<--------------------------------------------------------------------->");
					log.info(String.format("%-10s %-10s %-10s %s", "TicketID","FlightId",
							 "UserID", "NoofSeatBooked"));
					for (BookingStatus request : booking) {
						if (request != null) {
							log.info(String.format("%-10s %-10s %-10s %s",
									request.getTicketId(),
									request.getFlightId(),
									request.getId(),
									request.getNoofseatsbooked()));
						} else {
							log.info("Request not found in booking status");
						}
					}
					break;
				case 8:
					   try {
						
							log.info("Enter Name to Register : ");
							checkName = scanner.next();
							log.info("Enter MobileNumber to Register : ");
							checkMobile = scanner.nextLong();
							log.info("Enter Email to Register : ");
							checkEmail = scanner.next();
							log.info("Enter Password :");
							checkPassword = scanner.next();
							log.info("Enter Role as admin or user :");
							role = scanner.next();
							int userId = (int) (Math.random() * 10000);
							if (userId <= 1000) {
								userId = userId + 1000;
							}
							User bean = new User();
							bean.setId(userId);
							bean.setName(checkName);
							bean.setMobileNumber(checkMobile);
							bean.setEmailId(checkEmail);
							bean.setPassword(checkPassword);
							bean.setRole(role);

							boolean check = airlineService.register(bean);
							if (check) {
								log.info("You have registered Successfully");
							} else {
								log.info("Already registered");
							}
							break;
		                  }catch (InputMismatchException e) {
		      				log.error("Invalid entry ");
		    				scanner.next();
		    				break;
		    			}
		                  catch (ARSException e) {
							log.info(e.getMessage());
							break;
						}
				case 9:
					SubAirlineController.airlineOperations();

				default:
					log.info("Invalid entry please choose from above options");
					break;
				}

			} catch (InputMismatchException e) {
				log.error("Invalid entry please choose from above options");
				scanner.nextLine();
			} catch (ARSException e) {
				log.info(e.getMessage());
			} catch (Exception e) {
				log.info("Invalid Credentials");
			}
		} while (true);


	}
}
