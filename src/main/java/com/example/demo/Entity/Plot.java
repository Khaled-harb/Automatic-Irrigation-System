package com.example.demo.Entity;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Plot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String crop;
	boolean Alert;
	double litersOfWater;
	boolean sensor;
	float sizeOfArea;
	int numOfIrrigations;
	HashSet<String>  timeToBeIrrigate;
	

	

	

	
	public Plot(int id, String crop, boolean alert, double litersOfWater, boolean sensor, float sizeOfArea,
			int numOfIrrigations, HashSet<String> timeToBeIrrigate) {
		super();
		this.id = id;
		this.crop = crop;
		Alert = alert;
		this.litersOfWater = litersOfWater;
		this.sensor = sensor;
		this.sizeOfArea = sizeOfArea;
		this.numOfIrrigations = numOfIrrigations;
		this.timeToBeIrrigate = timeToBeIrrigate;
	}

	public Plot() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAlert() {
		return Alert;
	}

	public void setAlert(boolean Alert) {
		this.Alert = Alert;
	}

	public double getLitersOfWater() {
		return litersOfWater;
	}

	public void setLitersOfWater(double litersOfWater) {
		this.litersOfWater = litersOfWater;
	}

	public boolean isSensor() {
		return sensor;
	}

	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}

	public float getSizeOfArea() {
		return sizeOfArea;
	}

	public void setSizeOfArea(float sizeOfArea) {
		this.sizeOfArea = sizeOfArea;
	}

	public int getNumOfIrrigations() {
		return numOfIrrigations;
	}

	public void setNumOfIrrigations(int numOfIrrigations) {
		this.numOfIrrigations = numOfIrrigations;
	}

	public HashSet<String> getTimeToBeIrrigate() {
		return timeToBeIrrigate;
	}

	public void setTimeToBeIrrigate(HashSet<String> timeToBeIrrigate) {
		this.timeToBeIrrigate = timeToBeIrrigate;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}
	

}
