package com.kture.spring.dao;

public interface DAO<T> {

	T create(T item);

	T getById(long id);

	T update(T item);

	boolean delete(long id);

}
