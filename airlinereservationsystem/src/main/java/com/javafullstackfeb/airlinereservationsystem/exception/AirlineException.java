package com.javafullstackfeb.airlinereservationsystem.exception;

@SuppressWarnings("serial")
public class AirlineException extends RuntimeException{

	public AirlineException(String msgn) {
		
		super(msgn);
		
	}
}
