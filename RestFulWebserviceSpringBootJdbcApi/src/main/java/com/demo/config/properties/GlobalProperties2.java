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
@ConfigurationProperties("global")
public class GlobalProperties2 {
	
	private int threadPool;
	
    private String email;

	@Override
	public String toString() {
		return "threadPool: " + threadPool + "\n" +
				"email: " + email;
	}

	public int getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(int threadPool) {
		this.threadPool = threadPool;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
