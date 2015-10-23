package com.kture.spring.storage;

import java.util.HashMap;
import java.util.Map;

import com.kture.spring.entity.*;

public class MarketStorage {

	Map<String, User> users;
	Map<String, Product> products;

	public Map<String, User> getUsers() {
		return users;
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public MarketStorage(String storageString) {
		users = new HashMap<String, User>();
		products = new HashMap<String, Product>();
		setStorageFromString(storageString);
	}

	public void setStorageFromString(String storageString) {
		String[] entities = storageString.split(";");
		for (String entitie : entities) {
			entitie = entitie.replaceAll("[\\{\\}]", "");
			String[] splittedEntitie = entitie.split("=");
			if (splittedEntitie[0].equals("user")) {
				User u = new User(splittedEntitie[1]);
				users.put(String.valueOf(u.getId()), u);
			} else if (splittedEntitie[0].equals("product")) {
				Product p = new Product(splittedEntitie[1]);
				products.put(String.valueOf(p.getId()), p);
			}
		}
	}
}
