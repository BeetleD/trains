package com.epam.trains.comparator;

import java.util.Comparator;

import com.epam.trains.entities.RailwayVehicle;

public class ComfortComparator implements Comparator<RailwayVehicle> {

	@Override
	public int compare(RailwayVehicle arg0, RailwayVehicle arg1) {
		return arg0.compareTo( arg1 );
	}

}
