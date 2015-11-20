package com.kture.spring.services;

import java.io.IOException;
import java.util.List;

import com.kture.spring.dao.UserDAO;
import com.kture.spring.entity.User;

public class UserService extends AbstractService<UserDAO> {

	public List<User> getUsers() {
		return dao.getUsers();
	}

	public User createUser(User user) {
		log.info("Create user " + user.toString());
		return dao.create(user);
	}

	public User updateUser(User user) {
		log.info("Update user" + user.toString());
		return dao.update(user);
	}

	public User getUserById(long id) {
		return dao.getById(id);
	}

	public User getUserByEmail(String email) {
		return dao.getByEmail(email);
	}

	public List<User> getUsersByName(String name) {
		return dao.getByName(name);
	}

	public boolean deleteUser(long id) {
		log.info("Remove user with id" + id);
		return dao.delete(id);
	}

	public void commit() {
		dao.commit();
	}

	public void reverse() throws IOException {
		dao.reverse();
	}

}
