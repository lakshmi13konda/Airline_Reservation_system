package com.javafullstack.airlinereservationsystem.dao;

import com.javafullstack.airlinereservationsystem.beans.AirlineExecutiveBeans;

public interface AirlineExecutiveDAO {

	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber);

}
