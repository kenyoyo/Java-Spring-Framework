package com.kazdo.bank_app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBankApp {
	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankApp mayBankApp = context.getBean(BankApp.class);
		mayBankApp.viewAmount();
		mayBankApp.createAccountBySettingUsernameAndPassword("May", "may123");
		mayBankApp.loginBySendingPassword("may123");
		mayBankApp.viewAmount();
		mayBankApp.viewTransaction();
		mayBankApp.depositWithAmountOf(5000.75);
		Thread.sleep(1000);
		mayBankApp.withdrawWithAmountOf(2000.25);
		Thread.sleep(2000);
		mayBankApp.tranferToUserWithAmountOf("Bruno", 1000);
		mayBankApp.viewProfile();
		mayBankApp.viewTransaction();
		mayBankApp.viewAmount();
	}
}
