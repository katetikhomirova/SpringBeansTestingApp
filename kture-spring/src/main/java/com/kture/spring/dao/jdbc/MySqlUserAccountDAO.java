package com.kture.spring.dao.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.kture.spring.dao.UserAccountDAO;
import com.kture.spring.entity.UserAccount;
import com.kture.spring.jdbc.rowMappers.UserAccountRowMapper;
import com.kture.spring.utils.UserAccountQueries;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MySqlUserAccountDAO extends JDBCAbstractDAO implements
		UserAccountDAO {

	public UserAccount create(UserAccount item) {
		UserAccount account = null;
		if (getJdbcTemplate().update(UserAccountQueries.INSERT,
				new Object[] { item.getUserId(), item.getFund() }) > 0)
			account = item;
		return account;
	}

	public UserAccount getById(long id) {
		UserAccount account = null;
		if (getJdbcTemplate().query(UserAccountQueries.GET_BY_ID,
				new Object[] { id },
				new BeanPropertyRowMapper(UserAccount.class)).size() > 0)
			account = getJdbcTemplate().queryForObject(
					UserAccountQueries.GET_BY_ID, new Object[] { id },
					new UserAccountRowMapper());
		return account;
	}

	public UserAccount update(UserAccount item) {
		UserAccount account = null;
		if (getJdbcTemplate()
				.update(UserAccountQueries.UPDATE,
						new Object[] { item.getUserId(), item.getFund(),
								item.getId() }) > 0)
			account = getById(item.getId());
		return account;
	}

	public boolean delete(long id) {
		if (getJdbcTemplate().update(UserAccountQueries.DELETE_BY_USER_ID,
				new Object[] { id }) > 0)
			return true;
		return false;
	}

	public UserAccount getByUserId(long id) {
		UserAccount account = null;
		if (getJdbcTemplate().query(UserAccountQueries.GET_BY_USER_ID,
				new Object[] { id },
				new BeanPropertyRowMapper(UserAccount.class)).size() > 0)
			account = getJdbcTemplate().queryForObject(
					UserAccountQueries.GET_BY_USER_ID, new Object[] { id },
					new UserAccountRowMapper());
		return account;
	}

	public List<UserAccount> getUserAccounts() {
		List<UserAccount> res = getJdbcTemplate().query(
				UserAccountQueries.GET_ALL,
				new BeanPropertyRowMapper(UserAccount.class));
		return res;
	}

}
