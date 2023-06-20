package com.LLD.ParkingLot.model.pricing;

import java.time.Duration;

import com.LLD.ParkingLot.model.ticket.ParkingTicket;

public class HourlyPricing implements PricingStrategy {

	private static final double PRICE_PER_HOUR = 1.0;
	@Override
	public double calculateAmountCharged(ParkingTicket parkingTicket) {
		// TODO Auto-generated method stub
		final long hoursParked = Duration.between(parkingTicket.getIssuedAt(), parkingTicket.getVacatedAt()).toHours();
		return PRICE_PER_HOUR + hoursParked > 0 ? (hoursParked - 1) * PRICE_PER_HOUR : 0;
		
	}

}
