package com.epam.trains.traingenerator;

import java.util.Random;

import com.epam.trains.exception.OutOfRangeException;
import org.apache.log4j.Logger;

import com.epam.trains.entities.Locomotive;
import com.epam.trains.entities.PassengerCar;
import com.epam.trains.entities.PassengerTrain;
import com.epam.trains.entities.RailwayVehicle;
import com.epam.trains.factory.PassengerCarFactory;
import com.epam.trains.factory.RailwayVehicleFactory;

public class TrainGenerator {
	final static Logger logger = Logger.getLogger(TrainGenerator.class);
	
	static final int MAX_PASSENGERCARS_CNT = 150;
	private int passengerCarsCnt;
	public int getPassengerCarsCnt() {
		return passengerCarsCnt;
	}
	public void setPassengerCarsCnt(int passengerCarsCnt) throws OutOfRangeException {
		if (( passengerCarsCnt < 0 )&&( passengerCarsCnt > MAX_PASSENGERCARS_CNT )) {
			logger.error("incorrect passengerCarsCnt argument: " + passengerCarsCnt);
			throw new OutOfRangeException();
		}
		this.passengerCarsCnt = passengerCarsCnt;
	}
	public TrainGenerator( int passengerCarsCnt ) throws OutOfRangeException {
		setPassengerCarsCnt( passengerCarsCnt );
	}
	public PassengerTrain buildPassengerTrain() throws OutOfRangeException {
		PassengerTrain res = new PassengerTrain();
		res.clear();
		Random rand = new Random();
		res.add(new Locomotive.Creator().setHorsePowers(4400).setModel("ES44C4").setEngine("GEVO-12")
										.setTonsWeight(126).setHeight(4.588).setComfortPercent(20).create());
		res.add(new Locomotive.Creator().setHorsePowers(4250).setModel("P42DC").setEngine("GE 7FDL-16")
										.setTonsWeight(135).setHeight(4.600).setComfortPercent(40).create());

		RailwayVehicleFactory vehicleFactory = new PassengerCarFactory();
		double height = (rand.nextDouble()/2+0.5)*RailwayVehicle.MAX_HEIGHT;
		for ( int i = 0; i < passengerCarsCnt; i++ ){
			PassengerCar pCar = (PassengerCar) vehicleFactory.getRailwayVehicle();
			pCar.setHeight(height);
			pCar.setComfortPercent( rand.nextDouble()*100 );
			pCar.setBaggageWeight( rand.nextDouble()*PassengerCar.MAX_BAGGAGE_WEIGHT);
			pCar.setPassengersCount( (int)(rand.nextDouble()*PassengerCar.MAX_PASSENGER_SCOUNT) );
			pCar.setTonsWeight( rand.nextDouble()*PassengerCar.MAX_TONS_WEIGHT );
			res.add( pCar );
		}
		return res;
	}
	
}
