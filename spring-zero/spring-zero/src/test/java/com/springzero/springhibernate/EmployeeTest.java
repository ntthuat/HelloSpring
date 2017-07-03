package com.springzero.springhibernate;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Thuat T Nguyen
 * @version 06/02/2017
 */
public class EmployeeTest {
	
	@Test
	public void test(){
		ApplicationContext appContext =
		    	  new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-locations-using-hql.xml");
	
		EmployeeUsingHqlDaoImpl empl = (EmployeeUsingHqlDaoImpl)appContext.getBean("employeeUsingHqlDao");
		List<Employee> e = empl.listEmployee();
		System.out.println("end");
	}
	
	@Test
	public void test2(){
		ApplicationContext appContext =
		    	  new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-locations-using-hql.xml");
	
		EmployeeUsingHqlDaoImpl empl = (EmployeeUsingHqlDaoImpl)appContext.getBean("employeeUsingHqlDao");
		Integer iii = empl.getMaxDeptId();
		System.out.println("end");
	}
}