package com.kazdo.bank_app;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {

	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean add(double amount) {
		if(amount < 0)
			return false;
		else {
			this.amount += amount;
			return true;
		}
	}

	public boolean substract(double amount) {
		if(amount < 0 || amount > this.amount)
			return false;
		else {
			this.amount -= amount;
			return true;
		}
	}

}
