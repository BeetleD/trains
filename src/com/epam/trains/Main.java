package com.epam.trains;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import com.epam.trains.comparator.ComfortComparator;
import com.epam.trains.entities.PassengerCar;
import com.epam.trains.exception.OutOfRangeException;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.epam.trains.entities.PassengerTrain;
import com.epam.trains.traingenerator.TrainGenerator;
import trainoperations.TrainOperations;

public class Main {
	
	final static Logger logger = Logger.getLogger(Main.class);
	static{
		DOMConfigurator.configure("src\\log4j.xml");
	}
	public static void main(String[] args) {
		
		logger.info("Trains application started");
        TrainGenerator tGenerator = null;
        try {
            tGenerator = new TrainGenerator( 20 );
            PassengerTrain pTrain = tGenerator.buildPassengerTrain();
            double commonBaggageWeight = TrainOperations.commonBaggageWeight( pTrain );
            int commonPassengersCnt = TrainOperations.commonPassengersCount(pTrain);
            pTrain.sort(Collections.reverseOrder(new ComfortComparator()) );
            ArrayList<PassengerCar> pCars = TrainOperations.findPassengerCars( pTrain, 40, 80 );

        } catch (OutOfRangeException e) {
            logger.error( "OutOfRange exception in Main");
        }

	}
}
