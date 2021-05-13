package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {
	public static final int COST_PER_KILOMETER = 10;
	public static final int COST_PER_MINUTE = 1;
	public static final int MINIMUM_FARE = 5;

	public double calculateTotalFare(double kilometer, int minute) {
		return Math.max(COST_PER_KILOMETER * kilometer + COST_PER_MINUTE * minute, MINIMUM_FARE);
	}

	public InvoiceSummary calculateTotalFare(double[] kilometer, int[] minute) {
		double totalFare = 0;
		int numOfRides =0;
		for (int i = 0; i < minute.length; i++) {
			double cost = COST_PER_KILOMETER * kilometer[i] + COST_PER_MINUTE * minute[i];
			if (cost > MINIMUM_FARE)
				totalFare += cost;
			else
				totalFare += MINIMUM_FARE;
			numOfRides++;
		}
		return new InvoiceSummary(numOfRides, totalFare);
	}
	
	public InvoiceSummary calculateTotalFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += this.calculateTotalFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}