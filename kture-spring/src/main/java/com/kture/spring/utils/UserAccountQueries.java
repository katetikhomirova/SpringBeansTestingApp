package com.kture.spring.utils;

public class UserAccountQueries {

	public static final String INSERT = "INSERT INTO UserAccounts(userID, fund) VALUES (?,?);";
	public static final String GET_BY_ID = "SELECT * FROM UserAccounts WHERE id=?;";
	public static final String UPDATE = "UPDATE UserAccounts SET userId=?, fund=? WHERE id=?;";
	public static final String DELETE = "DELETE FROM UserAccounts WHERE id=?;";
	public static final String GET_BY_USER_ID = "SELECT * FROM UserAccounts WHERE userId=?;";
	public static final String GET_ALL = "SELECT * FROM UserAccounts;";
	public static final String DELETE_BY_USER_ID = "DELETE FROM UserAccounts WHERE userId=?;";

}
