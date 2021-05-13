package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {

	public int numOfRides;
	public double totalFare;
	public double averageFare;
	
	public InvoiceSummary(int numOfRides ,double totalFare ) {
		this.numOfRides =numOfRides;
		this.totalFare = totalFare;
		this.averageFare =this.totalFare / this.numOfRides;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if(obj ==null||getClass()!=obj.getClass()) return false;
		InvoiceSummary that =(InvoiceSummary)obj;
		return numOfRides==that.numOfRides &&
				Double.compare(that.totalFare, totalFare)==0 &&
				Double.compare(that.averageFare, averageFare)==0;
	}

	
	
}
