package com.LLD.ParkingLot.model.parking.spot;

import com.LLD.ParkingLot.model.vehicle.Vehicle;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Builder
public class ParkingSpot {
	@Getter
	private final String id;
	
	@Getter
	private final ParkingSpotType parkingSpotType;
	private boolean isFree;
	private Vehicle assignedVehicle;
	public ParkingSpot(String id, ParkingSpotType parkingSpotType) {
		this.id = id;
		this.parkingSpotType = parkingSpotType;
		this.isFree = true;
	}
	
	
	public void assignVehicle(Vehicle vehicle) {
		isFree = false;
		assignedVehicle = vehicle;
	}
	
	public void vacateSpace() {
		isFree = true;
		assignedVehicle = null;
	}


	public ParkingSpot(String id, ParkingSpotType parkingSpotType, boolean isFree, Vehicle assignedVehicle) {
		super();
		this.id = id;
		this.parkingSpotType = parkingSpotType;
		this.isFree = isFree;
		this.assignedVehicle = assignedVehicle;
	}
	
}
