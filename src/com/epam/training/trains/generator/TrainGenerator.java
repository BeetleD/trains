package com.epam.training.trains.generator;

import java.util.Random;

import org.apache.log4j.Logger;

import com.epam.training.trains.rwvehicles.Locomotive;
import com.epam.training.trains.rwvehicles.PassengerCar;
import com.epam.training.trains.rwvehicles.PassengerTrain;
import com.epam.training.trains.rwvehicles.RailwayVehicle;
import com.epam.training.trains.rwvehicles.builder.ES44C4LocomotiveBuilder;
import com.epam.training.trains.rwvehicles.builder.LocomotiveWaiter;
import com.epam.training.trains.rwvehicles.builder.P42DCLocomotiveBuilder;
import com.epam.training.trains.rwvehicles.factory.PassengerCarFactory;
import com.epam.training.trains.rwvehicles.factory.RailwayVehicleFactory;

public class TrainGenerator {
	static Logger logger;
	static {
		logger = Logger.getLogger(TrainGenerator.class);
	}
	static final int MAXPASSENGERCARSCNT = 150;
	static final int MAXLOCOMOTIVESCNT = 5;
	private int passengerCarsCnt;
	private int locomotivesCnt;
	public int getPassengerCarsCnt() {
		return passengerCarsCnt;
	}
	public void setPassengerCarsCnt(int passengerCarsCnt) {
		try {
			if (( passengerCarsCnt < 0 )&&( passengerCarsCnt > MAXPASSENGERCARSCNT ))
				throw new IllegalArgumentException();
			this.passengerCarsCnt = passengerCarsCnt;
		} catch ( IllegalArgumentException e ){
			logger.error( "incorrect passengerCarsCnt argument: " + passengerCarsCnt, e );
		}
	}
	public int getLocomotivesCnt() {
		return locomotivesCnt;
	}
	public void setLocomotivesCnt(int locomotivesCnt) {
		try {
			if (( locomotivesCnt < 0 )&&( locomotivesCnt > MAXLOCOMOTIVESCNT ))
				throw new IllegalArgumentException();
			this.locomotivesCnt = locomotivesCnt;
		} catch ( IllegalArgumentException e ){
			logger.error( "incorrect locomotivesCnt argument: " + locomotivesCnt, e );
		}
	}
	public TrainGenerator( int passengerCarsCnt, int locomotivesCnt ){
		setLocomotivesCnt( locomotivesCnt );
		setPassengerCarsCnt( passengerCarsCnt );
	}
	public PassengerTrain buildPassengerTrain(){
		PassengerTrain res = new PassengerTrain();
		res.clear();
		Random rand = new Random();
		LocomotiveWaiter[] locomotiveWaiter = { new LocomotiveWaiter( new ES44C4LocomotiveBuilder() ),
												new LocomotiveWaiter( new P42DCLocomotiveBuilder() ) };
		for ( int i = 0; i < locomotivesCnt; i++ ){
			Locomotive locomotive = locomotiveWaiter[rand.nextInt(2)].createLocomotive();
			res.add( locomotive );
		}
		RailwayVehicleFactory vehicleFactory = new PassengerCarFactory();
		double height = (rand.nextDouble()/2+0.5)*RailwayVehicle.MAXHEIGHT;
		for ( int i = 0; i < passengerCarsCnt; i++ ){
			PassengerCar pCar = (PassengerCar) vehicleFactory.getRailwayVehicle();
			pCar.setHeight(height);
			pCar.setComfortPercent( rand.nextDouble()*100 );
			pCar.setBaggageWeight( rand.nextDouble()*PassengerCar.MAXBAGGAGEWEIGHT );
			pCar.setPassengersCount( (int)(rand.nextDouble()*PassengerCar.MAXPASSENGERSCOUNT) );
			pCar.setTonsWeight( rand.nextDouble()*PassengerCar.MAXTONSWEIGHT );
			res.add( pCar );
		}
		return res;
	}
	
}
