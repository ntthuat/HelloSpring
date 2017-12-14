package com.springzero.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Maximus TTN
 * @version 2017/12/15
 *
 */
public class JdbcUtils {
	
	private static JdbcTemplate myJdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return myJdbcTemplate;
	}

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public static void setJdbcTemplate(DataSource dataSource) {
		myJdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static int getRowCount(final String schema, final String table) {
		final String sql = "SELECT COUNT(1) FROM " + schema+ "." + table +" where id>=?";
		int count = myJdbcTemplate.queryForObject(sql, new Object[] {1}, Integer.class);
		return 0;
	}
}
