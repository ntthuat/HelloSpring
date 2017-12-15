package com.lienminh69.dao;

import java.util.List;

import com.lienminh69.entity.Employee;

/**
 * @author Maximus TTN
 * @version 2017/12/07
 */
public interface EmployeeUsingHqlDao {
	
	 public List<Employee> listEmployee();
	 public List<Employee> listEmployeeUsingCriteria();
	 
	 public Integer getMaxEmployeetId();
	 public Integer getMaxEmployeeIdUsingCriteria();
	 
	 public Employee findEmployeeByName(final String name);
	 
	 public int deleteEmployeeByName(final String name);
	 
	 public void saveEmployee(final Employee employee);
	 
	 public int updateNameEmploye(final String name, final String updatedName);
	 
	 public Employee getEmployeeUsingSessionGetViaId(final int id);
	 public Employee getEmployeeUsingSessionLoadViaId(final int id);
}
