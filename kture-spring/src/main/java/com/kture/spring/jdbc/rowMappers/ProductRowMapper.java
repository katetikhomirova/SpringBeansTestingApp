package com.kture.spring.jdbc.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.kture.spring.entity.Product;

public class ProductRowMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p = new Product(rs.getString("title"),
				rs.getString("description"), rs.getInt("price"),
				rs.getInt("userId"));
		p.setId(rs.getLong("id"));
		return p;
	}
}
