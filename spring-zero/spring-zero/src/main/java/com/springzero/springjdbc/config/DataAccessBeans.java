package com.springzero.springjdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
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
	
	/** main application DataSource */
	private DataSource applicationDataSource;
	
	public static DataSource getApplicationDataSource() {
		return sInstance.applicationDataSource;
	}
	
	@Autowired(required=false)
	@Qualifier(SpringBeanNamesData.APPLICATION_DATA_SOURCE)
	public void setApplicationDataSource(final DataSource applicationDataSource) {
		this.applicationDataSource = applicationDataSource;
	}
	
	// Cái này cần tìm hiểu kỹ hơn về DataAccessContext
	/** applicationJdbcOperations */
	private NamedParameterJdbcTemplate applicationJdbcOperations;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		sInstance = this;
	}
	
	public String testBean(){
		return "success";
	}

}
