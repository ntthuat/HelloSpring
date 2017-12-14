package com.springzero.springjdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springzero.springjdbc.EmployeeUsingJdbcDaoImpl;
import com.springzero.springjdbc.EmployeeDto;

/**
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
public class EmployeeUsingJdbcDaoTest {
	
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
		EmployeeDto employeeDto = employeeDao.getEmployee(1);
		assertEquals(1, employeeDto.getId());
		assertEquals("Robert", employeeDto.getName());
		
		employeeDto = employeeDao.getEmployee(2);
		assertEquals(2, employeeDto.getId());
		assertEquals("Max", employeeDto.getName());
	}
	
	@Test
	public void testEmployeeJdbcViaNameAndId() {
		EmployeeDto employeeDto = employeeDao.getEmployee("Thuat", 3);
		assertEquals(3, employeeDto.getId());
		assertEquals("Thuat", employeeDto.getName());
		
		employeeDto = employeeDao.getEmployee("Max", 2);
		assertEquals(2, employeeDto.getId());
		assertEquals("Max", employeeDto.getName());
	}
	
	@Test
	public void testListEmployee() {
		List<EmployeeDto> list = employeeDao.listEmployee();
		
		EmployeeDto employeeDto = list.get(0);
		assertEquals(1, employeeDto.getId());
		assertEquals("Robert", employeeDto.getName());
		
		employeeDto = list.get(1);
		assertEquals(2, employeeDto.getId());
		assertEquals("Max", employeeDto.getName());
	}
	
	@Test
	public void testSaveEmployee() {
		employeeDao.saveEmployee("Test", 5);
		
		EmployeeDto employeeDto = employeeDao.getEmployee("Test", 5);
		assertEquals(5, employeeDto.getId());
		assertEquals("Test", employeeDto.getName());
		
		employeeDao.deleteEmployee("Test", 5);
		employeeDto = employeeDao.getEmployee("Test", 5);
		assertNull(employeeDto);
	}
	
	/*@Test
	public void create10000records() {
		for (int i = 1_000_001; i < 1_010_001; i++) {
			System.out.println("("+i+","+"\'S"+i+"E\'"+"),");
		}
	}*/
}
