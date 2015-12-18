package com.kture.spring.services;

import com.kture.spring.dao.UserRoleDAO;
import com.kture.spring.entity.Role;
import com.kture.spring.entity.UserRole;

public class UserRoleService extends AbstractService<UserRoleDAO> {

	public UserRole createUserRole(long userId, String username, Role role) {

		UserRole userRole = new UserRole(userId, username, role);
		dao.create(userRole);
		return userRole;

	}

}
