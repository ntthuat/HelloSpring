package hello;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author tnthien
 * @version 01/23/2018
 */
@SpringBootApplication
@ComponentScan({ "com.demo.controller", "hello", "com.demo.dao.impl", "com.demo.service", "com.demo.model" })
@EnableJSONDoc
public class Application extends SpringBootServletInitializer {

	public Application() {
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { Application.class });
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
