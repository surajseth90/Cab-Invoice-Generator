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
}
