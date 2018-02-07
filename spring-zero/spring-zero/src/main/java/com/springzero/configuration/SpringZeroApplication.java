package com.springzero.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
public class SpringZeroApplication {

	public static void main(String[] args) {
		System.out.println("Starting main");
		// Phải sử dụng AnnotationConfigApplicationContext để phù hợp với config kiểu
		// annotation (@Configuration)
		ApplicationContext app = new AnnotationConfigApplicationContext(SpringZeroConfig.class);
		SpringZeroContext springZeroContext = (SpringZeroContext) app.getBean("springZeroContext");
	}
}
