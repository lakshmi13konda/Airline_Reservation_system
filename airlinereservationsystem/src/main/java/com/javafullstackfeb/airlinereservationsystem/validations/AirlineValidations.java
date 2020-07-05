package com.javafullstackfeb.airlinereservationsystem.validations;

import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;

public interface AirlineValidations {

	boolean nameValidation(String name);

	boolean emailValidation(String email);

	boolean phnoValidation(String phno);


	boolean validatePassword(String password);

	boolean validateLoginPassword(String password);
	
	boolean validateId(int id);
	
	boolean validateFlightName(String flightname);
	
	public boolean choiceValidate(String choice);
	
	public boolean choiceValidateAdminOperation(String choice);
	
	boolean validateFlightDetails(int i);
	
}
