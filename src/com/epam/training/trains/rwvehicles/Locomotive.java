package com.epam.training.trains.rwvehicles;

import org.apache.log4j.Logger;

public class Locomotive extends RailwayVehicle {
	static Logger logger;
	static{
		logger = Logger.getLogger( Locomotive.class );
	}
	public static final int MINHP = 1;
	private int hp;
	private String model;
	private String engine;
	@Override
	public String toString(){
		return super.toString() + Integer.toString( hp )+"hp, "+ model+", " + engine +" ]";
	}
	public boolean equals( Object obj ){
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (obj instanceof Locomotive ){ 
			Locomotive temp = (Locomotive) obj;
			return 	( this.engine.equals(temp.getEngine()))&&
					( this.model.equals(temp.getModel() ))&&
					( this.getComfortPercent() == temp.getComfortPercent())&&
					( this.getHeight() == temp.getHeight() )&&
					( this.getTonsWeight() == temp.getTonsWeight() )&&
					( this.hp == temp.getHp() );
		} else {
			return false;
		}
	}
	public int hashCode(){
		return super.hashCode() + hp*17;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		try {
			if ( hp < MINHP ){
				throw new IllegalArgumentException();
			}
			this.hp = hp;
		} catch ( IllegalArgumentException e ){
			logger.error( "incorrect hp argument: " + hp, e );
		}
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
}
