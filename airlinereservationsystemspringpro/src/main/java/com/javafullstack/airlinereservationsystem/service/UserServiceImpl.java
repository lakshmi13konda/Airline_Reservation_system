

package com.javafullstack.airlinereservationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstack.airlinereservationsystem.beans.UserBean;
import com.javafullstack.airlinereservationsystem.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;

	@Override
	public boolean registerUser(UserBean userBean) {
		
		return dao.registerUser(userBean);
	}

	@Override
	public UserBean userLogin(String userId, String userPassword) {
	
		return dao.userLogin(userId, userPassword);
	}

	@Override
	public boolean registerByAdmin(UserBean userBean) {
		
		return dao.registerByAdmin(userBean);
	}

	@Override
	public boolean deleteTicket(String bookingId) {
		
		return dao.deleteTicket(bookingId);
	}

}
