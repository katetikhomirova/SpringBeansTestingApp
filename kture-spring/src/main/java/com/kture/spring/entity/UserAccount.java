package com.kture.spring.entity;

public class UserAccount {

	long id;
	long userId;
	int fund;

	public UserAccount() {
	}

	public UserAccount(long userId, int fund) {
		this.userId = userId;
		this.fund = fund;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getFund() {
		return fund;
	}

	public void setFund(int fund) {
		this.fund = fund;
	}

}
