package com.lienminh69.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lienminh69.entity.Employee;

/**
 * @author Thuat T Nguyen
 * @version 2017/12/07
 */
public class EmployeeUsingHqlDaoTest {
	
	private ApplicationContext appContext;
	private EmployeeUsingHqlDaoImpl empl;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-locations-using-hql.xml");
		empl = (EmployeeUsingHqlDaoImpl)appContext.getBean("employeeUsingHqlDao");
	}
	
	/**
	 * Cái này test method listEmployee.
	 * 			 |ID     |Name   |
	 * Record 1: |1      |Robert |
	 * Record 2: |2      |Max    |
	 * Record 3: |3      |Thuat  |
	 * Record 4: |4      |Nick   |
	 */
	@Test
	public void testListEmployee(){
		List<Employee> e = empl.listEmployee();
		assertEquals("Robert", e.get(0).getName());
		assertEquals("Max", e.get(1).getName());
		assertEquals("Thuat", e.get(2).getName());
		assertEquals("Nick", e.get(3).getName());
	}
	
	@Test
	public void test2(){
		Integer maxDeptId = empl.getMaxDeptId();
		assertEquals(4, maxDeptId.intValue());
	}
}
