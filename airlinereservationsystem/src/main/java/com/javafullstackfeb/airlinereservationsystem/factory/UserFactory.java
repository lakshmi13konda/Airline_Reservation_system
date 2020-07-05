package com.javafullstackfeb.airlinereservationsystem.factory;

import com.javafullstackfeb.airlinereservationsystem.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystem.dao.UserDAOImpl;
import com.javafullstackfeb.airlinereservationsystem.services.UserServices;
import com.javafullstackfeb.airlinereservationsystem.services.UserServicesImpl;

public class UserFactory {

	private UserFactory() {

	}

	
	public static UserServices getUserServicesInstance() {
		UserServices userservice = new UserServicesImpl();
		return userservice;
	}
	
	public static UserDAO getUserDAOImplInstance() {
		UserDAO userdao = new UserDAOImpl();
		return userdao;
	}

}
