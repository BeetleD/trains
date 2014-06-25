package com.epam.trains.entities;

import com.epam.trains.exception.OutOfRangeException;
import org.apache.log4j.Logger;

public class Locomotive extends RailwayVehicle {
	static Logger logger = Logger.getLogger( Locomotive.class );
	public static final int MIN_HORSE_POWERS = 1;
	private int horsePowers;
	private String model;
    private String engine;

    public Locomotive(){
	}
	@Override
	public String toString(){
		return super.toString() + Integer.toString( horsePowers )+"horse powers, "+ model+", " + engine +" ]";
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
					( this.horsePowers == temp.getHorsePowers() );
		} else {
			return false;
		}
	}
	public int hashCode(){
		int prime = 37;
		return super.hashCode()*prime + horsePowers;
	}
	public int getHorsePowers() {
		return horsePowers;
	}
	public void setHorsePowers(int hp) throws OutOfRangeException {

			if ( hp < MIN_HORSE_POWERS ){
				logger.error( "incorrect hp argument: " + hp);
				throw new OutOfRangeException();
			}
			this.horsePowers = hp;
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

	public static class Creator {

		private int horsePowers;
		private String engine;
		private String model;
		private double comfortPercent;
		private double height;
		private double tonsWeight;

		public int getHorsePowers() {
			return horsePowers;
		}

		public Creator setHorsePowers(int horsePowers) {
			this.horsePowers = horsePowers;
			return this;
		}

		public String getEngine() {
			return engine;
		}

		public Creator setEngine(String engine) {
			this.engine = engine;
			return this;
		}

		public String getModel() {
			return model;
		}

		public Creator setModel(String model) {
			this.model = model;
			return this;
		}

		public double getComfortPercent() {
			return comfortPercent;
		}

		public Creator setComfortPercent(double comfortPercent) {
			this.comfortPercent = comfortPercent;
			return this;
		}

		public double getHeight() {
			return height;
		}

		public Creator setHeight(double height) {
			this.height = height;
			return this;
		}

		public double getTonsWeight() {
			return tonsWeight;
		}

		public Creator setTonsWeight(double tonsWeight) {
			this.tonsWeight = tonsWeight;
			return this;
		}
		public Locomotive create() throws OutOfRangeException {
			return new Locomotive( this );
		}
	}

	private Locomotive( Creator creator ) throws OutOfRangeException {
		setHorsePowers( creator.horsePowers );
		setEngine( creator.engine );
		setModel( creator.model );
		setComfortPercent( creator.comfortPercent );
		setHeight( creator.height );
		setTonsWeight( creator.tonsWeight );
	}
}
