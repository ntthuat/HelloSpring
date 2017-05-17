package com.springzero.config;

import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springzero.config.JdbcZeroConfig;

import junit.framework.Assert;

/**
 * TODO: tạm thời chưa làm được, không hiểu tại sao
 * Test cases for JdbcZeroConfig
 * 
 * @author Thuat T Nguyen
 * @version 04/18/2017
 */
@Configuration
@ComponentScan(basePackages = {"com.springzero.config"})
public class JdbcZeroConfigTest {
	
	@Test
	public void testJdbcZeroConfigurationQualifier(){
		// Check if a delimiter is included
		JdbcZeroConfig.getInstance();
		final char configuredDelimiter = JdbcZeroConfig.getQualifierDelimiter();
		Assert.assertEquals('/', configuredDelimiter);
	}
}
