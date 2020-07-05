package com.javafullstackfeb.airlinereservationsystem.factory;

import com.javafullstackfeb.airlinereservationsystem.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystem.dao.AdminDAOImpl;
import com.javafullstackfeb.airlinereservationsystem.services.AdminService;
import com.javafullstackfeb.airlinereservationsystem.services.AdminServiceImpl;
import com.javafullstackfeb.airlinereservationsystem.validations.AirlineValidations;
import com.javafullstackfeb.airlinereservationsystem.validations.AirlineValidationsImpl;

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
