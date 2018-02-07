package com.springzero.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
@Configuration
public class SpringZeroConfig {
	
	@Bean
	public SpringZeroContext springZeroContext(DataSource dataSource) {
		SpringZeroContext.init(dataSource);
		return SpringZeroContext.getContext();
	}
}
