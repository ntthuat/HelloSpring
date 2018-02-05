package hello;

import java.util.HashMap;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@ComponentScan({"com.demo.controller", "hello", "com.demo.dao.impl"})
@EnableJSONDoc
public class Application {
	
	private static ApplicationContext appContext;
	
	public static HashMap<Long, Student> hmStudent;

	public static void main(String[] args) {
		setUp();
		hmStudent = new HashMap<Long, Student>();
		Student one = new Student("John", "math");
		hmStudent.put(new Long(one.getId()), one);
		SpringApplication.run(Application.class, args);
		Student two = new Student("Jane", "history");
		hmStudent.put(new Long(two.getId()), two);
	}
	
	public static void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dataaccess-application.xml");
		/*CodixTestController codixTestControllerBean = appContext.getBean("codixTestController", CodixTestController.class);*/
	}
}
