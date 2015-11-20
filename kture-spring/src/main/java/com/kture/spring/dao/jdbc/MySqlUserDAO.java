package com.kture.spring.dao.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.kture.spring.dao.UserDAO;
import com.kture.spring.entity.User;
import com.kture.spring.jdbc.rowMappers.UserRowMapper;
import com.kture.spring.utils.UserQueries;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MySqlUserDAO extends JDBCAbstractDAO implements UserDAO {

	public User create(User item) {
		User user = null;
		if (getJdbcTemplate().update(
				UserQueries.INSERT,
				new Object[] { item.getName(), item.getEmail(),
						item.getPhoneNumber() }) > 0)
			user = getByEmail(item.getEmail());
		return user;
	}

	public User getById(long id) {
		User user = null;
		if (getJdbcTemplate().query(UserQueries.GET_BY_ID, new Object[] { id },
				new BeanPropertyRowMapper(User.class)).size() > 0)
			user = getJdbcTemplate().queryForObject(UserQueries.GET_BY_ID,
					new Object[] { id }, new UserRowMapper());
		return user;
	}

	public User update(User item) {
		User user = null;
		if (getJdbcTemplate().update(
				UserQueries.UPDATE,
				new Object[] { item.getName(), item.getEmail(),
						item.getPhoneNumber(), item.getId() }) > 0)
			user = getById(item.getId());
		return user;
	}

	public boolean delete(long id) {
		if (getJdbcTemplate().update(UserQueries.DELETE, new Object[] { id }) > 0)
			return true;
		return false;
	}

	public User getByEmail(String email) {
		User user = null;
		if (getJdbcTemplate().query(UserQueries.GET_BY_EMAIL,
				new Object[] { email }, new BeanPropertyRowMapper(User.class))
				.size() > 0)
			user = getJdbcTemplate().queryForObject(UserQueries.GET_BY_EMAIL,
					new Object[] { email }, new UserRowMapper());
		return user;
	}

	public List<User> getByName(String name) {
		List<User> res = getJdbcTemplate().query(UserQueries.GET_BY_NAME,
				new Object[] { name }, new BeanPropertyRowMapper(User.class));
		return res;
	}

	public List<User> getUsers() {
		List<User> res = getJdbcTemplate().query(UserQueries.GET_ALL,
				new BeanPropertyRowMapper(User.class));
		return res;
	}
}
