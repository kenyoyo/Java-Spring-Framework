package com.kazdo.bank_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankApp implements BankingSystem {
	@Autowired
	private BankingService bankService;

	@Override
	public void createAccountBySettingUsernameAndPassword(String username, String password)
			throws InterruptedException {
		bankService.createAccountBySettingUsernameAndPassword(username, password);
	}

	@Override
	public void loginBySendingPassword(String password) throws InterruptedException {
		bankService.loginBySendingPassword(password);
	}

	@Override
	public void depositWithAmountOf(double amount) throws InterruptedException {
		bankService.depositWithAmountOf(amount);
	}

	@Override
	public void withdrawWithAmountOf(double amount) throws InterruptedException {
		bankService.withdrawWithAmountOf(amount);
	}

	@Override
	public void tranferToUserWithAmountOf(String userTranfer, double amount) throws InterruptedException {
		bankService.tranferToUserWithAmountOf(userTranfer, amount);
	}

	@Override
	public void viewAmount() throws InterruptedException {
		bankService.viewAmount();
	}

	@Override
	public void viewTransaction() throws InterruptedException {
		bankService.viewTransaction();
	}

	@Override
	public void viewProfile() throws InterruptedException {
		bankService.viewProfile();
	}
}
