package com.kazdo.bank_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankApp implements IBankingSystem {

	@Autowired
	private BankingService service;

	@Override
	public void createAccount(String username, String password) {
		service.createAccount(username, password);
	}

	@Override
	public void login(String password) {
		service.login(password);
	}

	@Override
	public void deposit(double amount) {
		service.deposit(amount);
	}

	@Override
	public void withdraw(double amount) {
		service.withdraw(amount);
	}

	@Override
	public void tranfer(String usernameTranfer, double amount) {
		service.tranfer(usernameTranfer, amount);
	}

	@Override
	public void viewAmount() {
		service.viewAmount();
	}

	@Override
	public void viewTransaction() {
		service.viewTransaction();
	}

}
