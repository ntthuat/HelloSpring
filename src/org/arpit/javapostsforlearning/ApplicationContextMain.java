package org.arpit.javapostsforlearning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Country countryObj = (Country) appContext.getBean("country");
		System.out.println("Capital Name:" + countryObj.getCapitalName("capital"));
	}
}
