package com.springzero.springjdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.springzero.dataaccess.beans.SpringBeanNamesData;

/**
 * Introducing DataAccessBeans to hold Spring beans that could be possibly access statically. <br>
 * These beans were carried in DataAccessConfig, but it makes more sense to split into two separate classes. There is
 * potential problem with bean configuration in case DataAccessConfig is depended by a bean carried in itself.
 * 
 * @author Thuat T Nguyen
 * @version 06/05/2017
 */
@Component("dataAccessBeans")
@DependsOn(SpringBeanNamesData.DATA_ACCESS_CONFIG)
public class DataAccessBeans implements InitializingBean {

	/**
	 * Static instance to allow static access. This is initialized when Spring configuration is loaded.
	 */
	private static DataAccessBeans sInstance;
	
	private JdbcTemplate jdbcTemplate;
	
	public static JdbcTemplate getJdbcTemplate() {
		return sInstance.jdbcTemplate;
	}
	
	@Autowired // Bắt buộc phải bỏ Autowired ở đây, vì datasource là bỏ vào tham số, nên cần vào context bean để kiếm datasouce thích hợp với type để bỏ vào đây
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
