package com.epam.training.trains.rwvehicles.builder;

public class P42DCLocomotiveBuilder extends LocomotiveBuilder {

	@Override
	public void buildHp() {
		locomotive.setHp(4250);
	}

	@Override
	public void buildModel() {
		locomotive.setModel("P42DC");
	}

	@Override
	public void buildEngine() {
		locomotive.setEngine("GE 7FDL-16");
	}

	@Override
	public void buildTonsWeight() {
		locomotive.setTonsWeight(135d);
	}

	@Override
	public void buildHeight() {
		// TODO Auto-generated method stub
		locomotive.setHeight(4.600d);
	}

	@Override
	public void buildComfortPercent() {
		// TODO Auto-generated method stub
		locomotive.setComfortPercent(40);
	}

}
