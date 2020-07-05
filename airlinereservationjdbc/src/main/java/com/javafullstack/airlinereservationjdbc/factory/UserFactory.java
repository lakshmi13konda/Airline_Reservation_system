package com.javafullstack.airlinereservationjdbc.factory;

import com.javafullstack.airlinereservationjdbc.dao.UserDAO;
import com.javafullstack.airlinereservationjdbc.dao.UserDAOImpl;
import com.javafullstack.airlinereservationjdbc.services.UserServices;
import com.javafullstack.airlinereservationjdbc.services.UserServicesImpl;

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
