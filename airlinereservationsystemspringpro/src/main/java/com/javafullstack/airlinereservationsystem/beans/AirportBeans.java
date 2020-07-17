package com.javafullstack.airlinereservationsystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity
@Table(name = "airport")
public class AirportBeans {
	@Id
	@Column(name = "abbr", unique = true)
	//@Pattern(regexp = "{A-Z}*")
	//@Size(min = 3, max = 5)
	private String abbreviation;

	@Column
	//@Pattern(regexp = "{A-Za-z}*")
	private String airportName;

	@Column
	//@Pattern(regexp = "{A-Za-z}*")
	private String state;

	@Column
	//@Pattern(regexp = "{A-Za-z}*")
	private String city;

	@Column
	@Positive
	//@Size(min = 4, max = 6, message = "Entered zip code is not valid.")
	//@Pattern(regexp = "{0-9}*")
	private int zipCode;

}
