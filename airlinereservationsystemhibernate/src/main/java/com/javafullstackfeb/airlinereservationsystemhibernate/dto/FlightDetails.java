package com.javafullstackfeb.airlinereservationsystemhibernate.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="flight_details")
public class FlightDetails implements Serializable{
    @Id
    @Column(name="flight_id")
	private int flightId;
    @Column(name="flight_name")
	private String flightName;
    @Column
	private String source;
    @Column
	private String destination;
    @Column(name = "noofseatavailable")
	private int noofseatsavailable;
    @Column(name="arrivaldate")
	private LocalDate arrivalDate;
    @Column(name="arrivaltime")
	private LocalTime arrivalTime;
    @Column(name="departuredate")
	private LocalDate departureDate;
    @Column(name="departuretime")
	private LocalTime departureTime;
}
