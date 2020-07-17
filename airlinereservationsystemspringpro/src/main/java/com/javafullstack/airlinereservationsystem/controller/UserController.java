package com.javafullstack.airlinereservationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstack.airlinereservationsystem.beans.UserBean;
import com.javafullstack.airlinereservationsystem.response.AirlineResponse;
import com.javafullstack.airlinereservationsystem.response.BookingResponse;
import com.javafullstack.airlinereservationsystem.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class UserController {
	
	@Autowired
	private UserService service;
	
	AirlineResponse response = new AirlineResponse();
	
	@PostMapping("/registerUser")
	public AirlineResponse registerUser(@RequestBody UserBean userBean) {
		boolean isAdded = service.registerUser(userBean);
		if(isAdded) {
			response.setStatus(200);
			response.setMessage("Data is added successfully..");
		} else {
			response.setStatus(400);
			response.setMessage("Failed to add the data..");
		}
		return response;
	}//end of register
	

	@PostMapping("/registerByAdmin")
	public AirlineResponse registerByAdmin(@RequestBody UserBean userBean) {
		boolean isAdded = service.registerByAdmin(userBean);
		if(isAdded) {
			response.setStatus(200);
			response.setMessage("Data is added successfully..");
		} else {
			response.setStatus(400);
			response.setMessage("Failed to add the data..");
		}
		return response;
	}//end of register
	
	@PostMapping("/userLogin")
	public AirlineResponse userLogin(@RequestBody UserBean userBean) {
		String userId = userBean.getUserId();
		String userPassword = userBean.getUserPassword();			
		UserBean userBean2 = service.userLogin(userId, userPassword);
		String role = userBean2.getUserRole();
		String getUserId = userBean2.getUserId();
		if(role.equals("user")) {
			response.setStatus(200);
			response.setMessage("Success");
			response.setRole(role);
			response.setUserId(getUserId);
		}else if(role.equals("admin")) {
			response.setStatus(200);
			response.setMessage("Success");
			response.setRole(role);	
			response.setUserId(getUserId);
		}else if(role.equals("exe")) {
			response.setStatus(200);
			response.setMessage("Success");
			response.setRole(role);
			response.setUserId(getUserId);
		}else {
			response.setStatus(400);
			response.setMessage("Failed");
		}
		return response;
	}// end of userLogin()

	@DeleteMapping("/deleteTicket")
	public BookingResponse deleteBooking(String userId) {
		boolean isDeleted = service.deleteTicket(userId);
		BookingResponse response = new BookingResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Ticket cancelled successfully. We will refund your payment within 3 working days. ");
			response.setDescription("Ticket cancelled successfully. We will refund your payment within 3 working days ");
		} else {
			response.setStatusCode(401);
			response.setMessage("Oops! Ticket can not be cancelled.");
			response.setDescription("Oops!Ticket can not be cancelled.");

		}
		return response;
	}
	
}// end of controller class
