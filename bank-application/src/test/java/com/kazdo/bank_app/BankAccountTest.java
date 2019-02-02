package com.kazdo.bank_app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankAccountTest {

	private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private BankAccount bankAccount;

	@Before
	public void setup() {
		bankAccount = context.getBean(BankAccount.class);
	}

	@Test
	public void testCanAddAmountWithMinusAmount() {
		assertFalse(bankAccount.isCanAddWithAmount(-1000.48));
	}

	@Test
	public void testCanAddAmountWithPositiveAmount() {
		assertTrue(bankAccount.isCanAddWithAmount(1000.50));
	}

	@Test
	public void testCanSubtractAmountWithMinusAmount() {
		assertFalse(bankAccount.isCanSubtractWithAmount((-2350.65)));
	}

	@Test
	public void testCorrectAfterAddAmount() {
		bankAccount.isCanAddWithAmount(1000.25);
		bankAccount.addAmount(1000.25);
		bankAccount.isCanAddWithAmount(1000.25);
		bankAccount.addAmount(1000.25);
		assertEquals(2000.50, bankAccount.getAmount());
	}

	@Test
	public void testCorrectAfterAddAndSubtractAmount() {
		bankAccount.isCanAddWithAmount(1200.50);
		bankAccount.addAmount(1200.50);
		bankAccount.isCanSubtractWithAmount(1000.25);
		bankAccount.substractAmount(1000.25);
		assertEquals(200.25, bankAccount.getAmount());
	}

	@Test
	public void testSubtractAmountWithGreaterThanAmountThatAddingBefore() {
		bankAccount.isCanAddWithAmount(100.34);
		bankAccount.addAmount(100.34);
		assertFalse(bankAccount.isCanSubtractWithAmount(500.33));
	}

	@Test
	public void testSuccessSubtractAmount() {
		bankAccount.isCanAddWithAmount(10000.78);
		bankAccount.addAmount(10000.78);
		assertTrue(bankAccount.isCanSubtractWithAmount(5000.65));
	}

}
