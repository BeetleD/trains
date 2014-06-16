package com.epam.training.trains.rwvehicles;

import java.util.Comparator;

public class ComfortComparator implements Comparator<RailwayVehicle> {

	@Override
	public int compare(RailwayVehicle arg0, RailwayVehicle arg1) {
		return arg0.compareTo( arg1 );
	}

}
