package com.bridgelabz.cabinvoicegenerator;

import java.util.HashMap;

public class RideRepository {
	HashMap<Integer, Ride[]> ridesByUserId = new HashMap<>();

	public RideRepository() {
		Ride[] rides1 = { new Ride(5.0, 10, "normal"), new Ride(0.1, 1, "normal") };
		ridesByUserId.put(1, rides1);
		Ride[] rides2 = { new Ride(5.0, 3, "premium"), new Ride(0.1, 1, "premium") };
		ridesByUserId.put(2, rides2);
		Ride[] rides3 = { new Ride(10.0, 10, "normal"), new Ride(0.7, 2, "normal") };
		ridesByUserId.put(3, rides3);
		Ride[] rides4 = { new Ride(9.8, 15, "premium"), new Ride(12.0, 20, "premium") };
		ridesByUserId.put(4, rides4);
		Ride[] rides5 = { new Ride(80.0, 100, "normal"), new Ride(18.2, 40, "normal") };
		ridesByUserId.put(5, rides5);
	}

	public Ride[] getRideList(Integer userId) {
		return ridesByUserId.get(userId);
	}

}
