package com.bridgelabz.cabinvoicegeneratortest;

import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.cabinvoicegenerator.InvoiceService;
import com.bridgelabz.cabinvoicegenerator.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.Ride;
import com.bridgelabz.cabinvoicegenerator.RideRepository;

public class InvoiceServiceTest {
	InvoiceService invoiceService = new InvoiceService();

	@Test
	public void givenDistanceAndTime_ShouldReturnFare() {
		double totalFare = invoiceService.calculateTotalFare(5, 10, "normal");
		Assert.assertEquals(60.0, totalFare, 0.0);
	}

	@Test
	public void givenDistanceAndTime_CalculateFare_WhenLessThanMinimumFare_ShouldReturnMinimumFare() {
		double totalFare = invoiceService.calculateTotalFare(0.1, 2, "normal");
		Assert.assertEquals(5.0, totalFare, 0.0);
	}

	@Test
	public void givenMulipleRidesWithDistanceAndTime_ShouldReturnInvoiceSummary() {
		double[] kilometer = { 5, 0.1 };
		int[] minute = { 10, 2 };
		InvoiceSummary summary = invoiceService.calculateTotalFare(kilometer, minute);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 65);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserID_ShouldReturnInvoiceSummary() {
		Integer userId = 1;
		RideRepository rideRepository = new RideRepository();
		Ride[] rideList = rideRepository.getRideList(userId);
		InvoiceSummary invoiceSummary = invoiceService.calculateTotalFare(rideList);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 65.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	@Test
	public void givenUserID_ByRideType_ShouldReturnInvoiceSummary() {
		Integer userId = 1;
		RideRepository rideRepository = new RideRepository();
		Ride[] rideList = rideRepository.getRideList(userId);
		InvoiceSummary invoiceSummary = invoiceService.calculateTotalFare(rideList);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 65.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
