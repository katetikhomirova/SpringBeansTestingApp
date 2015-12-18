package com.kture.spring.entity;

public class User {

	private long id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phoneNumber;

	public User() {
	}

	public User(String username, String password, String name, String email,
			String phoneNumber) {
		this.username = username;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "{id:" + id + ",name:" + name + ",email:" + email
				+ ",phoneNumber:" + phoneNumber + "}";
	}
}
