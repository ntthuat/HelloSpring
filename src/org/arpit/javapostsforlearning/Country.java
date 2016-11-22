package org.arpit.javapostsforlearning;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Country implements ApplicationContextAware {

	String countryName;
	ApplicationContext applicationContext;
	Capital capital;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public String getCapitalName(String capitalBeanName) {
		capital = (Capital) applicationContext.getBean(capitalBeanName);
		String capitalName = capital.getCapitalName();
		return capitalName;
	}
}
