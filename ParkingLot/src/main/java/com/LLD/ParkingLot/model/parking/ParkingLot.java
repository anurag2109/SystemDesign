package com.LLD.ParkingLot.model.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.LLD.ParkingLot.exceptions.InvalidParkingFloorException;
import com.LLD.ParkingLot.exceptions.ParkingException;
import com.LLD.ParkingLot.model.parking.panel.EntryPanel;
import com.LLD.ParkingLot.model.parking.panel.ExitPanel;
import com.LLD.ParkingLot.model.parking.spot.ParkingSpot;
import com.LLD.ParkingLot.model.vehicle.Vehicle;

import lombok.Getter;

@Getter
public class ParkingLot {
	private final String id;
	private String address;
	private final List<ParkingFloor> parkingFloors;
	private final List<EntryPanel> entryPanels;
	private final List<ExitPanel> exitPanels;
	
	public static final ParkingLot INSTANCE = new ParkingLot();
	
	public ParkingLot() {
		this.id = UUID.randomUUID().toString();
		this.parkingFloors = new ArrayList<>();
		this.entryPanels = new ArrayList<>();
		this.exitPanels = new ArrayList<>();
		this.address = "Village Kasera";
	}
	
	public void updateAddress(final String address) {
		this.address = address;
	}
	
	public void addFloor(final ParkingFloor parkingFloor) {
		final Optional<ParkingFloor> floor = parkingFloors.stream().filter(pf-> pf.getId().equals(parkingFloor.getId())).findFirst();
		if(floor.isPresent()) {
			return;
		}
		parkingFloors.add(parkingFloor);
	}
	
	public void addEntryPanel(final EntryPanel entryPanel) {
		final Optional<EntryPanel> panel = entryPanels.stream().filter(ep -> ep.getId().equals(entryPanel.getId())).findFirst();
		if(panel.isPresent()) {
			return;
		}
		entryPanels.add(entryPanel);
	}
	
	public void addExitPanel(final ExitPanel exitPanel) {
		final Optional<ExitPanel> panel = exitPanels.stream().filter(exp -> exp.getId().equals(exitPanel.getId())).findFirst();
		if(panel.isPresent()) {
			return;
		}
		exitPanels.add(exitPanel);
	}
	
	public ParkingSpot getParkingSpot(final Vehicle vehicle) throws ParkingException, InvalidParkingFloorException {
        final Optional<ParkingFloor> parkingFloor = parkingFloors.stream()
                .filter(pF -> pF.canPark(vehicle.getVehicleType()))
                .findFirst();
        System.out.println(parkingFloor.get());
        if (!parkingFloor.isPresent())
            throw new ParkingException("Sorry! Parking is full");
        return parkingFloor.get().getParkingSpot(vehicle);
    }

    public void vacateParkingSpot(final String parkingSpotId) {
        parkingFloors.stream()
                .filter(parkingFloor -> parkingFloor.vacateParkingSpot(parkingSpotId).isPresent())
                .findFirst();
    }
	
}
