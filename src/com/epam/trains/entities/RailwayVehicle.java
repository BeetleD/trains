package com.epam.trains.entities;

import com.epam.trains.exception.OutOfRangeException;
import org.apache.log4j.Logger;

import com.epam.trains.Main;

public abstract class RailwayVehicle implements Comparable<RailwayVehicle> {
	final static Logger logger = Logger.getLogger(RailwayVehicle.class);
	public static final double MAX_TONS_WEIGHT = 500d;
	public static final double MAX_HEIGHT = 6d;
	public static final double MAX_COMFORT_PERCENT = 100d;
	
	private double tonsWeight;
	private double height;
	private double comfortPercent;

	@Override
	public String toString(){
		return "[ " + Double.toString( tonsWeight ) +"tons, "+ Double.toString(height) + "m, "
				+ Double.toString( comfortPercent )+"%, ";
	}
	@Override
	public boolean equals( Object obj ){
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (obj instanceof Locomotive ){ 
			Locomotive temp = (Locomotive) obj;
			return 	( this.getComfortPercent() == temp.getComfortPercent())&&
					( this.getHeight() == temp.getHeight() )&&
					( this.getTonsWeight() == temp.getTonsWeight() );
		} else {
			return false;
		}
	}
	@Override
	public int hashCode(){
        int prime = 37;
		int res = (((int)comfortPercent*prime+(int)height)*prime + (int)tonsWeight);
		return res;
	}
	public int compareTo( RailwayVehicle vehicle ){
		double res = this.comfortPercent - vehicle.getComfortPercent(); 
		if ( res < 0 ){
			return -1;
		} else if ( res > 0 ){
			return 1;
		} else {
			return 0;
		}
	}
	public double getTonsWeight() {
		return tonsWeight;
	}
	public void setTonsWeight(double tonsWeight) throws OutOfRangeException {
		if (( tonsWeight < 0 )||( tonsWeight > MAX_TONS_WEIGHT )){ 
			logger.error( "incorrect weight argument "+tonsWeight );
			throw new OutOfRangeException();
		}
		this.tonsWeight = tonsWeight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) throws OutOfRangeException {

        if (( height < 0 )||( height > MAX_HEIGHT )){
            logger.error( "incorrect height argument "+height );
            throw new OutOfRangeException();
        }
        this.height = height;
	}
	public double getComfortPercent() {
		return comfortPercent;
	}
	public void setComfortPercent(double comfortPercent) throws OutOfRangeException {
        if (( comfortPercent < 0)||( comfortPercent > MAX_COMFORT_PERCENT )){
            logger.error( "incorrect comfortability percent argument "+comfortPercent+"%" );
            throw new OutOfRangeException();
        }
        this.comfortPercent = comfortPercent;
	}
}
