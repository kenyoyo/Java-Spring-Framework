package com.kazdo.bank_app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	
	private List<String> transactionList;
	
	public Transaction() {
		transactionList = new ArrayList<>();
	}
	
	public void commitDeposit(double amount) {
		String depositTransaction = TimeService.getCurrentTime() + " - Deposit: " + amount;
		transactionList.add(depositTransaction);
	}
	
	public void commitWithdraw(double amount) {
		String withdrawTransaction = TimeService.getCurrentTime() + " - Withdraw: " + amount;
		transactionList.add(withdrawTransaction);
	}
	
	public void commitTranfer(String userTranfer, double amount) {
		String tranferTransaction = TimeService.getCurrentTime() + 
									" - Tranfer to " + userTranfer + 
									": " + amount;
		
		transactionList.add(tranferTransaction);
	}
	
	public String getInform(int transactionNumber) {
		return transactionList.get(transactionNumber-1);
	}
	
	public int getSize() {
		return transactionList.size();
	}
	
}
