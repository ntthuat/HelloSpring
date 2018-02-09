package com.demo.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
@Component
@PropertySource("classpath:config/global.properties")
public class GlobalProperties {
	
	@Value("${thread-pool}")
	private int threadPool;
	
	@Value("${email}")
    private String email;

	@Override
	public String toString() {
		return "threadPool: " + threadPool + "\n" +
				"email: " + email;
	}
	
	//getters and setters
}
