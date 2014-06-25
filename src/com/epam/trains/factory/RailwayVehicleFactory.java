package com.epam.trains.factory;

import com.epam.trains.entities.RailwayVehicle;
import com.epam.trains.exception.OutOfRangeException;


public interface RailwayVehicleFactory {
	public RailwayVehicle getRailwayVehicle() throws OutOfRangeException;
}
