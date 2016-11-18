package com.autowired.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		// Gọi khung chứa của Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
 
        Room room = (Room) context.getBean("room");
        room.spellCheck();
        System.out.println(room.getTable().getCode());
	}
}
