package com.bridgelabz.cabinvoicegeneratortest;

import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.cabinvoicegenerator.InvoiceService;

public class InvoiceServiceTest {
	
	@Test
	public void givenDistanceAndTime_ShouldReturnFare() {
		InvoiceService invoiceService = new InvoiceService();
		double totalFare = invoiceService.calculateTotalFare(5, 10);
		Assert.assertEquals(60.0, totalFare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTime_CalculateFare_WhenLessThanMinimumFare_ShouldReturnMinimumFare() {
		InvoiceService invoiceService = new InvoiceService();
		double totalFare = invoiceService.calculateTotalFare(0.1, 2);
		Assert.assertEquals(5.0, totalFare, 0.0);
	}
	
	@Test
	public void givenMulipleRidesWithDistanceAndTime_ShouldReturnTotalInvoice() {
		InvoiceService invoiceService = new InvoiceService();
		double [] kilometer = {5,0.1};
		int [] minute = {10,2};
		double totalFare = invoiceService.calculateTotalFare(kilometer, minute);
		Assert.assertEquals(65.0, totalFare, 0.0);
	}
	
}
