package com.kazdo.bank_app;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {
	private double amount;

	public BankAccount() {
		amount = 0;
	}

	public void addAmount(double amount) {
		this.amount += amount;
	}

	public void substractAmount(double amount) {
		this.amount -= amount;
	}

	public boolean isCanAddWithAmount(double amount) {
		if (amount > 0)
			return true;
		else
			return false;
	}

	public boolean isCanSubtractWithAmount(double amount) {
		if (amount > 0 && this.amount > amount)
			return true;
		else
			return false;
	}

	public double getAmount() {
		return amount;
	}
}
