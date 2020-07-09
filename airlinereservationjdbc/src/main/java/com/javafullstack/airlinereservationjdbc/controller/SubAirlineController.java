package com.javafullstack.airlinereservationjdbc.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

import com.javafullstack.airlinereservationjdbc.dto.AdminInfo;
import com.javafullstack.airlinereservationjdbc.dto.BookingInfo;
import com.javafullstack.airlinereservationjdbc.dto.CancelInfo;
import com.javafullstack.airlinereservationjdbc.dto.FlightDetails;
import com.javafullstack.airlinereservationjdbc.dto.UserInfo;
import com.javafullstack.airlinereservationjdbc.exception.AirlineException;
import com.javafullstack.airlinereservationjdbc.services.AdminService;
import com.javafullstack.airlinereservationjdbc.services.AdminServiceImpl;
import com.javafullstack.airlinereservationjdbc.services.UserServices;
import com.javafullstack.airlinereservationjdbc.services.UserServicesImpl;

import lombok.extern.log4j.Log4j;

@Log4j
public class SubAirlineController {

	public static void airlineReservationOperations() {
		int checkId = 0;
		String checkName = null;
		long checkMobile = 0;
		long checkMobileno = 0;
		String checkEmail = null;
		String checkPassword = null;
		String role= null;
		int choice1 = 0;
		int choice2 = 0;
		int ticketNo = 0;
		int flightId = 0;
		String flightName = null;
		String flightarrivalCity = null;
		String flightdepartureCity = null;
		int noofSeatsAvailable = 0;
		Date arrivalDate = null;
		Date departureDate = null;
		UserInfo UserBean = null;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				log.info(" WELCOME TO AIRLINE RESERVATION SYSTEM ");
				log.info("1. ADMIN PAGE");
				log.info("2. USER PAGE");
				int i = scanner.nextInt();
				switch (i) {
				case 1:
					AdminService service = new AdminServiceImpl();
					do {
						try {
							log.info("1. ADMINISTRATION REGISTER");
							log.info("2. ADMINISTRATION LOGIN");
							log.info("3. EXIT");
							int choice = scanner.nextInt();
							switch (choice) {

							case 1:
								try {

									checkId = (int) (Math.random() * 1000);
									if (checkId <= 100) {
										checkId = checkId + 100;
									}
									log.info("Generated Id =" + checkId);

									log.info("Enter AdminName : ");
									checkName = scanner.next();

									log.info("Enter Admin mobile number : ");
									checkMobile = scanner.nextLong();

									log.info("Enter Admin Email : ");
									checkEmail = scanner.next();

									log.info("Enter Password :");
									checkPassword = scanner.next();

									log.info("Enter users role");
									role = scanner.next();
									
									AdminInfo bean = new AdminInfo();
									bean.setId(checkId);
									bean.setName(checkName);
									bean.setMobileNo(checkMobile);
									bean.setEmailId(checkEmail);
									bean.setPassword(checkPassword);
									bean.setRole(role);

									boolean check = service.registerAdmin(bean);
									if (check) {
										log.info("You have registered Successfully");
									} else {
										log.info("Already registered");
									}
								} catch (AirlineException e) {
									e.printStackTrace();
									log.info(e.getMessage());
								}
								break;

							case 2:
								log.info("Enter registered email to login : ");
								String email = scanner.next();
								log.info("Enter registered Password to login : ");
								String password = scanner.next();
								try {
									AdminInfo authBean = service.authenticateAdmin(email, password);
									if (authBean != null) {
										log.info("You have logged in successfully");
										log.info("Now you can perform the following operations:-");
										do {
											try {
												log.info("1.  ADD FLIGHTS");
												log.info("2.  SEARCH FLIGHT BY arrivalCity");
												log.info("3.  SEARCH FLIGHT BY departureCity");
												log.info("4.  SEARCH FLIGHT BY NAME");
												log.info("5.  REMOVE FLIGHT");
												log.info("6   VIEW ALL FLIGHTDETAILS");
												log.info("7.  USERBOOKINGS");
												log.info("8.  VIEW ALL CANCELLED FLIGHT TICKET");
												log.info("9.  LOGOUT");
												choice1 = scanner.nextInt();
												switch (choice1) {
												case 1:
													log.info("Enter FlightID to add : ");
													flightId = scanner.nextInt();

													log.info("Enter FlightName : ");
													flightName = scanner.next();

													log.info("Enter arrivalCity : ");
													flightarrivalCity = scanner.next();

													log.info("Enter departureCity : ");
													flightdepartureCity = scanner.next();

													log.info("Enter No.of seat Available in the Flight : ");
													noofSeatsAvailable = scanner.nextInt();

													log.info("Enter Arrival Date");
													//arrivalDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(),scanner.nextInt());
													
													log.info("Please Enter the Date in dd-MMM-yyyy format ");
													String date = scanner.next();

													SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
													java.util.Date date2=null;
													try {
													    //Parsing the String
													    date2 = dateFormat.parse(date);
													    arrivalDate = new Date(date2.getTime());
													    //arrivaltime.gettime();
													} catch (ParseException e) {
													    e.printStackTrace();
													}
													
													log.info("Enter departure Date");
													
													log.info("Please Enter the Date in dd-MMM-yyyy format ");
													String date1 = scanner.next();

													SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
													java.util.Date date3=null;
													try {
													    //Parsing the String
													    date3 = dateFormat1.parse(date1);
													    departureDate = new Date(date3.getTime());
													    //arrivaltime.gettime();
													} catch (ParseException e) {
													    // TODO Auto-generated catch block
													    e.printStackTrace();
													}
													
													log.info("Please Enter the Date in hrs:mins:secs format ");
//													String time = scanner.next();
//													TimeZone timeZone = TimeZone.getDefault();
//													SimpleDateFormat timeFormat = new SimpleDateFormat();
//													java.util.TimeZone time1 = null;
//													try {
//														log.info("10");
//														time1 = timeZone.getDefault();
//														log.info("20");
//														arrivalTime.getTime();
//														
//													} catch(Exception e) {
//														e.printStackTrace();
//													}
													
													SimpleDateFormat myDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
													myDate.setTimeZone(TimeZone.getTimeZone("UTC"));
													log.info(myDate);
													
													log.info("Enter Arrival Time");
													String time=scanner.next();  //default format: hh:mm:ss
													LocalTime arrivalTime=LocalTime.parse(time);
													log.info(arrivalTime);
//													arrivalTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(),scanner.nextInt());
//													log.info("Please Enter the Date in dd-MMM-yyyy format ");
//													String date5 = scanner.next();
//
//													SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");
//													java.util.Date date4=null;
//													try {
//													    //Parsing the String
//													    date4 = dateFormat2.parse(date5);
//													    arrivalDate = new Date(date4.getTime());
//													    //arrivaltime.gettime();
//													} catch (ParseException e) {
//													    // TODO Auto-generated catch block
//													    e.printStackTrace();
//													}
													
//													
													log.info("Enter Departure Time");
													String time1=scanner.next();  //default format: hh:mm:ss
													LocalTime departureTime=LocalTime.parse(time1);
													log.info(departureTime);
//													departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(),scanner.nextInt());
													
													FlightDetails bean1 = new FlightDetails();
													bean1.setFlightId(flightId);
													bean1.setFlightName(flightName);
													bean1.setArrivalCity(flightarrivalCity);
													bean1.setDepartureCity(flightdepartureCity);
													bean1.setNoofseatsavailable(noofSeatsAvailable);
													bean1.setArrivalDate(arrivalDate);
													bean1.setDepartureDate(departureDate);
													bean1.setArrivalTime(arrivalTime);
													bean1.setDepartureTime(departureTime);
													try {

														boolean check2 = service.addFlights(bean1);
														if (check2) {
															log.info("Flight added of id = " + bean1.toString());
														} else {
															log.info("Flight already exist of id = " + flightId);
														}
													} catch (Exception e) {
														e.printStackTrace();
														log.info(e.getMessage());
													}
													break;
												case 2:
													log.info("Search Flight Details by arrivalCity : ");
													String arrivalCity = scanner.next();

													FlightDetails bean3 = new FlightDetails();

													bean3.setArrivalCity(arrivalCity);
													try {
														List<FlightDetails> flightarrivalCity1 = service
																.searchFlightByarrivalCity(arrivalCity);

														if (flightarrivalCity1 != null) {
															log.info(flightarrivalCity1.toString());
														} else {
															log.info("No Flights are available with this arrivalCity");
														}

													} catch (Exception e) {
														log.info(e.getMessage());
														e.printStackTrace();
													}
													break;
												case 3:
													log.info("Search flight by departureCity : ");
													String departureCity = scanner.next();

													FlightDetails bean4 = new FlightDetails();
													bean4.setDepartureCity(departureCity);
													try {

														List<FlightDetails> flightdepartureCity1 = service
																.searchFlightBydepartureCity(departureCity);
														for (FlightDetails flightBean : flightdepartureCity1) {
															if (flightBean != null) {
																log.info(flightBean.toString());
															} else {
																log.info(
																		"No Flights are available with this departureCity");
															}
														}
													} catch (Exception e) {
														log.info(e.getMessage());
													}
													break;
												case 4:
													log.info(" SEARCH FLIGHT BY NAME : ");
													String name = scanner.next();

													FlightDetails bean5 = new FlightDetails();
													bean5.setFlightName(name);
													try {
														List<FlightDetails> fname = service.searchFlightByName(name);
														for (@SuppressWarnings("unused")
														FlightDetails flightBean : fname) {
															if (fname != null) {
																log.info(fname.toString());
															} else {
																log.error(
																		"No Flights are available with this Flight Name");
															}
														}
													} catch (Exception e) {
														log.info(e.getMessage());
													}
													break;
												case 5:
													log.info("REMOVE FLIGHT ");
													int flightId3 = scanner.nextInt();
													if (flightId3 == 0) {
														log.info("Please Enter the Valid FlightId");
													} else {
														FlightDetails bean6 = new FlightDetails();
														bean6.setFlightId(flightId3);
														try {
															boolean remove = service.removeFlight(flightId3);
															if (remove) {
																log.info("The Flight is removed of Id = "
																		+ bean6.toString());
															} else {
																log.info("The Flight is not removed of Id = "
																		+ flightId3);
															}

														} catch (Exception e) {
															e.printStackTrace();
															
															log.info(e.getMessage());
														}
													}
													break;
												case 6:
													try {
														List<FlightDetails> info = service.getFlightDetails();
														for (FlightDetails flightBean : info) {
															if (flightBean != null) {
																log.info(flightBean.toString());
															} else {
																log.info("No Flight are available in the Flight Details");
															}
														}
													} catch (Exception e) {
														e.printStackTrace();
														log.info(e.getMessage());
													}
													break;
												case 7:
													try {
														List<BookingInfo> info = service.userBooking();
														if (!info.isEmpty()) {
															for (BookingInfo bookingInfo2 : info) {

																log.info(bookingInfo2.toString());
															}
														} else {
															log.info("No Flight booked");
														}

													} catch (Exception e) {
														e.printStackTrace();
														log.info(e.getMessage());
													}
													break;

												case 8:
													try {
														List<CancelInfo> cancel = service.cancelledFlight();
														if (!cancel.isEmpty()) {
															for (CancelInfo cancelInfo2 : cancel) {

																log.info(cancelInfo2.toString());
															}
														} else {
															log.info("No Flight booked");
														}

													} catch (Exception e) {
														e.printStackTrace();
														log.info(e.getMessage());
													}
													break;

												case 9:
													airlineReservationOperations();
													break;

												default:
													log.info("Invalid Choice");
													break;
												}
											} catch (InputMismatchException e) {
												log.error("Invalid entry please provide only numbers");
												scanner.next();
											}
										} while (choice1 != 9);
									}
								} catch (Exception e) {
									e.printStackTrace();
									log.error(e.getMessage());
								}
								break;
							case 3:
								airlineReservationOperations();
								break;

							default:
								log.info("Please select 1 , 2 or 3");
								break;
							}
						} catch (InputMismatchException e) {
							log.error("Invalid entry please provide only Integers");
							scanner.next();
						}
					} while (true);
				case 2:
					UserServices service1 = new UserServicesImpl();
					do {
						try {
							log.info("1. View All Flight Details");
							log.info("2. USER REGISTER");
							log.info("3. USER LOGIN");
							log.info("4. EXIT");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:
								try {
									List<FlightDetails> info = service1.getFlightDetails();
									for (FlightDetails flightBean : info) {
										if (flightBean != null) {
											log.info(flightBean.toString());
										} else {
											log.info("No Flight are available in the Flight Details");
										}
									}
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 2:

								checkId = (int) (Math.random() * 1000);
								if (checkId <= 100) {
									checkId = checkId + 100;
								}
								log.info("Generated Id =" + checkId);

								log.info("Enter User Name : ");
								checkName = scanner.next();

								log.info("Enter MobileNumber to Register : ");
								checkMobile = scanner.nextLong();

								log.info("Enter User Email : ");
								checkEmail = scanner.next();

								log.info("Enter User Password :");
								checkPassword = scanner.next();

								log.info("Enter users role");
								role = scanner.next();
								
								UserInfo bean1 = new UserInfo();
								bean1.setUserId(checkId);
								bean1.setUserName(checkName);
								bean1.setEmailId(checkEmail);
								bean1.setPassword(checkPassword);
								bean1.setMobileNumber(checkMobileno);
								bean1.setRole(role);
								
								boolean check = service1.registerUser(bean1);
								if (check) {
									log.info("Registered Successfully");
								} else {
									log.info("Already registered");
								}
								break;

							case 3:
								log.info("Enter registered email : ");
								String email = scanner.next();
								log.info("Enter registered Password : ");
								String password = scanner.next();
								try {
									 UserBean = service1.authenticateUser(email, password);
									log.info("Logged in Successfully");
									log.info(UserBean.getUserId());
									do {
										try {
											log.info("1.  SEARCH FLIGHT BY arrivalCity");
											log.info("2.  SEARCH FLIGHT BY departureCity");
											log.info("3.  SEARCH FLIGHT BY NAME");
											log.info("4.  VIEW ALL FLIGHTDETAILS");
											log.info("5.  Book a Flight");
											log.info("6.  My booking information");
											log.info("7.  Cancel My Ticket");
											log.info("9.  LOGOUT");
											choice2 = scanner.nextInt();
											switch (choice2) {
											case 1:
												log.info("Search Flight Details by arrivalCity : ");
												String arrivalCity = scanner.next();

												try {
													List<FlightDetails> flightarrivalCity1 = service1
															.searchFlightByarrivalCity(arrivalCity);
													for (FlightDetails flightBean : flightarrivalCity1) {
														if (flightBean != null) {
															log.info(flightBean.toString());
														} else {
															log.info("No Flights are available with this arrivalCity");
														}
													}
												} catch (Exception e) {
													log.info(e.getMessage());
												}
												break;

											case 2:

												log.info("Search flight by departureCity : ");
												String departureCity = scanner.next();
												FlightDetails bean4 = new FlightDetails();
												bean4.setDepartureCity(departureCity);
												try {
													List<FlightDetails> flightdepartureCity1 = service1
															.searchFlightByarrivalCity(departureCity);
													for (FlightDetails flightBean : flightdepartureCity1) {
														if (flightBean != null) {
															log.info(flightBean.toString());
														} else {
															log.info(
																	"No Flights are available with this departureCity");
														}
													}
												} catch (Exception e) {
													log.info(e.getMessage());
												}
												break;
											case 3:
												log.info(" SEARCH FLIGHT BY NAME : ");
												String name = scanner.next();

												FlightDetails bean5 = new FlightDetails();
												bean5.setFlightName(name);
												try {
													List<FlightDetails> fname = service1.searchFlightByName(name);
													for (FlightDetails flightBean : fname) {
														if (fname != null) {
															log.info(fname.toString());
														} else {
															log.info("No Flights are available with this Flight Name");
														}
													}
												} catch (Exception e) {
													log.info(e.getMessage());
												}
												break;
											case 4:
												try {
													List<FlightDetails> info = service1.getFlightDetails();
													for (FlightDetails flightBean : info) {
														if (flightBean != null) {
															log.info(flightBean.toString());
														} else {
															log.info("No Flight are available in the Flight Details");
														}
													}
												} catch (Exception e) {
													log.info(e.getMessage());
												}
												break;
											case 5:
												FlightDetails flightDetails = new FlightDetails();
												BookingInfo bookingInfo = new BookingInfo();
												ticketNo = (int) (Math.random() * 1000);
												if (ticketNo <= 100) {
													ticketNo = ticketNo + 100;
												}

//												log.info("Enter ArrivalCity");
//												arrivalCity = scanner.next();
//												log.info("Enter DepartureCity");
//												departureCity = scanner.next();

//												flightDetails.setArrivalCity(arrivalCity);
//												flightDetails.setDepartureCity(departureCity);

												log.info("Enter flightId");
												flightId = scanner.nextInt();
												log.info("Enter no of passengers");
												int noofpass = scanner.nextInt();
												bookingInfo.setNoofpassengers(noofpass);
												bookingInfo.setFlightId(flightId);
												bookingInfo.setTicketNo(ticketNo);
												log.info("userbean");
												bookingInfo.setUserId(UserBean.getUserId());
												log.info(UserBean.getUserId());
												try {
													BookingInfo bookingInfo2 = service1.bookFlight(bookingInfo);
													if (bookingInfo2 != null) {
														log.info("Flight Booked successfully ");
													}
												} catch (Exception e) {
													e.printStackTrace();
													log.info(e.getMessage());
												}
												break;
											case 6:
												
												try {
													List<BookingInfo> bookingInformation = service1.myBooking(UserBean);
													for (BookingInfo bookingInfo2 : bookingInformation) {
														log.info("My booking information "+bookingInfo2.toString());
													}	
												} catch (Exception e) {
													e.printStackTrace();
													log.info(e.getMessage());
												}
												break;

											case 7:
												log.info("Enter the TicketNo");
												ticketNo = scanner.nextInt();
												BookingInfo bookingInfo2 = new BookingInfo();
												bookingInfo2.setTicketNo(ticketNo);
												bookingInfo2.setUserId(UserBean.getUserId());
												try {
													CancelInfo cancelInfos = service1.cancelFlight(bookingInfo2);
													if (cancelInfos != null) {
														log.info("Ticket cancelled successfully");
													}

												} catch (Exception e) {
													log.info(e.getMessage());
												}
												break;

											case 9:
												break;

											default:
												log.info("Please choose digits between [0-9]");

											}
										} catch (InputMismatchException e) {
											log.error("Invalid entry please provide only positive integer");
											scanner.next();
										}
									} while (choice2 != 9);
								} catch (Exception e) {
									e.printStackTrace();
									log.error(e.getMessage());
								}
								break;
							case 4:
								airlineReservationOperations();
								break;

							default:
								log.info("Invalid Choice");
								log.error("Choice must be 1,2 or 3");
								break;
							}
						} catch (InputMismatchException e) {
							log.error("Invalid entry please provide only numbers");
							scanner.next();
						}
					} while (true);
				default:
					log.info("Please enter either 1 or 2");
				}
			} catch (InputMismatchException e) {
				log.error("Invalid entry please provide only numbers");
				scanner.next();
			}
		} while (true);
	}
}