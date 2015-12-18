package com.kture.spring.entity;

public class UserRole {

	private long userRoleId;

	private long userId;

	private String username;

	private Role role;

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole(long userId, String username, Role role) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
	}

}
