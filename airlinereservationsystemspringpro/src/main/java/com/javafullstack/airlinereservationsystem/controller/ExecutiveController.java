package com.javafullstack.airlinereservationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstack.airlinereservationsystem.beans.AirlineExecutiveBeans;
import com.javafullstack.airlinereservationsystem.beans.FlightInformation;
import com.javafullstack.airlinereservationsystem.response.ExecutiveResponse;
import com.javafullstack.airlinereservationsystem.service.AirlineExecutiveService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class ExecutiveController {
	@Autowired
	private AirlineExecutiveService executiveService;

	@PostMapping("/getOccupancy")
	public ExecutiveResponse getFlight(@RequestBody FlightInformation flightInformation) {
		String flightNumber = flightInformation.getFlightNumber();
		AirlineExecutiveBeans executive = executiveService.viewFlightOccupancy(flightNumber);
		ExecutiveResponse response = new ExecutiveResponse();
		if (executive != null) {
			response.setStatus(210);
			response.setMessage("Flight Occupancy retrieved sucessfully.");
			response.setDescription("All the occupancy of flightNo : " + flightNumber + " are reterived successfully.");
			response.setExecutive(executive);
		} else {

			response.setStatus(401);
			response.setMessage("No data available for the flightNo. : " + flightNumber);
			response.setDescription("No data available for the flightNo. : " + flightNumber);

		}
		return response;

	}// end of getflight()
}
