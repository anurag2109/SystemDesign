package com.LLD.ParkingLot.model.pricing;

import com.LLD.ParkingLot.model.ticket.ParkingTicket;

public interface PricingStrategy {
	double calculateAmountCharged(ParkingTicket parkingTicket);
}
