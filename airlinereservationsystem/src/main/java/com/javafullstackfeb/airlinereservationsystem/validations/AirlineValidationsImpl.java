package com.javafullstackfeb.airlinereservationsystem.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;

public class AirlineValidationsImpl implements AirlineValidations {

	Pattern pattern = null;
	Matcher matcher = null;

	@Override
	public boolean nameValidation(String name) {
		String nameRegEx = "^(?=.{4,20}$)(?![.-])(?!.*[.]{2})[a-zA-Z.-]+(?<![_.-])";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AirlineException(" Name should have atleast 4 characters and numbers are not allowed");
		}
		return result;
		
	}

	public boolean choiceValidateAdminOperation(String choice) {
		pattern = Pattern.compile("[1-7]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}
	
	@Override
	public boolean emailValidation(String email) {
		// TODO Auto-generated method stub
		String emailRegEx = "[\\w&&[^_]]{3,50}[@]{1}\\D{2,50}[.]{1}\\D{2,50}";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
			
		} else {
			
			throw new AirlineException("Please provide proper Email ID ");
		}
		return result;
	}

	@Override
	public boolean phnoValidation(String phno) {
		// TODO Auto-generated method stub
		pattern = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		matcher = pattern.matcher(phno);
		return matcher.matches();
	}


	@Override
	public boolean validatePassword(String password) {
		// TODO Auto-generated method stub
		String passwordRegEx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}$";
		boolean result = false;
		Pattern pattern = Pattern.compile(passwordRegEx);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AirlineException("Password should contain atleast 8 characters ,atleast one uppercase,atleast one lowercase,atleast one number,atleast one special symbol(@#$%) ");
		  
		}
		return result;
	}
	
	@Override
	public boolean validateLoginPassword(String password) {
		// TODO Auto-generated method stub
		String passwordRegEx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}$";
		boolean result = false;
		Pattern pattern = Pattern.compile(passwordRegEx);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AirlineException("Incorrect Password");
		  
		}
		return result;
	}

	@Override
	public boolean validateId(int id) {
		// TODO Auto-generated method stub
			String idRegx = "[\\d&&[^0]][\\d]{2}";
			boolean isValidated = Pattern.matches(idRegx, String.valueOf(id));
			if (isValidated) {
				return true;
			} else {
				throw new AirlineException("Please Enter Valid Id Which Contains Exactly 3 Digits and first Digit should be a non zero digit");
			}
		}
	public boolean validateFlightName(String flightDetails) throws AirlineException {
		String nameRegEx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(flightDetails);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AirlineException("Name should contains only Alpabates");
		}
		return result;
	}
	


//	@Override
//	public boolean validateFlightName(String flightname) {
//		// TODO Auto-generated method stub
//		String flightnameregex = "^(.+)@(.+)$";
//
//		boolean isValidated = Pattern.matches(flightnameregex, (CharSequence) flightname);
//
//		if (isValidated) {
//			return true;
//		} else {
//			throw new AirlineException("Enter valid FlightDetails");
//		}
//	}
	
	public boolean choiceValidate(String choice) {
		pattern = Pattern.compile("[1-5]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	@Override
	public boolean validateFlightDetails(int i) {
					String idRegx = "[\\d&&[^0]][\\d]{2}";
					boolean isValidated = Pattern.matches(idRegx, String.valueOf(i));
					if (isValidated) {
						return true;
					} else {
						throw new AirlineException("Please Enter Valid Id Which Contains Exactly 3 Digits and first Digit should be a non zero digit");
					}
	}
	
	
}