package com.springzero.dataaccess.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This config class holds the objects to access the transaction manager and classes to perform jdbc operations.
 * 
 * @author Thuat T Nguyen
 * @version 06/06/2017
 */
@Component
public class DataAccessConfig implements InitializingBean{

	/**
	 * Static instance to allow static access. This is initialised when Spring configuration is loaded.
	 */
	private static DataAccessConfig sInstance;
	
	/**
	 * DB schema name used by transformed application. If multiple schema might be used, then it's default schema.
	 */
	private String schema4ApplicationUsage;
	
	public static String getSchema4ApplicationUsage() {
		return getInstance().schema4ApplicationUsage;
	}
	
	public static DataAccessConfig getInstance() {
		return sInstance;
	}
	
	public static boolean isUsingApplicationSchema() {
		return getInstance().schema4ApplicationUsage != null && getInstance().schema4ApplicationUsage.length() > 0;
	}
	
	@Autowired
	public void setSchema4ApplicationUsage(@Value("${zero.schema.application}") final String schema4ApplicationUsage) {
		this.schema4ApplicationUsage = schema4ApplicationUsage.trim().toUpperCase();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		sInstance = this;
		/*Configurations.logger.info("{} --- \n {}", getClass().getSimpleName(), ReflectionUtils.toString(this));*/
	}

}
