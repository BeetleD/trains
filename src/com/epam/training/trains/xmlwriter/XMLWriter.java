package com.epam.training.trains.xmlwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.epam.training.trains.rwvehicles.ComfortComparator;
import com.epam.training.trains.rwvehicles.Locomotive;
import com.epam.training.trains.rwvehicles.PassengerCar;
import com.epam.training.trains.rwvehicles.PassengerTrain;
import com.epam.training.trains.rwvehicles.RailwayVehicle;

public class XMLWriter {
	static Logger logger = Logger.getLogger( XMLWriter.class );
	private PassengerTrain train;
	private int minPassengersCnt;
	private int maxPassengersCnt;
	private double commonBaggageWeight;
	private int commonPassengersCnt;
	private ArrayList<PassengerCar> pCars;
	Document doc;
	private String fileName;
	DocumentBuilder builder;
	public XMLWriter( PassengerTrain train, int minPassengersCnt, int maxPassengersCnt  ){
		this.train = train;
		this.maxPassengersCnt = maxPassengersCnt;
		this.minPassengersCnt = minPassengersCnt;
	}
	private void initializeDOM(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      try { 
	    	  builder = factory.newDocumentBuilder(); 
	      } catch (ParserConfigurationException e) { 
	    	  logger.error( "impossible to initialize DOM ", e );
	      }
	}
	private void appendRailwayVehicle( Element elem, RailwayVehicle vehicle ){
		Element unitElem;
		if ( vehicle instanceof Locomotive ){
			unitElem = doc.createElement( "locomotive");
		} else if ( vehicle instanceof PassengerCar ){
			unitElem = doc.createElement("passengerCar");
		} else{
			logger.error( "unknown type of railway vehicle" );
			unitElem = doc.createElement("unknown");
		}
		
		Element field = doc.createElement( "comfort" );
		field.appendChild( doc.createTextNode( Double.toString(vehicle.getComfortPercent()) + "%" ));
		unitElem.appendChild(field);
		field = doc.createElement( "weight" );
		field.appendChild( doc.createTextNode( Double.toString(vehicle.getTonsWeight()) + " tons" ));
		unitElem.appendChild(field);
		field = doc.createElement( "height" );
		field.appendChild( doc.createTextNode( Double.toString(vehicle.getHeight())+" m" ) );
		unitElem.appendChild(field);
		if ( vehicle instanceof Locomotive ){
			Locomotive locom = (Locomotive)vehicle;
			field = doc.createElement( "hp" );
			field.appendChild( doc.createTextNode( Integer.toString(locom.getHp())));
			unitElem.appendChild(field);
			field = doc.createElement( "model" );
			field.appendChild( doc.createTextNode( locom.getModel()));
			unitElem.appendChild(field);
			field = doc.createElement( "engine" );
			field.appendChild( doc.createTextNode( locom.getEngine()));
			unitElem.appendChild(field);
		}
		if ( vehicle instanceof PassengerCar ){
			PassengerCar pCar = (PassengerCar)vehicle;
			field = doc.createElement( "passengersCount" );
			field.appendChild( doc.createTextNode( Integer.toString(pCar.getPassengersCount())));
			unitElem.appendChild(field);
			field = doc.createElement( "baggageWeight" );
			field.appendChild( doc.createTextNode( Double.toString(pCar.getBaggageWeight())+" kg"));
			unitElem.appendChild(field);
		}
		elem.appendChild( unitElem );
	}
	public void printXML(){
		 doc = builder.newDocument();
	     Element rootElement = doc.createElement("results");
	     
	     	Element elem = doc.createElement("commonBaggageWeight");
	     	elem.appendChild( doc.createTextNode( Double.toString(commonBaggageWeight)));
	     rootElement.appendChild( elem );
	     	elem = doc.createElement("commonPassengersCount");
	     	elem.appendChild( doc.createTextNode( Integer.toString( commonPassengersCnt )));
	     rootElement.appendChild( elem );
	     	elem = doc.createElement("sortedTrain");  	
	     	for ( int i = 0; i < train.size(); i++ ){
	     		appendRailwayVehicle( elem, train.get(i) );
	     	}
	     rootElement.appendChild( elem );
	     	elem = doc.createElement( "specifiedRange" );
	     	for ( PassengerCar it : pCars){
	     		appendRailwayVehicle( elem, it );
	     	}
	     rootElement.appendChild( elem );
	     	 
	     doc.appendChild(rootElement);
	     
	     Transformer t;
		try {
			t = TransformerFactory.newInstance().newTransformer();
			 t.setOutputProperty(OutputKeys.METHOD, "xml");
		     t.setOutputProperty(OutputKeys.INDENT, "yes");
		     t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(fileName)));
		} catch ( TransformerFactoryConfigurationError
					| FileNotFoundException
					| TransformerException e ) {
			logger.error( "XML writing error ", e );
		}
	    
	}
	public void execute(){
		
		commonBaggageWeight = train.commonBaggageWeight();
		commonPassengersCnt = train.commonPassengersCount();
		train.sort(Collections.reverseOrder( new ComfortComparator() ) );
		pCars = train.findPassengerCars(minPassengersCnt, maxPassengersCnt);
		initializeDOM();
		printXML();

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
