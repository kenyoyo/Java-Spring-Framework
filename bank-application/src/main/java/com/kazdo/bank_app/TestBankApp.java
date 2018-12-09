package com.kazdo.bank_app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBankApp {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankApp mayBankApp = context.getBean(BankApp.class);

		mayBankApp.viewAmount();

		mayBankApp.createAccount("May", "may123");
		mayBankApp.login("may123");
		mayBankApp.viewAmount();
		mayBankApp.viewTransaction();
		mayBankApp.deposit(5000.75);
		mayBankApp.withdraw(2000.25);
		mayBankApp.tranfer("Bruno", 1000);
		mayBankApp.viewTransaction();
	}
	
}