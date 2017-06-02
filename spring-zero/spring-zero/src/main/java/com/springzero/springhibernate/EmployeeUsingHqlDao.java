package com.springzero.springhibernate;

import java.util.List;

/**
 * @author Thuat T Nguyen
 * @version 06/02/2017
 */
public interface EmployeeUsingHqlDao {
	 public List<Employee> listEmployee() ;
	 public Integer getMaxDeptId();
}
