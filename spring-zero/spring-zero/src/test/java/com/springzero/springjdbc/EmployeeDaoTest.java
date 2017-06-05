package com.springzero.springjdbc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springzero.dataaccess.config.DataAccessBeans;
import com.springzero.springjdbc.EmployeeDao;
import com.springzero.springjdbc.EmployeeDaoImpl;
import com.springzero.springjdbc.EmployeeDto;

/**
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
public class EmployeeDaoTest {
	/**
     * Test thử xem lấy được 1 row trong table employee trong database db_employee không.<br>
     */
	@Test
	public void testEmployeeJdbc() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dao-jdbc.xml");
		EmployeeDao employeeDao = appContext.getBean("employeeDao", EmployeeDaoImpl.class);
		DataAccessBeans a = appContext.getBean("dataAccessBeans", DataAccessBeans.class);
		a.testBean();
		EmployeeDto employeeDto = employeeDao.getEmployee(1);
		assertEquals(1, employeeDto.getId());
		assertEquals("Robert", employeeDto.getName());
		System.out.println("id: "+employeeDto.getId());
		System.out.println("name: "+employeeDto.getName());
		appContext.close();
	}
	
}
