package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {
	public static final int COST_PER_KM_FOR_NORMAL_RIDES = 10;
	public static final int COST_PER_MINUTE_FOR_NORMAL_RIDES = 1;
	public static final int MINIMUM_FARE_FOR_NORMAL_RIDES = 5;
	public static final int COST_PER_KM_FOR_PREMIUM_RIDES = 15;
	public static final int COST_PER_MINUTE_FOR_PREMIUM_RIDES = 2;
	public static final int MINIMUM_FARE_FOR_PREMIUM_RIDES = 20;

	public double calculateTotalFare(double kilometer, int minute, String rideType) {
		if (rideType.equalsIgnoreCase("Normal"))
			return Math.max(COST_PER_KM_FOR_NORMAL_RIDES * kilometer + COST_PER_MINUTE_FOR_NORMAL_RIDES * minute,
					MINIMUM_FARE_FOR_NORMAL_RIDES);
		else
			return Math.max(COST_PER_KM_FOR_PREMIUM_RIDES * kilometer + COST_PER_MINUTE_FOR_PREMIUM_RIDES * minute,
					MINIMUM_FARE_FOR_PREMIUM_RIDES);

	}

	public InvoiceSummary calculateTotalFare(double[] kilometer, int[] minute) {
		double totalFare = 0;
		int numOfRides = 0;
		for (int i = 0; i < minute.length; i++) {
			double cost = COST_PER_KM_FOR_NORMAL_RIDES * kilometer[i] + COST_PER_MINUTE_FOR_NORMAL_RIDES * minute[i];
			if (cost > MINIMUM_FARE_FOR_NORMAL_RIDES)
				totalFare += cost;
			else
				totalFare += MINIMUM_FARE_FOR_NORMAL_RIDES;
			numOfRides++;
		}
		return new InvoiceSummary(numOfRides, totalFare);
	}

	public InvoiceSummary calculateTotalFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += this.calculateTotalFare(ride.distance, ride.time, ride.rideType);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}