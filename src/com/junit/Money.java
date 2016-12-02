package com.junit;

public class Money {

	private double amount;
	private String currency;

	public Money(double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public Money add(Money money){
		Money m = new Money(money.amount+amount, currency);
		return m;
	}
}
