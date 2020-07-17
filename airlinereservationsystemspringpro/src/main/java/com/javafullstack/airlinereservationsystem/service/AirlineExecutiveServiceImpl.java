package com.javafullstack.airlinereservationsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstack.airlinereservationsystem.beans.AirlineExecutiveBeans;
import com.javafullstack.airlinereservationsystem.dao.AirlineExecutiveDAO;

@Service
public class AirlineExecutiveServiceImpl implements AirlineExecutiveService {

	@Autowired
	private AirlineExecutiveDAO airlineDao;

	@Override
	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber) {

		return airlineDao.viewFlightOccupancy(flightNumber);
	}

}
