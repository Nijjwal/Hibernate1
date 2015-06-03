package com.hibernate.compoundkeytest;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CompoundKey implements Serializable {
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	private int userId;
	private int accountId;
}
