package com.springzero.springhibernate;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

public class EmployeeUsingNativeSqlDaoTest {
	private ApplicationContext appContext;
	private EmployeeUsingNativeSqlDaoImpl empl;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-locations-using-hql.xml");
		empl = (EmployeeUsingNativeSqlDaoImpl)appContext.getBean("employeeUsingNativeSqlDao");
	}
	
	/**
	 * Cái này test method listEmployee.<br>
	 * 			 |ID     |Name   |
	 * Record 1: |1      |Robert |
	 * Record 2: |2      |Max    |
	 * Record 3: |3      |Thuat  |
	 * Record 4: |4      |Nick   |
	 */
	@Test
	public void testListEmployee(){
		List<Employee> e = empl.listEmployee();
		Assert.assertEquals("Robert", e.get(0).getName());
		Assert.assertEquals("Max", e.get(1).getName());
		Assert.assertEquals("Thuat", e.get(2).getName());
		Assert.assertEquals("Nick", e.get(3).getName());
	}
	
	/**
	 * Cái này test method conditionEqualBiggerId.<br>
	 * 			 |ID     |Name   |
	 * Record 1: |1      |Robert |
	 * Record 2: |2      |Max    |
	 * Record 3: |3      |Thuat  | <---------- search từ 3 là search từ đây
	 * Record 4: |4      |Nick   |
	 */
	@Test
	public void testConditionEqualBiggerId(){
		List<Employee> e = empl.conditionEqualBiggerId(3);
		Assert.assertEquals("Thuat", e.get(0).getName());
		Assert.assertEquals("Nick", e.get(1).getName());
	}
	
	/**
	 * Cái này test method findId.<br>
	 * 			 |ID     |Name   |
	 * Record 1: |1      |Robert |
	 * Record 2: |2      |Max    | <---------- lấy giá trị ở đây
	 * Record 3: |3      |Thuat  | 
	 * Record 4: |4      |Nick   |
	 */
	@Test
	public void testFindId(){
		Employee e = empl.findId(2);
		Assert.assertEquals("Max", e.getName());
	}
	
	/**
	 * Cái này test method saveEmployee.<br>
	 * 			 |ID     |Name   |
	 * Record 1: |1      |Robert |
	 * Record 2: |2      |Max    | 
	 * Record 3: |3      |Thuat  | 
	 * Record 4: |4      |Nick   |
	 * Record 4: |5      |Hien   | <---------- save giá trị ở đây
	 */
	@Test
	public void testSaveAndDeleteEmployee(){
		// test save employee
		Employee e = new Employee(5, "Hien");
		empl.saveEmployee(e);
		Employee eExpected = empl.findId(5);
		Assert.assertEquals("Hien", eExpected.getName());
		// test delete employee
		empl.deleteEmployeeById(5);
		eExpected = empl.findId(5);
		Assert.assertEquals(null, eExpected);
	}
}
