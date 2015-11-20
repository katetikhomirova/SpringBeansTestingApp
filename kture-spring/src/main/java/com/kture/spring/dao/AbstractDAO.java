package com.kture.spring.dao;

import java.io.IOException;

import com.kture.spring.storage.MarketStorage;

public abstract class AbstractDAO {

	MarketStorage storage;

	public void setStorage(MarketStorage storage) {
		this.storage = storage;
	}

	public abstract long generateId();

	public void commit() {
		storage.commit();
	}

	public void reverse() {
		try {
			storage.reverse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
