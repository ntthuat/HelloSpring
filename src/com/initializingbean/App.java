package com.initializingbean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main( String[] args )
    {
    	ConfigurableApplicationContext context =
			new ClassPathXmlApplicationContext("Spring-Customer.xml");

    	LegacyDataConfig legacy = (LegacyDataConfig)context.getBean("legacyDataConfig");

    	System.out.println(legacy.message);

    	context.close();
    }
}
