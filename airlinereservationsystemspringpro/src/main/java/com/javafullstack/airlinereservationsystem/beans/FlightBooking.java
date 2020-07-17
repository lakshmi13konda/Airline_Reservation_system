package com.javafullstack.airlinereservationsystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity
@Table(name = "flightBooking")
public class FlightBooking {

	@Id
	@Column
	private String bookingId;

	@Column
	//@Size(min = 6, message = "Entered userId must contain minimum of 6 characters.")
	//@Pattern(regexp = "{A-Za-z0-9}*")
	private String userId;

	@Column
	@NotEmpty(message = "This field is required")
	//@Pattern(regexp = "{A-Za-z}*")
	private String firstName;

	@Column
	@NotEmpty(message = "This field is required")
	//@Pattern(regexp = "{A-Za-z}*")
	private String lastName;

	@Column(name = "flightno")
	@NotEmpty(message = "This field is required")
	//@Pattern(regexp = "{A-Z0-9}*")
	private String flightNo;

	@Column(name = "arrival_city")
	@NotEmpty(message = "This field is required")
	//@Pattern(regexp = "{A-Za-z}*")
	private String arrivalCity;

	@Column(name = "departure_city")
	@NotEmpty(message = "This field is required")
	//@Pattern(regexp = "{A-Za-z}*")
	private String departureCity;

	@Column(name = "dep_date")
	@NotEmpty(message = "This field is required")
	
	private String departureDate;

	@Column(name = "arr_date")
	@NotEmpty(message = "This field is required")
	private String arrivalDate;

	@Column(name = "dep_time")
	@NotEmpty(message = "This field is required")
	private String departureTime;

	@Column(name = "arr_time")
	@NotEmpty(message = "This field is required")
	private String arrivalTime;

	@Column(name = "class_type")
	@NotEmpty(message = "This field is required")
	//@Pattern(regexp = "{A-Za-z}*")
	private String classType;

	@Column
	@Positive
	private int passengers;

	@Column
	@Positive
	private double totalFare;

}
