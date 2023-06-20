package com.LLD.ParkingLot.model.parking.panel;

import java.time.LocalDateTime;

import com.LLD.ParkingLot.model.parking.ParkingLot;
import com.LLD.ParkingLot.model.pricing.PricingStrategy;
import com.LLD.ParkingLot.model.ticket.ParkingTicket;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExitPanel {
	private final String id;
    private final PricingStrategy pricingStrategy;

    public void scanAndVacate(final ParkingTicket parkingTicket) {
        ParkingLot.INSTANCE.vacateParkingSpot(parkingTicket.getAssignedSpotId());
        parkingTicket.setVacatedAt(LocalDateTime.now());
        parkingTicket.updateAmountCharged(pricingStrategy.calculateAmountCharged(parkingTicket));
    }
}
