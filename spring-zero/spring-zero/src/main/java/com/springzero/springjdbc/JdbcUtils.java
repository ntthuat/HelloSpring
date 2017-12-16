package com.springzero.springjdbc;


import org.springframework.jdbc.core.JdbcTemplate;

import com.springzero.springjdbc.config.DataAccessBeans;

/**
 * 
 * @author Maximus TTN
 * @version 2017/12/15
 *
 */
public class JdbcUtils{
	
	private static JdbcTemplate myJdbcTemplate;
	
	public static int getRowCount(final String schema, final String table) {
		myJdbcTemplate = DataAccessBeans.getJdbcTemplate();
		DataAccessBeans.getApplicationDataSource();
		final String sql = "SELECT COUNT(1) FROM " + schema+ "." + table +" where id>=?";
		int count = myJdbcTemplate.queryForObject(sql, new Object[] {1}, Integer.class);
		return count;
	}
}
