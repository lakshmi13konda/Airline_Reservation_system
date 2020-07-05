package com.javafullstackfeb.airlinereservationsystemhibernate.factory;

import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AdminDAOJPAImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AirlineDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AirlineDAOJPAImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAOJPAImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.service.AdminSeriveJPAImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.service.AdminService;
import com.javafullstackfeb.airlinereservationsystemhibernate.service.AirlineService;
import com.javafullstackfeb.airlinereservationsystemhibernate.service.AirlineServiceJPAImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.service.UserService;
import com.javafullstackfeb.airlinereservationsystemhibernate.service.UserServiceJPAImpl;


public class AirlineFactory {
	private AirlineFactory() {
		
	}
	public static AirlineDAO getAirlineDAOImplInstance() {
		AirlineDAO airlineDAO=new AirlineDAOJPAImpl();
		return airlineDAO;
	}
	 public static AirlineService getAirlineServiceImplInstance() {
	    	AirlineService airlineService=new AirlineServiceJPAImpl();
	    	return airlineService;
	    }
    public static AdminDAO getAdminDAOImplInstance() {
    	AdminDAO admindao=new AdminDAOJPAImpl();
    	return admindao;
    }
    public static UserDAO getUserDAOImplInstance() {
    	UserDAO userdao=new UserDAOJPAImpl();
    	return userdao;
    }
    public static AdminService getAdminServiceImplInstance() {
    	AdminService adminService=new AdminSeriveJPAImpl();
    	return adminService;
    }
    public static UserService getUserServiceImplInstance() {
    	UserService userService=new UserServiceJPAImpl();
    	return userService;
    }

}
