package com.initializingbean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LegacyDataConfig implements InitializingBean, DisposableBean {

	String message;

	public String getMessage() {
		return message;
	}
	
	@Autowired
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method after properties are set");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Spring Container is destroy! Customer clean up");
	}

}
