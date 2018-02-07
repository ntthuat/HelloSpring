package com.demo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
@Component
@ConfigurationProperties // no prefix, find root level values.
public class GlobalProperties {
	
	private int threadPool;
    private String email;

	//getters and setters
}
