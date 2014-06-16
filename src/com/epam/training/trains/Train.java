package com.epam.training.trains;

import org.apache.log4j.Logger;

import com.epam.training.trains.generator.TrainGenerator;
import com.epam.training.trains.rwvehicles.PassengerTrain;
import com.epam.training.trains.xmlwriter.XMLWriter;

public class Train {
	
	
	static void stub(){
		
		TrainGenerator tGenerator = new TrainGenerator( 20, 5 );
		PassengerTrain pTrain = tGenerator.buildPassengerTrain();
		XMLWriter xmlWriter = new XMLWriter( pTrain, 40, 80 );
		xmlWriter.setFileName("result.xml");
		xmlWriter.execute();
	}
	static Logger logger;
	static{
		logger = Logger.getLogger(Train.class);
	}
	public static void main(String[] args) {
		logger.info("Trains application started");
		stub();
		
	}

}
