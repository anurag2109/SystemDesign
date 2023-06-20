package com.LLD.ParkingLot.model.vehicle;

import com.LLD.ParkingLot.model.ticket.ParkingTicket;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Vehicle {
	private final String licenseNumber;
	private VehicleType vehicleType;
	private ParkingTicket parkingTicket;
	public Vehicle(String licenseNumber, VehicleType vehicleType) {
		// TODO Auto-generated constructor stub
		this.licenseNumber = licenseNumber;
		this.vehicleType = vehicleType;
	}
	
	public Vehicle(String licenseNumber, VehicleType vehicleType, ParkingTicket parkingTicket) {
		super();
		this.licenseNumber = licenseNumber;
		this.parkingTicket = parkingTicket;
		this.vehicleType = vehicleType;
	}
	
	public void assignTicket(ParkingTicket parkingTicket) {
		this.parkingTicket = parkingTicket;
	}
}
