package com.epam.training.trains.rwvehicles;

import org.apache.log4j.Logger;

public class PassengerCar extends RailwayVehicle {
	static Logger logger;
	static{
		logger = Logger.getLogger( PassengerCar.class );
	}
	public static final int MAXPASSENGERSCOUNT = 100;
	public static final double MAXBAGGAGEWEIGHT = 10000;
	private int passengersCount;
	private double baggageWeight;
	
	public PassengerCar(){
		super();
	}
	@Override
	public String toString(){
		return super.toString() + Integer.toString( passengersCount ) +", "+ Double.toString( baggageWeight ) + "kg ]";
	}
	@Override
	public boolean equals( Object obj ){
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (obj instanceof PassengerCar ){ 
			PassengerCar temp = (PassengerCar) obj;
			return 	( this.baggageWeight == temp.getBaggageWeight())&&
					( this.passengersCount == temp.getPassengersCount() )&&
					( this.getComfortPercent() == temp.getComfortPercent())&&
					( this.getHeight() == temp.getHeight() )&&
					( this.getTonsWeight() == temp.getTonsWeight() );
		} else {
			return false;
		}
	}
	@Override
	public int hashCode(){
		return super.hashCode() + passengersCount*31 + (int)baggageWeight;
	}
	public int getPassengersCount() {
		return passengersCount;
	}

	public void setPassengersCount(int passengersCount) {
		try{
			if ((passengersCount < 0)|| (passengersCount > MAXPASSENGERSCOUNT )){
				throw new IllegalArgumentException();
			}
			this.passengersCount = passengersCount;
		} catch ( IllegalArgumentException e ){
			logger.error("wrong passengers count argument: " + passengersCount, e );
		}
	}

	public double getBaggageWeight() {
		return baggageWeight;
	}

	public void setBaggageWeight(double baggageWeight) {
		try {
			if (( baggageWeight < 0 )||( baggageWeight > MAXBAGGAGEWEIGHT ))
				throw new IllegalArgumentException();
			this.baggageWeight = baggageWeight;
		} catch ( IllegalArgumentException e ){
			logger.error( "incorrect baggage weight argument: " + baggageWeight, e );
		}
	}
}
