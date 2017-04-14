package com.jdbczero;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
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
}
