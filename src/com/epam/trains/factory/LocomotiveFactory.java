package com.epam.trains.factory;

import com.epam.trains.entities.Locomotive;
import com.epam.trains.entities.RailwayVehicle;
import com.epam.trains.exception.OutOfRangeException;

public class LocomotiveFactory implements RailwayVehicleFactory {

	@Override
	public RailwayVehicle getRailwayVehicle() throws OutOfRangeException {
		return new Locomotive();
	}

}
