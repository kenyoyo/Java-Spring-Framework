package com.kazdo.bank_app;

public interface BankingSystem {
	public void createAccountBySettingUsernameAndPassword(String username, String password);

	public void loginBySendingPassword(String password);

	public void depositWithAmountOf(double amount);

	public void withdrawWithAmountOf(double amount);

	public void tranferToUserWithAmountOf(String usernameTranfer, double amount);

	public void viewAmount();

	public void viewTransaction();

	public void viewProfile();
}
