package com.kazdo.bank_app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kazdo.bank_app.AppConfig;
import com.kazdo.bank_app.BankAccount;

public class BankAccountTest {
	
	private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			
	private BankAccount bankAccount;
	
	@Before
	public void setup() {
		bankAccount = context.getBean(BankAccount.class); 
	}
	
	@Test
	public void testSuccessAddAmount() {
		assertTrue(bankAccount.add(1000.50));
	}
	
	@Test
	public void testFailedAddAmount() {
		// adding minus amount should be failed
		assertFalse(bankAccount.add(-1000.48));
	}
	
	@Test
	public void testSuccessSubtractAmount() {
		bankAccount.add(10000.78);
		assertTrue(bankAccount.substract(5000.65));
	}
	
	@Test
	public void testFailedSubtractAmount1() {
		bankAccount.add(10000.78);
		
		// subtract minus amount should be failed
		assertFalse(bankAccount.substract(-2350.65));
	}
	
	@Test
	public void testFailedSubtractAmount2() {
		bankAccount.add(100.34);
		
		// subtract amount that greater than the amount in account should be failed. 
		assertFalse(bankAccount.substract(500.33));
	}
	
	@Test
	public void testWorkingAddAmount() {
		bankAccount.add(1000.25);
		bankAccount.add(1000.25);
		
		assertEquals(2000.50, bankAccount.getAmount());
	}
	
	@Test
	public void testWorkingSubtractAmount() {
		bankAccount.add(1200.50);
		bankAccount.substract(1000.25);
		
		assertEquals(200.25, bankAccount.getAmount());
	}
	
	
	
}