package com.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Introducing DataAccessBeans to hold Spring beans that could be possibly
 * access statically.
 * 
 * @author tnthien
 * @version 01/24/2018
 */
@Configuration
public class DataAccessBeans implements InitializingBean {

	/**
	 * Static instance to allow static access. This is initialized when Spring configuration is loaded.
	 */
	private static DataAccessBeans sInstance;
	
	private JdbcTemplate jdbcTemplate;
	
	public static JdbcTemplate getJdbcTemplate() {
		return sInstance.jdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private DataSource myBasicDataSource;
	
	public static DataSource getApplicationDataSource() {
		return sInstance.myBasicDataSource;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		sInstance = this;
	}
	
	public String testBean(){
		return "success";
	}
}
