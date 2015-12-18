package com.kture.spring.dao.jdbc;

import com.kture.spring.dao.UserRoleDAO;
import com.kture.spring.entity.UserRole;
import com.kture.spring.utils.UserRoleQueries;

public class MySqlUserRoleDAO extends JDBCAbstractDAO implements UserRoleDAO {

	@Override
	public UserRole create(UserRole item) {
		getJdbcTemplate().update(
				UserRoleQueries.CREATE,
				new Object[] { item.getUserId(), item.getUsername(),
						item.getRole().getValue() });
		return null;
	}

	@Override
	public UserRole getById(long id) {
		return null;
	}

	@Override
	public UserRole update(UserRole item) {
		return null;
	}

	@Override
	public boolean delete(long id) {
		return false;
	}

	@Override
	public void commit() {

	}

	@Override
	public void reverse() {

	}

}
