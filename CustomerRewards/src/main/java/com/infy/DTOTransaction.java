package com.infy;

public class DTOTransaction {
	
	

	private int customerId;
	private double amount;
	private String date;
	
	 DTOTransaction() {
		
	}
	 
	 public DTOTransaction(int customerId, double amount, String date) {
			super();
			this.customerId = customerId;
			this.amount = amount;
			this.date = date;
		}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	 
	 
	 
	 

}
