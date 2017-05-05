package com.jdbczero.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * File này có tác dụng như config của xml,
 * 
 * @author Thuat T Nguyen
 * @version 04/18/2017
 */
@Component
public class JdbcZeroConfig implements InitializingBean{

	/**
	 * Static instance to allow static access. This is initialized when Spring configuration is loaded.
	 */
	private static JdbcZeroConfig sInstance;
	
	/**
	 * Get bean instance from Spring application context
	 *
	 * @return the bean instance or null if bean is not found
	 */
	public static JdbcZeroConfig getInstance() {
		return sInstance;
	}
	
	/**
	 * Delimiter for qualifier
	 */
	private final char qualifierDelimiter = '/';
	
	public static char getQualifierDelimiter() {
		return sInstance.qualifierDelimiter;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		sInstance = this;
	}

}
