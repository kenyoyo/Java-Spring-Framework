package com.kazdo.bank_app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionTest {

	private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	private Transaction transaction;

	@Before
	public void setup() {
		transaction = context.getBean(Transaction.class);
	}

	@Test
	public void testCorrectSizeTransaction() {
		transaction.commitDeposit(1000.50);
		transaction.commitWithdraw(500.25);
		transaction.commitTranfer("Ronn", 400.50);
		
		assertEquals(3, transaction.getSize());
	}
	
	@Test
	public void testWorkingTransaction() {
		transaction.commitDeposit(1000.50);
		transaction.commitWithdraw(500.25);
		transaction.commitTranfer("Ronn", 400.50);
		
		for(int i=1; i<=transaction.getSize(); i++) {
			System.out.println(transaction.getInform(i));
		}
	}

}
