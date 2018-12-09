package com.kazdo.bank_app;

public interface IBankingSystem {
	
	public void createAccount(String username, String password);

	public void login(String password);

	public void deposit(double amount);

	public void withdraw(double amount);

	public void tranfer(String usernameTranfer, double amount);

	public void viewAmount();

	public void viewTransaction();

}
