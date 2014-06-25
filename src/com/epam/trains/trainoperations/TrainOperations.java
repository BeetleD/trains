package com.epam.trains.trainoperations;

import com.epam.trains.entities.PassengerCar;
import com.epam.trains.entities.PassengerTrain;
import com.epam.trains.entities.RailwayVehicle;

import java.util.ArrayList;

/**
 * Created by Dmitry on 25.06.2014.
 */
public class TrainOperations {

    public static ArrayList<PassengerCar> findPassengerCars( PassengerTrain train, int minPassengersCnt, int maxPassengersCnt ){
        ArrayList<PassengerCar> res = new ArrayList<PassengerCar>();
        res.clear();
        for ( RailwayVehicle it : train ){
            if ( it instanceof PassengerCar ){
                PassengerCar pCar = (PassengerCar)it;
                if (( pCar.getPassengersCount() >= minPassengersCnt )&&
                        ( pCar.getPassengersCount() <= maxPassengersCnt )){
                    res.add( pCar );
                }
            }
        }
        return res;
    }
    public static double commonBaggageWeight( PassengerTrain train ){
        double res = 0;
        for ( RailwayVehicle it : train ){
            if ( it instanceof PassengerCar ){
                PassengerCar pCar = (PassengerCar)it;
                res+= pCar.getBaggageWeight();
            }
        }
        return res;
    }
    public static int commonPassengersCount( PassengerTrain train ){
        int res = 0;
        for ( RailwayVehicle it : train ){
            if ( it instanceof PassengerCar ){
                PassengerCar pCar = (PassengerCar)it;
                res+= pCar.getPassengersCount();
            }
        }
        return res;
    }
}
