package com.kazdo.bank_app;

public interface BankingSystem {
	public void createAccountBySettingUsernameAndPassword(String username, String password) throws InterruptedException;

	public void loginBySendingPassword(String password) throws InterruptedException;

	public void depositWithAmountOf(double amount) throws InterruptedException;

	public void withdrawWithAmountOf(double amount) throws InterruptedException;

	public void tranferToUserWithAmountOf(String userTranfer, double amount) throws InterruptedException;

	public void viewAmount() throws InterruptedException;

	public void viewTransaction() throws InterruptedException;

	public void viewProfile() throws InterruptedException;
}
