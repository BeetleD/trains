package com.epam.trains.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.log4j.Logger;

public class PassengerTrain extends ArrayList<RailwayVehicle> {
	@Override
	public int hashCode(){
		int res = 1;
		int prime = 37;
		for (RailwayVehicle it : this)
			res = prime*res + (it==null ? 0 : it.hashCode());
		return res;
	}
}
