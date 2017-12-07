package com.lienminh69.dao;

import java.util.List;

import com.lienminh69.entity.Employee;

/**
 * @author Thuat T Nguyen
 * @version 2017/12/07
 */
public interface EmployeeUsingHqlDao {
	 public List<Employee> listEmployee();
	 public Integer getMaxDeptId();
}
