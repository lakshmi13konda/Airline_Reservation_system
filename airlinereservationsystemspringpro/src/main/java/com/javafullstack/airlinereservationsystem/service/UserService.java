package com.javafullstack.airlinereservationsystem.service;

import com.javafullstack.airlinereservationsystem.beans.UserBean;

public interface UserService {

	public boolean registerUser(UserBean userBean);

	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);
	
	public boolean deleteTicket(String bookingId);

}
