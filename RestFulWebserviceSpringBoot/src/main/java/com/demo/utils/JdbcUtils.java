package com.demo.utils;


import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.config.DataAccessBeans;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 * 
 */
public class JdbcUtils{
	
	private static JdbcTemplate myJdbcTemplate;
	
	public static int getRowCount(final String schema, final String table) {
		myJdbcTemplate = DataAccessBeans.getJdbcTemplate();
		DataAccessBeans.getApplicationDataSource();
		final String sql = "SELECT COUNT(1) FROM " + schema+ "." + table +" WHERE 1=?";
		int count = myJdbcTemplate.queryForObject(sql, new Object[] {1}, Integer.class);
		return count;
	}
}
