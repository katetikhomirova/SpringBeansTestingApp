package com.kture.spring.jdbc.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kture.spring.entity.UserAccount;

public class UserAccountRowMapper implements RowMapper<UserAccount> {

	public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserAccount account = null;
		account = new UserAccount(rs.getLong("userId"), rs.getInt("fund"));
		account.setId(rs.getLong("id"));
		return account;
	}

}
