package com.springzero.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springzero.entity.EmployeeDto;

/**
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	private JdbcTemplate myJdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return myJdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.myJdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public EmployeeDto getEmployee(int id) {
		EmployeeDto employeeDto = myJdbcTemplate.queryForObject(SQL_GET_EMPLOYEE,new Object[]{id}, new EmployeeMapper());
		return employeeDto;
	}
	
	private final String SQL_GET_EMPLOYEE = "SELECT * FROM employee WHERE id = ?";
}
