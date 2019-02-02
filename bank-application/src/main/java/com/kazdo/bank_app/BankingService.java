package com.kazdo.bank_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankingService implements BankingSystem {
	@Autowired
	private BankAccount bankAccount;
	@Autowired
	private Security secure;
	@Autowired
	private Transaction transaction;
	@Autowired
	private UserAccount userAccount;

	@Override
	public void createAccountBySettingUsernameAndPassword(String username, String password) {
		userAccount.setUsername(username);
		userAccount.setPassword(password);
	}

	@Override
	public void loginBySendingPassword(String password) {
		if (verifyPassword(password)) {
			secure.identify();
			System.out.println("Login success.");
		} else
			System.out.println("Password isn't correct.");
	}

	private boolean verifyPassword(String password) {
		String userPassword = userAccount.getPassword();
		if (userPassword.equals(password))
			return true;
		else
			return false;
	}

	@Override
	public void depositWithAmountOf(double amount) {
		if (isUserLoggedIn())
			checkDepositWithAmountOf(amount);
		else
			System.out.println("Please login.");
	}

	@Override
	public void withdrawWithAmountOf(double amount) {
		if (isUserLoggedIn())
			checkWithdrawWithAmountOf(amount);
		else
			System.out.println("Please login.");
	}

	@Override
	public void tranferToUserWithAmountOf(String userTranfer, double amount) {
		if (isUserLoggedIn())
			checkTranferToUserWithAmountOf(userTranfer, amount);
		else
			System.out.println("Please login.");
	}

	private void checkDepositWithAmountOf(double amount) {
		if (isCanDepositWithAmountOf(amount)) {
			depositingWithAmountOf(amount);
		} else
			System.out.println("Deposit Failed.");
	}

	private void checkWithdrawWithAmountOf(double amount) {
		if (isCanWithdrawOrTranferWithAmountOf(amount)) {
			withdrawingWithAmountOf(amount);
		} else
			System.out.println("Withdraw failed.");
	}

	private void checkTranferToUserWithAmountOf(String userTranfer, double amount) {
		if (isCanWithdrawOrTranferWithAmountOf(amount)) {
			tranferingToUserWithAmountOf(userTranfer, amount);
		} else
			System.out.println("Tranfer failed.");
	}

	private boolean isCanDepositWithAmountOf(double amount) {
		if (bankAccount.isCanAddWithAmount(amount))
			return true;
		else
			return false;
	}

	private boolean isCanWithdrawOrTranferWithAmountOf(double amount) {
		if (bankAccount.isCanSubtractWithAmount(amount))
			return true;
		else
			return false;
	}

	private void depositingWithAmountOf(double amount) {
		bankAccount.addAmount(amount);
		transaction.commitDeposit(amount);
		System.out.println("Deposit success.");
	}

	private void withdrawingWithAmountOf(double amount) {
		bankAccount.substractAmount(amount);
		transaction.commitWithdraw(amount);
		System.out.println("Withdraw success.");
	}

	private void tranferingToUserWithAmountOf(String userTranfer, double amount) {
		bankAccount.substractAmount(amount);
		transaction.commitTranfer(userTranfer, amount);
		System.out.println("Tranfer success.");
	}

	@Override
	public void viewAmount() {
		if (isUserLoggedIn())
			System.out.println("Your current amount is " + bankAccount.getAmount());
		else
			System.out.println("Please login.");

	}

	@Override
	public void viewTransaction() {
		if (isUserLoggedIn())
			checkTransaction();
		else
			System.out.println("Please login.");
	}

	private boolean isUserLoggedIn() {
		if (secure.isLogin())
			return true;
		else
			return false;
	}

	private void checkTransaction() {
		if (isTransactionEmpty())
			System.out.println("You don't have any transaction.");
		else
			displayTransaction();
	}

	private boolean isTransactionEmpty() {
		if (transaction.getSize() <= 0)
			return true;
		else
			return false;
	}

	private void displayTransaction() {
		for (int i = 1; i <= transaction.getSize(); i++) {
			System.out.println(transaction.getInformation(i));
		}
	}
}
