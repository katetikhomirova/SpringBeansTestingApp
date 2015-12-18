package com.kture.spring.dao;

import java.util.ArrayList;
import java.util.List;

import com.kture.spring.entity.User;

public class StorageUserDAO extends AbstractDAO implements UserDAO {

	public List<User> getUsers() {
		List<User> res = new ArrayList<User>();
		for (String str : storage.getUsers().keySet()) {
			res.add((User) storage.getUsers().get(str));
		}
		return res;
	}

	@Override
	public long generateId() {
		long max = 0;
		for (User u : getUsers()) {
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
		return (User) storage.getUsers().get("user:" + String.valueOf(id));
	}

	public User update(User item) {
		if (item != null) {
			((User) storage.getUsers().get(
					"user:" + String.valueOf(item.getId()))).setName(item
					.getName());
			((User) storage.getUsers().get(
					"user:" + String.valueOf(item.getId()))).setEmail(item
					.getEmail());
			((User) storage.getUsers().get(
					"user:" + String.valueOf(item.getId())))
					.setPhoneNumber(item.getPhoneNumber());
		}
		return (User) storage.getUsers().get(
				"user:" + String.valueOf(item.getId()));
	}

	public boolean delete(long id) {
		if (storage.getUsers().remove("user:" + String.valueOf(id)) != null)
			return true;
		return false;
	}

	public User getByEmail(String email) {
		for (User u : getUsers())
			if (u.getEmail().equals(email))
				return u;
		return null;
	}

	public List<User> getByName(String name) {
		List<User> res = new ArrayList<User>();
		for (User u : getUsers())
			if (u.getName().equals(name))
				res.add(u);
		return res;
	}

	@Override
	public User getByUsername(String username) {
		return null;
	}

}
