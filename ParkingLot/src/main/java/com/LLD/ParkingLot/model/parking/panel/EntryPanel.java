package com.LLD.ParkingLot.model.parking.panel;

import java.time.LocalDateTime;
import java.util.UUID;

import com.LLD.ParkingLot.exceptions.InvalidParkingFloorException;
import com.LLD.ParkingLot.exceptions.ParkingException;
import com.LLD.ParkingLot.model.parking.ParkingLot;
import com.LLD.ParkingLot.model.parking.spot.ParkingSpot;
import com.LLD.ParkingLot.model.ticket.ParkingTicket;
import com.LLD.ParkingLot.model.vehicle.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EntryPanel {
	private final String id;
	
	public ParkingTicket getTicket(final Vehicle vehicle) throws ParkingException, InvalidParkingFloorException {
		final ParkingSpot parkingSpot = ParkingLot.INSTANCE.getParkingSpot(vehicle);
		return buildParkingTicket(vehicle.getLicenseNumber(), parkingSpot.getId());
	}
	private ParkingTicket buildParkingTicket(String licenseNumber, String allocatedSpotId) {
        return ParkingTicket.builder()
                .id(UUID.randomUUID().toString())
                .issuedAt(LocalDateTime.now())
                .assignedVehicleId(licenseNumber)
                .assignedSpotId(allocatedSpotId)
                .build();
    }
}
