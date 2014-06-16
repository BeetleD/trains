package com.epam.training.trains.rwvehicles.builder;

import com.epam.training.trains.rwvehicles.Locomotive;

public class LocomotiveWaiter {
	private LocomotiveBuilder locomotiveBuilder;
	public LocomotiveWaiter( LocomotiveBuilder locomotiveBuilder ){
		this.locomotiveBuilder = locomotiveBuilder;
	}
	public void setLocomotiveBuilder( LocomotiveBuilder locomotiveBuilder ){
		this.locomotiveBuilder = locomotiveBuilder;
	}
	public Locomotive getLocomotive(){
		return locomotiveBuilder.getLocomotive();
	}
	public Locomotive createLocomotive(){
		locomotiveBuilder.createNewLocomotive();
		locomotiveBuilder.buildComfortPercent();
		locomotiveBuilder.buildEngine();
		locomotiveBuilder.buildHp();
		locomotiveBuilder.buildModel();
		locomotiveBuilder.buildTonsWeight();
		locomotiveBuilder.buildHeight();
		return locomotiveBuilder.getLocomotive();
	}
}

