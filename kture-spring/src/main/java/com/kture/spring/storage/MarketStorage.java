package com.kture.spring.storage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.kture.spring.entity.Product;
import com.kture.spring.entity.User;
import com.kture.spring.utils.CsvFilePaser;

public class MarketStorage implements InitializingBean {

	private Map<String, Object> storage;

	private String userFilePath;
	private String productFilePath;

	private Map<String, User> users;

	private Map<String, Product> products;

	public void setUserFilePath(String userFilePath) {
		this.userFilePath = userFilePath;
	}

	public void setProductFilePath(String productFilePath) {
		this.productFilePath = productFilePath;
	}

	public Map<String, Object> getUsers() {
		Map<String, Object> res = new HashMap<String, Object>();
		for (String str : users.keySet())
			res.put(str, (Object) users.get(str));
		return res;
	}

	public Map<String, Object> getProducts() {
		Map<String, Object> res = new HashMap<String, Object>();
		for (String str : products.keySet())
			res.put(str, (Object) products.get(str));
		return res;
	}

	public MarketStorage() {
		users = new HashMap<String, User>();
		products = new HashMap<String, Product>();
		storage = new HashMap<String, Object>();
	}

	public void afterPropertiesSet() throws Exception {
		users.putAll(CsvFilePaser.parseUsers(userFilePath));
		products.putAll(CsvFilePaser.parseProducts(productFilePath));
		storage.putAll(users);
		storage.putAll(products);
	}

	// commits changes to storage
	public void commit() {
		storage.clear();
		storage.putAll(users);
		storage.putAll(products);
	}

	// reverses storage to previous commit
	public void reverse() throws IOException {
		users.clear();
		users.putAll(CsvFilePaser.parseUsers(userFilePath));
		products.clear();
		products.putAll(CsvFilePaser.parseProducts(productFilePath));
	}

}
