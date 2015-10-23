package com.kture.spring.entity;

public class User {

	private long id;
	private String name;
	private String email;
	private String phoneNumber;

	public User(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	// creates user from string
	// e.g. {id:1,name:Jhon,email:11@1,phoneNumber:123}
	public User(String userString) {
		userString = userString.replaceAll("[\\{\\}]", "");
		String[] fields = userString.split(",");
		for (String str : fields) {
			String[] field = str.split(":");
			setField(field[0], field[1]);
		}
	}

	private void setField(String fieldId, String fieldValue)
			throws NumberFormatException {
		if (fieldId.equals("id"))
			this.id = Long.parseLong(fieldValue);
		else if (fieldId.equals("name"))
			this.name = fieldValue;
		else if (fieldId.equals("email"))
			this.email = fieldValue;
		else if (fieldId.equals("phoneNumber"))
			this.phoneNumber = fieldValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
