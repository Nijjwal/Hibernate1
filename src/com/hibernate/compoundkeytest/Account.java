package com.hibernate.compoundkeytest;

import javax.persistence.Entity;

import javax.persistence.Id;


@Entity
public class Account {

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Id
	public CompoundKey getCompoundKey() {
		return compoundKey;
	}

	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}

	private int accountBalance;
	private CompoundKey compoundKey;

}
