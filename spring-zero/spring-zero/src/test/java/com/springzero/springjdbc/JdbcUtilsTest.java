package com.springzero.springjdbc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springzero.springjdbc.config.DataAccessBeans;

public class JdbcUtilsTest {
	private ApplicationContext appContext;
	private EmployeeUsingJdbcDaoImpl employeeDao;
	private DataAccessBeans dataAccessBeans;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dao-jdbc.xml");
		employeeDao = (EmployeeUsingJdbcDaoImpl) appContext.getBean("employeeUsingJdbcDao");
		dataAccessBeans = (DataAccessBeans) appContext.getBean("dataAccessBeans");
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
