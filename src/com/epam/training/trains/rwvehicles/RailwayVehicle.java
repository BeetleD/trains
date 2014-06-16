package com.epam.training.trains.rwvehicles;

import org.apache.log4j.Logger;

import com.epam.training.trains.Train;

public abstract class RailwayVehicle implements Comparable<RailwayVehicle> {
	static Logger logger;
	static{
		logger = Logger.getLogger(RailwayVehicle.class);
	} 
	public static final double MAXTONSWEIGHT = 500d;
	public static final double MAXHEIGHT = 6d;
	public static final double MAXCOMFORTPERCENT = 100d;
	
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
		int res = (int)comfortPercent*31;
		res = res*31+(int)height;
		res = res*31 +(int)tonsWeight;
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
	public void setTonsWeight(double tonsWeight) {
		try {
			if (( tonsWeight < 0 )||( tonsWeight > MAXTONSWEIGHT )){ 
				throw new IllegalArgumentException();
			}
			this.tonsWeight = tonsWeight;
		} catch( IllegalArgumentException e ){
			logger.error( "incorrect weight argument "+tonsWeight, e );
		}
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		try {
			if (( height < 0 )||( height > MAXHEIGHT )){ 
				throw new IllegalArgumentException();
			}
			this.height = height;
		} catch( IllegalArgumentException e ){
			logger.error( "incorrect height argument "+height, e );
		}
	}
	public double getComfortPercent() {
		return comfortPercent;
	}
	public void setComfortPercent(double comfortPercent) {
		try {
			if (( comfortPercent < 0)||( comfortPercent > MAXCOMFORTPERCENT )){
				throw new IllegalArgumentException();
			}
			this.comfortPercent = comfortPercent;
		} catch( IllegalArgumentException e ){
			logger.error( "incorrect comfortability percent argument "+comfortPercent+"%", e );
		}
	}
}
