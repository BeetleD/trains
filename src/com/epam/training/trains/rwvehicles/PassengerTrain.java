package com.epam.training.trains.rwvehicles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.log4j.Logger;

public class PassengerTrain {
	static Logger logger;
	static{
		logger = Logger.getLogger( PassengerTrain.class );
	}
	private ArrayList<RailwayVehicle> train;
	public PassengerTrain(){
		train = new ArrayList<RailwayVehicle>();
	}
	@Override
	public String toString(){
		return train.toString();
	}
	@Override
	public boolean equals( Object obj ){
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (obj instanceof PassengerTrain ){ 
			PassengerTrain temp = (PassengerTrain) obj;
			return this.train.equals( temp.train );
		} else {
			return false;
		}
	}
	@Override
	public int hashCode(){
		int res = 0;
		for ( int i = 0; i < this.size(); i++ )
			res+= train.get(i).hashCode();
		return res;
	}
	public void sort(){
		Collections.sort( train );
	}
	public void sort( Comparator<RailwayVehicle> comp ){
		Collections.sort( train, comp );
	}
	public ArrayList<PassengerCar> findPassengerCars( int minPassengersCnt, int maxPassengersCnt ){
		ArrayList<PassengerCar> res = new ArrayList<PassengerCar>();
		res.clear();
		for ( RailwayVehicle it : train ){
			if ( it instanceof PassengerCar ){
				PassengerCar pCar = (PassengerCar)it;
				if (( pCar.getPassengersCount() >= minPassengersCnt )&&
						( pCar.getPassengersCount() <= maxPassengersCnt )){
					res.add( pCar );
				}
			}
		}
		return res;
	}
	public double commonBaggageWeight(){
		double res = 0;
		for ( RailwayVehicle it : train ){
			if ( it instanceof PassengerCar ){
				PassengerCar pCar = (PassengerCar)it;
				res+= pCar.getBaggageWeight();
			}
		}
		return res;
	}
	public int commonPassengersCount(){
		int res = 0;
		for ( RailwayVehicle it : train ){
			if ( it instanceof PassengerCar ){
				PassengerCar pCar = (PassengerCar)it;
				res+= pCar.getPassengersCount();
			}
		}
		return res;
	}
	public void add( RailwayVehicle vehicle ){
		train.add( vehicle );
	}
	public void add( int index, RailwayVehicle vehicle ) {
		train.add( index, vehicle );
	}
	public void clear(){
		train.clear();
	}
	public RailwayVehicle get( int index ){
		return train.get( index );
	}
	public int size(){
		return train.size();
	}
}
