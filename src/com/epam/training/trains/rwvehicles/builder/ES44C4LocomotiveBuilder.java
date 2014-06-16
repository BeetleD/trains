package com.epam.training.trains.rwvehicles.builder;

public class ES44C4LocomotiveBuilder extends LocomotiveBuilder {

	@Override
	public void buildHp() {
		locomotive.setHp(4400);
	}

	@Override
	public void buildModel() {
		locomotive.setModel("ES44C4");
	}

	@Override
	public void buildEngine() {
		locomotive.setEngine("GEVO-12");
	}

	@Override
	public void buildTonsWeight() {
		locomotive.setTonsWeight(126d);
	}

	@Override
	public void buildHeight() {
		// TODO Auto-generated method stub
		locomotive.setHeight(4.588d);
	}

	@Override
	public void buildComfortPercent() {
		// TODO Auto-generated method stub
		locomotive.setComfortPercent(20);
	}

}
