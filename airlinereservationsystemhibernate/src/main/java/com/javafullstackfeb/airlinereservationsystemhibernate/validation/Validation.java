package com.javafullstackfeb.airlinereservationsystemhibernate.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.javafullstackfeb.airlinereservationsystemhibernate.exception.ARSException;

public class Validation {
	public boolean validatedId(int id) throws ARSException {
		String idRegEx = "[0-9]{1}[0-9]{3}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new ARSException("Invalid Id! Id should contain exactly 4 positive digits");
		}
		return result;
	}

	public boolean validatedName(String name) throws ARSException {
		String nameRegEx =  "^[A-Za-z\\s]{3,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ;
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new ARSException("Name should contain atleast 3 characters and only alphabets");
		}
		return result;
	}

	public boolean validatedMobile(long mobile) throws ARSException {
		String mobileRegEx = "(0/91)?[6-9][0-9]{9}";
		boolean result = false;
		if (Pattern.matches(mobileRegEx, String.valueOf(mobile))) {
			result = true;
		} else {
			throw new ARSException(
					"Enter a mobile number whose length is 10 digits and should start with 6,7,8,9 digits only");
		}
		return result;
	}

	public boolean validatedEmail(String email) throws ARSException {
		String emailRegEx = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
			
		} else {
			
			throw new ARSException("Enter The Proper Email ID (eg:sagar@gmail.com)");
		}
		return result;
	}

	public boolean validatedPassword(String password) throws ARSException {
		String passwordRegEx = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%]).{6,20})";
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) {
			result = true;
		} else {
			throw new ARSException(
					"Password should contain atleast 6 characters ,atleast one uppercase,atleast one lowercase,atleast one number,atleast one special symbol(@#$%) ");
		  
		}
		return result;
	}
	public boolean validatedSource(String source) throws ARSException {
		String nameRegEx = "^(?=.{4,20}$)(?![_.-])(?!.*[.]{2})[a-zA-Z._-]+(?<![_.-])";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(source);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new ARSException("Invalid Source! Source should have atleast 4 characters");
		}
		return result;
	}
	public boolean validatedRole(String role) throws ARSException {
		String roleRegEx = "^(?i)(admin|user)$" ;
		boolean result = false;
		if(Pattern.matches(roleRegEx, String.valueOf(role))) {
			result = true;
		} else {
			throw new ARSException("Enter admin or user as role ");
		}
		return result;
	}
	public boolean validatedDestination(String Destination) throws ARSException {
		String nameRegEx = "^(?=.{4,20}$)(?![_.-])(?!.*[.]{2})[a-zA-Z._-]+(?<![_.-])";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(Destination);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new ARSException("Invalid Destination! Destination should have atleast 4 characters");
		}
		return result;
	}

	public boolean validatedAdminRole(String role) throws ARSException {
		String roleRegEx = "^(?i)(admin)$" ;
		boolean result = false;
		if(Pattern.matches(roleRegEx, String.valueOf(role))) {
			result = true;
		} else {
			throw new ARSException("Enter admin  as role ");
		}
		return result;
	}
	public boolean validatedUserRole(String role) throws ARSException {
		String roleRegEx = "^(?i)(user)$" ;
		boolean result = false;
		if(Pattern.matches(roleRegEx, String.valueOf(role))) {
			result = true;
		} else {
			throw new ARSException("Enter user as role ");
		}
		return result;
	}



}
