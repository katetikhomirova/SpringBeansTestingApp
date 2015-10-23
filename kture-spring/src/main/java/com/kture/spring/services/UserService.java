package com.kture.spring.services;

import java.util.ArrayList;
import java.util.List;

import com.kture.spring.dao.StorageUserDAO;
import com.kture.spring.entity.User;

public class UserService extends AbstractService<StorageUserDAO> {

	public List<User> getUsers() {
		List<User> res = new ArrayList<User>();
		for (User u : dao.getUsers().values())
			res.add(u);
		return res;
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

}
