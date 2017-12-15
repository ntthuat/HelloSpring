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
	private EmployeeUsingHqlDaoImpl employeeDao;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-locations-using-hql.xml");
		employeeDao = (EmployeeUsingHqlDaoImpl)appContext.getBean("employeeUsingHqlDao");
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
		List<Employee> e = employeeDao.listEmployee();
		assertEquals("Robert", e.get(0).getName());
		assertEquals("Max", e.get(1).getName());
		assertEquals("Thuat", e.get(2).getName());
		assertEquals("Nick", e.get(3).getName());
	}
	
	@Test
	public void testListEmployeeUsingCriteria(){
		List<Employee> e = employeeDao.listEmployeeUsingCriteria();
		assertEquals("Robert", e.get(0).getName());
		assertEquals("Max", e.get(1).getName());
		assertEquals("Thuat", e.get(2).getName());
		assertEquals("Nick", e.get(3).getName());
	}
	
	@Test
	public void testGetMaxEmployeeId(){
		Integer maxEmployeetId = employeeDao.getMaxEmployeetId();
		assertEquals(4, maxEmployeetId.intValue());
	}
	
	@Test
	public void testGetMaxEmployeeIdUsingCriteria(){
		Integer maxEmployeetId = employeeDao.getMaxEmployeeIdUsingCriteria();
		assertEquals(4, maxEmployeetId.intValue());
	}
	
	@Test
	public void testFindEmployeeByName(){
		Employee employee = employeeDao.findEmployeeByName("Thuat");
		assertEquals(3, employee.getId());
		assertEquals("Thuat", employee.getName());
	}
	
	@Test
	public void testDeleteEmployeeByName(){
		// Backup before deleting
		Employee employeeBak = employeeDao.findEmployeeByName("Thuat");
		
		int result = employeeDao.deleteEmployeeByName("Thuat");
		assertEquals(1, result);
		Employee employee = employeeDao.findEmployeeByName("Thuat");
		assertNull(employee);
		
		// Create after deleting
		employeeDao.saveEmployee(employeeBak);
		employee = employeeDao.findEmployeeByName("Thuat");
		assertNotNull(employee);
	}
	
	@Test
	public void testSaveEmployee(){
		Employee e = new Employee(5, "Test");
		employeeDao.saveEmployee(e);
		Employee employee = employeeDao.findEmployeeByName("Test");
		assertNotNull(employee);
		
		// Delete after saving
		int result = employeeDao.deleteEmployeeByName("Test");
		assertEquals(1, result);
		employee = employeeDao.findEmployeeByName("Test");
		assertNull(employee);
	}
	
	@Test
	public void testUpdateNameEmployee(){
		int result = employeeDao.updateNameEmploye("Thuat", "ThuatTest");
		assertEquals(1, result);
		
		result = employeeDao.updateNameEmploye("ThuatTest", "Thuat");
		assertEquals(1, result);
	}
	
	@Test
	public void testGetEmployeeUsingSessionGetViaId(){
		Employee e = employeeDao.getEmployeeUsingSessionGetViaId(2);
		assertEquals(2, e.getId());
		assertEquals("Max", e.getName());
	}
}
