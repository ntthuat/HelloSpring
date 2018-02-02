package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author tnthien
 * @version 01/23/2018
 */
@SpringBootApplication
@ComponentScan({"com.demo.controller", "hello", "com.demo.dao.impl", "com.demo.service"})
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
