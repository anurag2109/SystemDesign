package com.LLD.ParkingLot.model.parking;
import java.lang.StackWalker.Option;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

import lombok.Getter;

import com.LLD.ParkingLot.exceptions.InvalidParkingFloorException;
import com.LLD.ParkingLot.model.parking.spot.ParkingSpot;
import com.LLD.ParkingLot.model.parking.spot.ParkingSpotType;
import com.LLD.ParkingLot.model.vehicle.Vehicle;
import com.LLD.ParkingLot.model.vehicle.VehicleType;


public class ParkingFloor {
	@Getter
	private final String id;
	private final Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots;
	private final Map<String, ParkingSpot> usedParkingSpots;
	
	public ParkingFloor(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		parkingSpots = new HashMap<>();
		usedParkingSpots = new HashMap<>();
		parkingSpots.put(ParkingSpotType.CAR, new ConcurrentLinkedDeque<>());
		parkingSpots.put(ParkingSpotType.ELECTRIC_CAR, new ConcurrentLinkedDeque<>());
		parkingSpots.put(ParkingSpotType.HANDICAPPED, new ConcurrentLinkedDeque<>());
		parkingSpots.put(ParkingSpotType.LARGE, new ConcurrentLinkedDeque<>());
		parkingSpots.put(ParkingSpotType.MOTORBIKE, new ConcurrentLinkedDeque<>());
	}
	
	public void addParkingSpot(final ParkingSpot parkingSpot) {
		final Optional<ParkingSpot> spot = parkingSpots.get(parkingSpot.getParkingSpotType())
				.stream()
				.filter(ps -> ps.getId().equals(parkingSpot.getId()))
				.findAny();
		if(spot.isPresent()) {
			return;
		}
		parkingSpots.get(parkingSpot.getParkingSpotType()).add(parkingSpot);
	}
	
	public synchronized ParkingSpot getParkingSpot(final Vehicle vehicle) throws InvalidParkingFloorException {
		final ParkingSpotType parkingSpotType = getParkingSpotTypeForVehicle(vehicle.getVehicleType());
		if(!canPark(parkingSpotType)) {
			throw new InvalidParkingFloorException("Can not find the parking spot");
		}
		final ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).poll();
		parkingSpot.assignVehicle(vehicle);
		usedParkingSpots.put(parkingSpot.getId(), parkingSpot);
		return parkingSpot;
	}
	
	public Optional<ParkingSpot> vacateParkingSpot(final String parkingSpotId) {
        final ParkingSpot parkingSpot = usedParkingSpots.get(parkingSpotId);
        if (Objects.nonNull(parkingSpot)) {
            parkingSpot.vacateSpace();
            parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
        }
        return Optional.ofNullable(parkingSpot);
    }
	
	public boolean canPark(final VehicleType vehicleType) {
		return parkingSpots.get(getParkingSpotTypeForVehicle(vehicleType)).size() > 0;
	}
	
	public boolean canPark(final ParkingSpotType parkingSpotType) {
		return parkingSpots.get(parkingSpotType).size() > 0;
	}
	
	private ParkingSpotType getParkingSpotTypeForVehicle(final VehicleType vehicleType) {
		switch (vehicleType) {
		case CAR:
			return ParkingSpotType.CAR;
		case ELECTRIC:
			return ParkingSpotType.ELECTRIC_CAR;
		case MOTORBIKE:
			return ParkingSpotType.MOTORBIKE;
		default:
			return ParkingSpotType.LARGE;
		}
	}
}
