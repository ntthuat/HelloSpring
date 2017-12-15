package com.springzero.springjdbc;

import java.util.List;

/**
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
public interface EmployeeUsingJdbcDao {
	
	public EmployeeDto getEmployee(final int id);
	
	public EmployeeDto getEmployee(final String name,final int id);
	
	public List<EmployeeDto> listEmployee();
	
	public void saveEmployee(final String name, final int id);
	
	public void deleteEmployee(final String name, final int id);
}
