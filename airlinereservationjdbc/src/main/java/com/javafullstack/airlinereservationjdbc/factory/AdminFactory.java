package com.javafullstack.airlinereservationjdbc.factory;

import com.javafullstack.airlinereservationjdbc.dao.AdminDAO;
import com.javafullstack.airlinereservationjdbc.dao.AdminDAOImpl;
import com.javafullstack.airlinereservationjdbc.services.AdminService;
import com.javafullstack.airlinereservationjdbc.services.AdminServiceImpl;
import com.javafullstack.airlinereservationjdbc.validations.AirlineValidations;
import com.javafullstack.airlinereservationjdbc.validations.AirlineValidationsImpl;

public class AdminFactory {

private AdminFactory() {
		
	}

	public static AdminService getAdminServiceInstance() {
		AdminService adminservice = new AdminServiceImpl();
		return adminservice;
	}

	public static AdminDAO getAdminDAOImplInstance() {
		AdminDAO admindao = new AdminDAOImpl();
		return admindao;
	}


	public static AirlineValidations getAirlineValidationsInstance() {
		AirlineValidations validation = new AirlineValidationsImpl();
		return validation;
	}


	
}
