package com.LLD.ParkingLot.model.ticket;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ParkingTicket {
	private final String id;
	private final LocalDateTime issuedAt;
	
	@Setter
	private LocalDateTime vacatedAt;
	private final String assignedVehicleId;
	private final String assignedSpotId;
	private double charge;
	
	public void updateAmountCharged(double amountCharged) {
		this.charge = amountCharged;
	}

	public ParkingTicket(String id, LocalDateTime issuedAt, LocalDateTime vacatedAt, String assignedVehicleId,
			String assignedSpotId, double charge) {
		super();
		this.id = id;
		this.issuedAt = issuedAt;
		this.vacatedAt = vacatedAt;
		this.assignedVehicleId = assignedVehicleId;
		this.assignedSpotId = assignedSpotId;
		this.charge = charge;
	}
	
}
