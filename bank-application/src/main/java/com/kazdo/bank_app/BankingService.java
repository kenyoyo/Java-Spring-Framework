package com.kazdo.bank_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankingService implements IBankingSystem {

	@Autowired
	private BankAccount bankAccount;
	@Autowired
	private Security secure;
	@Autowired
	private Transaction transaction;
	@Autowired
	private UserAccount userAccount;

	@Override
	public void createAccount(String username, String password) {
		userAccount.setUsername(username);
		userAccount.setPassword(password);
		System.out.println();
	}

	@Override
	public void login(String password) {
		if (userAccount.getPassword().equals(password)) {
			secure.identify();
			System.out.println("Login success.");
		} else
			System.out.println("Password isn't correct.");
	}

	@Override
	public void deposit(double amount) {
		if(!secure.isLogin()) {
			System.out.println("Please login.");
			return;
		}
		
		if (bankAccount.add(amount)) {
			transaction.commitDeposit(amount);
			System.out.println("Deposit success.");
		} else
			System.out.println("Deposit failed.");
	}

	@Override
	public void withdraw(double amount) {
		if(!secure.isLogin()) {
			System.out.println("Please login.");
			return;
		}
		
		if (bankAccount.substract(amount)) {
			transaction.commitWithdraw(amount);
			System.out.println("Withdraw success.");
		} else
			System.out.println("Withdraw failed.");
	}

	@Override
	public void tranfer(String userTranfer, double amount) {
		if(!secure.isLogin()) {
			System.out.println("Please login.");
			return;
		}
		
		if (bankAccount.substract(amount)) {
			transaction.commitTranfer(userTranfer, amount);
			System.out.println("Tranfer success.");
		} else
			System.out.println("Tranfer failed.");
	}

	@Override
	public void viewAmount() {
		if(!secure.isLogin()) {
			System.out.println("Please login.");
			return;
		}
		
		System.out.println("Your current amount is " + bankAccount.getAmount());
	}

	@Override
	public void viewTransaction() {
		if(!secure.isLogin()) {
			System.out.println("Please login.");
			return;
		}
		
		if (transaction.getSize() > 0) {
			for (int i = 1; i <= transaction.getSize(); i++) {
				System.out.println(transaction.getInform(i));
			}
		} else {
			System.out.println("You don't have any transaction.");
		}
	}

}
