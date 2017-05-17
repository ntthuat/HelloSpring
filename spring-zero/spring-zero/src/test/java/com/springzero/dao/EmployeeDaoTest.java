package com.springzero.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springzero.dao.EmployeeDao;
import com.springzero.dao.EmployeeDaoImpl;
import com.springzero.entity.EmployeeDto;

/**
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
public class EmployeeDaoTest {
	/**
     * Test thử xem lấy được 1 row trong table employee trong database db_employee không
     */
	@Test
	public void testAppContext() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/appContext.xml");
		EmployeeDao employeeDao = appContext.getBean("employeeDao", EmployeeDaoImpl.class);
		EmployeeDto employeeDto = employeeDao.getEmployee(1);
		assertEquals(1, employeeDto.getId());
		assertEquals("Robert", employeeDto.getName());
		System.out.println("id: "+employeeDto.getId());
		System.out.println("name: "+employeeDto.getName());
		appContext.close();
	}
}
