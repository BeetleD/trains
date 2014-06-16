package com.epam.training.trains.rwvehicles.builder;

import com.epam.training.trains.rwvehicles.Locomotive;

public abstract class LocomotiveBuilder {
	
	protected Locomotive locomotive;
	public void createNewLocomotive(){
		locomotive = new Locomotive();
	}
	public Locomotive getLocomotive(){
		return locomotive;
	}
	public abstract void buildHp();
	public abstract void buildModel();
	public abstract void buildEngine();
	public abstract void buildTonsWeight();
	public abstract void buildHeight();
	public abstract void buildComfortPercent();
	
}
