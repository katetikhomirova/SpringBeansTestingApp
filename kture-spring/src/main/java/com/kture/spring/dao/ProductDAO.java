package com.kture.spring.dao;

import java.util.List;

import com.kture.spring.entity.Product;

public interface ProductDAO extends DAO<Product> {
	
	List<Product> getByUserId(long id);

	List<Product> getByTitle(String title);
	
}
