package com.kture.spring.dao.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.kture.spring.dao.ProductDAO;
import com.kture.spring.entity.Product;
import com.kture.spring.jdbc.rowMappers.ProductRowMapper;
import com.kture.spring.utils.ProductQueries;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MySqlProductDAO extends JDBCAbstractDAO implements ProductDAO {

	public Product create(Product item) {
		Product product = null;
		if (getJdbcTemplate().update(
				ProductQueries.INSERT,
				new Object[] { item.getTitle(), item.getDescription(),
						item.getPrice(), item.getUserId() }) > 0)
			product = item;
		return product;
	}

	public Product getById(long id) {
		Product product = null;
		if (getJdbcTemplate().query(ProductQueries.GET_BY_ID,
				new Object[] { id }, new BeanPropertyRowMapper(Product.class))
				.size() > 0) {
			product = getJdbcTemplate().queryForObject(
					ProductQueries.GET_BY_ID, new Object[] { id },
					new ProductRowMapper());
		}
		return product;
	}

	public Product update(Product item) {
		Product product = null;
		if (getJdbcTemplate().update(
				ProductQueries.UPDATE,
				new Object[] { item.getTitle(), item.getDescription(),
						item.getPrice(), item.getUserId(), item.getId() }) > 0)
			product = getById(item.getId());
		return product;
	}

	public boolean delete(long id) {
		if (getJdbcTemplate()
				.update(ProductQueries.DELETE, new Object[] { id }) > 0)
			return true;
		return false;
	}

	public List<Product> getByUserId(long id) {
		List<Product> res = getJdbcTemplate().query(
				ProductQueries.GET_BY_USER_ID, new Object[] { id },
				new BeanPropertyRowMapper(Product.class));
		return res;
	}

	public List<Product> getByTitle(String title) {
		List<Product> res = getJdbcTemplate().query(
				ProductQueries.GET_BY_TITLE, new Object[] { title },
				new BeanPropertyRowMapper(Product.class));
		return res;
	}

	public List<Product> getProducts() {
		List<Product> res = getJdbcTemplate().query(ProductQueries.GET_ALL,
				new BeanPropertyRowMapper(Product.class));
		return res;
	}

}
