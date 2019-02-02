package com.kazdo.bank_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankApp implements BankingSystem {
	@Autowired
	private BankingService bankService;

	@Override
	public void createAccountBySettingUsernameAndPassword(String username, String password) {
		bankService.createAccountBySettingUsernameAndPassword(username, password);
	}

	@Override
	public void loginBySendingPassword(String password) {
		bankService.loginBySendingPassword(password);
	}

	@Override
	public void depositWithAmountOf(double amount) {
		bankService.depositWithAmountOf(amount);
	}

	@Override
	public void withdrawWithAmountOf(double amount) {
		bankService.withdrawWithAmountOf(amount);
	}

	@Override
	public void tranferToUserWithAmountOf(String usernameTranfer, double amount) {
		bankService.tranferToUserWithAmountOf(usernameTranfer, amount);
	}

	@Override
	public void viewAmount() {
		bankService.viewAmount();
	}

	@Override
	public void viewTransaction() {
		bankService.viewTransaction();
	}
}
