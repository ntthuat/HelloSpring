package hello;

import java.util.HashMap;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.controller.CodixTestController;
import com.demo.entity.Student;

/**
 * 
 * @author tnthien
 * @version 01/23/2018
 */
@SpringBootApplication
/*@ComponentScan({"com.demo.controller", "hello", "com.demo.dao.impl", "com.demo.config.properties"})*/
@ComponentScan(basePackages = {"com.demo", "hello"})
/*@EnableJSONDoc*/
/*@EnableConfigurationProperties*/
public class Application extends SpringBootServletInitializer {
	
	/**
	 * Hiện tại phải sử dụng @ComponentScan để start bean.
	 * Tìm hiểu cách để start mà không sử dụng @ComponentScan, nhưng khó quá cần thời gian
	 */
	
	public Application() {
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { Application.class });
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
