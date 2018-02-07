package com.springzero.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
public class Application {
	
	public static void main(String[] args) {
		
		// Phải sử dụng AnnotationConfigApplicationContext để phù hợp với config kiểu annotation (@Configuration)
		ApplicationContext app = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		HelloWorld helloWorld = (HelloWorld) app.getBean("helloWorld");
		helloWorld.print();
		HelloVietnam helloVietnam = (HelloVietnam) app.getBean("helloVietnamBean");
		helloVietnam.xinchao();
	}
}
