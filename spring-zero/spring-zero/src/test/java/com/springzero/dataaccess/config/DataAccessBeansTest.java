package com.springzero.dataaccess.config;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class này để test cho DataAccessBeans class
 * 
 * @author Thuat T Nguyen
 * @version 06/05/2017
 */
public class DataAccessBeansTest {
	
	/**
     * Test thử việc tạo bean bằng
     */
	@Test
	public void testDataAccessBeans() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dao-jdbc.xml");
		DataAccessBeans a = appContext.getBean("dataAccessBeans", DataAccessBeans.class);
		assertEquals("success", a.testBean());
		appContext.close();
	}
	
	@Test
	public void testGetDatasource(){
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dao-jdbc.xml");
		DataAccessBeans dataAccess = appContext.getBean("dataAccessBeans", DataAccessBeans.class);
		
		DataSource dataSource = dataAccess.getApplicationDataSource();
		System.out.println(dataSource.toString());
	}
}
