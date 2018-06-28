package com.vogella.jersey.first;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class account {
	//
	private int accountID;
	private String accountType;
	private Date creationDate;
	private double balance;
	//
	public account() {
		// TODO Auto-generated constructor stub
	}

	public account(int accountID, String accountType, Date creationDate,
			double balance) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.creationDate = creationDate;
		this.balance = balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "account [accountID=" + accountID + ", accoutType" + accountType +", creationDate=" + creationDate + ", balance=" + balance
				+ "]";
	}

}
