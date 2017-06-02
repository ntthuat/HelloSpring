package com.springzero;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class này dùng để make sure là các file config không bị lỗi compile.<br>
 * 
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
public class BeanTest {
	/**
     * Chạy file này mà junit test xanh là ok, nghĩa là config appContext.xml không có lỗi compile
     */
	@Test
	public void testAppContext() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/appContext.xml");
		context.close();
	}
	
	@Test
	public void testAppContext2() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-locations-using-hql.xml");
		context.close();
	}
	
	@Test
	public void testAppContext3() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:hibernate/Employee.hbm.xml");
		context.close();
	}
	
	/**
     * Chạy file này mà junit test xanh là ok, nghĩa là config springzero-test-context-program.xml không có lỗi compile
     */
	@Test
	public void testSpringzeroTestContextProgram() {
		/*ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/springzero-test-context-program.xml");
		context.close();*/
		BeanTest b = new BeanTest();
		b.setApplicationName("thuat");
	}
	
	public void setApplicationName(@Value("${qre.core.applicationName:}") final String applicationName) {
		System.out.println(applicationName);
	}
}
