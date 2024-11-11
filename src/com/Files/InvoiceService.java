package com.Files;
public class InvoiceService {
	private static final double NORMAL_RATE_PER_KM = 10.0;
	private static final double NORMAL_RATE_PER_MIN = 1.0;
	private static final double NORMAL_MIN_FARE = 5.0;

	private static final double PREMIUM_RATE_PER_KM = 15.0;
	private static final double PREMIUM_RATE_PER_MIN = 2.0;
	private static final double PREMIUM_MIN_FARE = 20.0;

	public double calculateFare(Ride ride, boolean isPremium) {
		double totalFare;
		if (isPremium) {
			totalFare = (ride.getDistance() * PREMIUM_RATE_PER_KM) + (ride.getTime() * PREMIUM_RATE_PER_MIN);
			return Math.max(totalFare, PREMIUM_MIN_FARE);
		} else {
			totalFare = (ride.getDistance() * NORMAL_RATE_PER_KM) + (ride.getTime() * NORMAL_RATE_PER_MIN);
			return Math.max(totalFare, NORMAL_MIN_FARE);
		}
	} public InvoiceSummary calculateFare(Ride[] rides, boolean isPremium) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride, isPremium);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}
