package com.javafullstackfeb.airlinereservationsystemhibernate.service;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AirlineDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystemhibernate.dto.User;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.ARSException;
import com.javafullstackfeb.airlinereservationsystemhibernate.factory.AirlineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.validation.Validation;


public class AirlineServiceJPAImpl implements AirlineService{

	Validation validation = new Validation();
	AirlineDAO dao = AirlineFactory.getAirlineDAOImplInstance();
	@Override
	public boolean register(User admin) {
		if(validation.validatedId(admin.getId())) {
			if(validation.validatedName(admin.getName())) {
				if(validation.validatedMobile(admin.getMobileNumber())) {
					if(validation.validatedEmail(admin.getEmailId())) {
						if(validation.validatedPassword(admin.getPassword())) {
							if(validation.validatedRole(admin.getRole())) {
							return dao.register(admin);
							}
						}
					}
					
				}
			}
		}
		throw new ARSException("invalid inputs");
	}

	@Override
	public User authenticate(String email, String password) {
		if (validation.validatedEmail(email)) {
			if (validation.validatedPassword(password)) {
				return dao.authenticate(email, password);
			} 
		} 
		return null;
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		return dao.getFlightDetails();
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		if (validation.validatedSource(source)) {
			if (validation.validatedDestination(destination)) {
				return dao.searchFlightBySourceAndDestination(source, destination);
			}
		}
		throw new ARSException("No Flight Details with Source and Destination");
	}


}
