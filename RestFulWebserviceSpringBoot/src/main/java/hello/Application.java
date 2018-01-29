package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author tnthien
 * @version 01/23/2018
 */
@SpringBootApplication
@ComponentScan({"com.demo.controller", "hello", "com.demo.dao.impl", "com.demo.service"})
public class Application {
	
	/*private static ApplicationContext appContext;*/
	
	public static void main(String[] args) {
//		setUp();
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * Load bean definition
	 *//*
	public static void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dataaccess-application.xml");
	}*/
}
