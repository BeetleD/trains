package com.epam.trains.factory;

import com.epam.trains.entities.PassengerCar;
import com.epam.trains.entities.RailwayVehicle;

public class PassengerCarFactory implements RailwayVehicleFactory {

	@Override
    public PassengerCar getRailwayVehicle() {
		return new PassengerCar();
	}

}
