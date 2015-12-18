package com.kture.spring.utils;

public class UserQueries {

	public static final String GET_ALL = "SELECT * FROM Users;";
	public static final String GET_BY_NAME = "SELECT * FROM Users WHERE name = ?;";
	public static final String GET_BY_ID = "SELECT * FROM Users WHERE id = ?;";
	public static final String GET_BY_EMAIL = "SELECT * FROM Users WHERE email = ?;";
	public static final String INSERT = "INSERT INTO Users (username, password, name, email, phoneNumber) VALUES (?, ?, ?,?,?);";
	public static final String UPDATE = "UPDATE Users SET name=?, email=?, phoneNumber=? WHERE id=?;";
	public static final String DELETE = "DELETE FROM Users WHERE id=?;";
	public static final String GET_BY_USERNAME = "SELECT * FROM Users WHERE username=?";

}
