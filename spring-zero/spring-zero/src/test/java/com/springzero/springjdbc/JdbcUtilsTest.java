package com.springzero.springjdbc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcUtilsTest {
	private ApplicationContext appContext;
	private EmployeeUsingJdbcDaoImpl employeeDao;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dao-jdbc.xml");
		employeeDao = (EmployeeUsingJdbcDaoImpl)appContext.getBean("employeeUsingJdbcDao");
	}
	
	
	/**
     * Test thử xem lấy được 1 row trong table employee trong database db_employee không.<br>
     */
	@Test
	public void testEmployeeJdbc() {
		int count = JdbcUtils.getRowCount("db", "employee");
		System.out.println(count);
	}
}
