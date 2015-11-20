package com.kture.spring.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class JDBCAbstractDAO {

	protected DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
//		try {
//			this.dataSource.getConnection().setAutoCommit(false);
//			System.out.println("AUTOCOMMIT "
//					+ this.dataSource.getConnection().getAutoCommit());
//		} catch (SQLException e) {
//			System.out.println("SQL exception!");
//		}
	}

	public void commit() {
//		try {
//			Connection connection = dataSource.getConnection();
//			connection.setAutoCommit(false);
//			System.out.println("AUTOCOMMIT in COMMIT "
//					+ dataSource.getConnection().getAutoCommit());
//			connection.commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public void reverse() {
//		try {
//			dataSource.getConnection().rollback();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
