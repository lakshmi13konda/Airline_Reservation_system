package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.User;


public interface AirlineDAO {
	public boolean register(User admin);
	public User authenticate(String email, String password);
	public List<FlightDetails> getFlightDetails();
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination);
}
