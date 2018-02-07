package com.springzero.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
@Configuration
public class ApplicationConfiguration {
	
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
	
	@Bean
	public HelloVietnam helloVietnamBean() {
		return new HelloVietnam();
	}
}
