package com.kture.spring.jdbc.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kture.spring.entity.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User(rs.getString("username"), rs.getString("password"),
				rs.getString("name"), rs.getString("email"),
				rs.getString("phoneNumber"));
		u.setId(rs.getLong("id"));
		return u;
	}

}
