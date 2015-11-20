package com.kture.spring.utils;

public class ProductQueries {

	public static final String GET_ALL = "SELECT * FROM Products;";
	public static final String GET_BY_ID = "SELECT * FROM Products WHERE id=?;";
	public static final String GET_BY_USER_ID = "SELECT * FROM Products WHERE userId=?;";
	public static final String GET_BY_TITLE = "SELECT * FROM Products WHERE title=?;";
	public static final String INSERT = "INSERT INTO Products(title, description, price, userId) VALUES (?,?,?,?);";
	public static final String UPDATE = "UPDATE Products SET title=?, description=?, price=?, userId=? WHERE id=?;";
	public static final String DELETE = "DELETE FROM Products where id=?;";

}
