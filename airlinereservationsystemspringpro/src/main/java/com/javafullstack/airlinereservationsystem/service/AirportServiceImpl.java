package com.javafullstack.airlinereservationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstack.airlinereservationsystem.beans.AirportBeans;
import com.javafullstack.airlinereservationsystem.dao.AirlineExecutiveDAO;
import com.javafullstack.airlinereservationsystem.dao.AirportDAO;
import com.javafullstack.airlinereservationsystem.dao.FlightDAO;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportDAO airportDao;
	
	@Autowired
	private FlightDAO flightdao;

	@Override
	public boolean addAirport(AirportBeans airport) {
		return airportDao.addAirport(airport);
	}

	@Override
	public boolean updateAirport(AirportBeans airport) {
		// TODO Auto-generated method stub
		return airportDao.updateAirport(airport);
	}

	@Override
	public boolean deleteAirport(String abbreviation) {
		return airportDao.deleteAirport(abbreviation);
	}

	@Override
	public List<AirportBeans> getAllAirport() {
		
		return flightdao.getAllAirport();
		
		
	}

	
}
