package com.epam.training.trains.rwvehicles.factory;

import com.epam.training.trains.rwvehicles.PassengerCar;
import com.epam.training.trains.rwvehicles.RailwayVehicle;

public class PassengerCarFactory implements RailwayVehicleFactory {

	@Override
	public RailwayVehicle getRailwayVehicle() {
		return new PassengerCar();
	}

}
