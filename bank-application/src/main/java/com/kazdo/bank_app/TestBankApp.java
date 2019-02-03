package com.kazdo.bank_app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBankApp {
	private static BankApp userBankAppTesting;

	public static void main(String[] args) throws InterruptedException {
		createUserBankAppTesting();
		testUserAccountSystem();
		testBankAccountSystem();
		testViewInformationSystem();
	}

	private static void testUserAccountSystem() throws InterruptedException {
		testCreateAccountBySettingUsernameAndPassword("May", "may123");
		testLoginBySendingPassword("may123");
	}

	private static void testBankAccountSystem() throws InterruptedException {
		testDepositWithAmountOf(5000.75);
		testWithdrawWithAmountOf(2000.25);
		testTranferToUserWithAmountOf("Bruno", 1000);
	}

	private static void testViewInformationSystem() throws InterruptedException {
		testViewProfile();
		testViewAmount();
		testViewTransaction();
	}

	private static void createUserBankAppTesting() {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		userBankAppTesting = context.getBean(BankApp.class);
	}

	private static void testCreateAccountBySettingUsernameAndPassword(String username, String password)
			throws InterruptedException {
		userBankAppTesting.createAccountBySettingUsernameAndPassword("May", "may123");
	}

	private static void testLoginBySendingPassword(String password) throws InterruptedException {
		userBankAppTesting.loginBySendingPassword(password);
	}

	private static void testDepositWithAmountOf(double amount) throws InterruptedException {
		userBankAppTesting.depositWithAmountOf(amount);
	}

	private static void testWithdrawWithAmountOf(double amount) throws InterruptedException {
		userBankAppTesting.withdrawWithAmountOf(amount);
	}

	private static void testTranferToUserWithAmountOf(String userTranfer, double amount) throws InterruptedException {
		userBankAppTesting.tranferToUserWithAmountOf(userTranfer, amount);
	}

	private static void testViewProfile() throws InterruptedException {
		userBankAppTesting.viewProfile();
	}

	private static void testViewAmount() throws InterruptedException {
		userBankAppTesting.viewAmount();
	}

	private static void testViewTransaction() throws InterruptedException {
		userBankAppTesting.viewTransaction();
	}
}
