package com.springzero.springhibernate;

import java.util.List;

/**
 * @author Thuat T Nguyen
 * @version 07/13/2017
 */
public interface EmployeeUsingNativeSqlDao {
	public List<Employee> listEmployee();
	public List<Employee> conditionEqualBiggerId(Integer id);
	public Employee findId(Integer id);
	public void saveEmployee(Employee e);
	public void deleteEmployeeById(Integer id);
}
