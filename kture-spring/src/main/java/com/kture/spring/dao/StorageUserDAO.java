package com.kture.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kture.spring.entity.User;

public class StorageUserDAO extends AbstractDAO implements UserDAO {

	public Map<String, User> getUsers() {
		return storage.getUsers();
	}

	@Override
	public long generateId() {
		long max = 0;
		for (User u : storage.getUsers().values()) {
			if (u.getId() > max)
				max = u.getId();
		}
		max++;
		return max;
	}

	public User create(User item) {
		item.setId(generateId());
		storage.getUsers().put(String.valueOf(item.getId()), item);
		return item;
	}

	public User getById(long id) {
		return storage.getUsers().get(String.valueOf(id));
	}

	public User update(User item) {
		storage.getUsers().get(String.valueOf(item.getId()))
				.setName(item.getName());
		storage.getUsers().get(String.valueOf(item.getId()))
				.setEmail(item.getEmail());
		storage.getUsers().get(String.valueOf(item.getId()))
				.setPhoneNumber(item.getPhoneNumber());
		return storage.getUsers().get(String.valueOf(item.getId()));
	}

	public boolean delete(long id) {
		if (storage.getUsers().remove(String.valueOf(id)) != null)
			return true;
		return false;
	}

	public User getByEmail(String email) {
		for (User u : storage.getUsers().values())
			if (u.getEmail().equals(email))
				return u;
		return null;
	}

	public List<User> getByName(String name) {
		List<User> res = new ArrayList<User>();
		for (User u : storage.getUsers().values())
			if (u.getName().equals(name))
				res.add(u);
		return res;
	}

}
