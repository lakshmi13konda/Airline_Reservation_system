package com.javafullstack.airlinereservationsystem.dao;

import com.javafullstack.airlinereservationsystem.beans.UserBean;

public interface UserDAO {
	
	public boolean registerUser(UserBean userBean);
	
	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);
	
	public boolean deleteTicket(String bookingId);

}
