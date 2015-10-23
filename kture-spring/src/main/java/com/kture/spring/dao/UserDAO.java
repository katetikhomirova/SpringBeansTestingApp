package com.kture.spring.dao;

import java.util.List;

import com.kture.spring.entity.User;

public interface UserDAO extends DAO<User> {

	User getByEmail(String email);

	List<User> getByName(String name);

}
