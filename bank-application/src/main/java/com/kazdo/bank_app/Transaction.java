package com.kazdo.bank_app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	private List<String> transactions;

	public Transaction() {
		transactions = new ArrayList<>();
	}

	public void commitDeposit(double amount) {
		String depositTransaction = TimeService.getCurrentTime() + " - Deposit: " + amount;
		transactions.add(depositTransaction);
	}

	public void commitTranfer(String userTranfer, double amount) {
		String tranferTransaction = TimeService.getCurrentTime() + " - Tranfer to " + userTranfer + ": " + amount;
		transactions.add(tranferTransaction);
	}

	public void commitWithdraw(double amount) {
		String withdrawTransaction = TimeService.getCurrentTime() + " - Withdraw: " + amount;
		transactions.add(withdrawTransaction);
	}

	public String getInformation(int transactionNumber) {
		return transactions.get(transactionNumber - 1);
	}

	public int getSize() {
		return transactions.size();
	}
}
