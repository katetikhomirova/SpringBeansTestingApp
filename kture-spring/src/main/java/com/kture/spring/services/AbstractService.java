package com.kture.spring.services;

import org.apache.log4j.Logger;

public abstract class AbstractService<T> {

	public static final Logger log = Logger.getLogger(AbstractService.class);

	T dao;

	public void setDao(T dao) {
		this.dao = dao;
	}	
}
