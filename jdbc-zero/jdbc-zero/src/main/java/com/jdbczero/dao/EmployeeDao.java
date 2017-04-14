package com.jdbczero.dao;

import com.jdbczero.entity.EmployeeDto;

/**
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
public interface EmployeeDao {
	public EmployeeDto getEmployee(int id);
}
