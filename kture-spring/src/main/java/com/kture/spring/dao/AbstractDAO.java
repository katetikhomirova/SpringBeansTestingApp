package com.kture.spring.dao;

import com.kture.spring.storage.MarketStorage;

public abstract class AbstractDAO {

	MarketStorage storage;

	public void setStorage(MarketStorage storage) {
		this.storage = storage;
	}

	public abstract long generateId();

}
