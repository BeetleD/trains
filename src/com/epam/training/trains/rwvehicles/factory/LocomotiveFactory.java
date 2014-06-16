package com.epam.training.trains.rwvehicles.factory;

import com.epam.training.trains.rwvehicles.Locomotive;
import com.epam.training.trains.rwvehicles.RailwayVehicle;

public class LocomotiveFactory implements RailwayVehicleFactory {

	@Override
	public RailwayVehicle getRailwayVehicle() {
		return new Locomotive();
	}

}
