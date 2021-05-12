package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {
	public static final int COST_PER_KILOMETER = 10;
	public static final int COST_PER_MINUTE = 1;

	public double calculateTotalFare(double kilometer, int minute) {
		return COST_PER_KILOMETER * kilometer + COST_PER_MINUTE * minute;

	}

}
