package com.epam.trains.entities;

import com.epam.trains.exception.OutOfRangeException;
import org.apache.log4j.Logger;

public class PassengerCar extends RailwayVehicle {
	final static Logger logger = Logger.getLogger(PassengerCar.class);

	public static final int MAX_PASSENGER_SCOUNT = 100;
	public static final double MAX_BAGGAGE_WEIGHT = 10000;
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

	public void setPassengersCount(int passengersCount) throws OutOfRangeException {

        if ((passengersCount < 0)|| (passengersCount > MAX_PASSENGER_SCOUNT)){
            logger.error("wrong passengers count argument: " + passengersCount );
            throw new OutOfRangeException();
        }
        this.passengersCount = passengersCount;
	}

	public double getBaggageWeight() {
		return baggageWeight;
	}

	public void setBaggageWeight(double baggageWeight) throws OutOfRangeException {

        if (( baggageWeight < 0 )||( baggageWeight > MAX_BAGGAGE_WEIGHT)){
            logger.error( "incorrect baggage weight argument: " + baggageWeight );
            throw new OutOfRangeException();
        }
        this.baggageWeight = baggageWeight;
    }
}
