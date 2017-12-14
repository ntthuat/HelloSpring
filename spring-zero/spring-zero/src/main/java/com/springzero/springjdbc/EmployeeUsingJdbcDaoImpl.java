package com.springzero.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

/**
 * @author Thuat T Nguyen
 * @version 2017/10/04
 */
@Component("employeeUsingJdbcDao")
public class EmployeeUsingJdbcDaoImpl implements EmployeeUsingJdbcDao{
	
	private JdbcTemplate myJdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return myJdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.myJdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public EmployeeDto getEmployee(final int id) {
		final String sql = "SELECT * FROM employee WHERE id = ?";
		final Object[] args = new Object[]{id};
		final EmployeeMapper mapper = new EmployeeMapper();
		final EmployeeDto employeeDto = myJdbcTemplate.queryForObject(sql, args, mapper);
		return employeeDto;
	}
	
	@Override
	public EmployeeDto getEmployee(final String name, final int id) {
		final String sql = "SELECT * FROM employee WHERE name=? and id = ?";
		final Object[] args = new Object[]{name, id};
		final EmployeeMapper mapper = new EmployeeMapper();
		final EmployeeDto employeeDto;
		try {
			employeeDto = myJdbcTemplate.queryForObject(sql, args, mapper);
		} catch (DataAccessException e) {
			return null;
		}
		
		return employeeDto;
	}
	
	@Override
	public List<EmployeeDto> listEmployee(){
		final String sql = "SELECT id, name FROM employee WHERE 1=1";
		final List<EmployeeDto> list = myJdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeDto>>() {
			
			@Override
			public List<EmployeeDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeDto> employeeList = new ArrayList<>();
				while (rs.next()) {
					EmployeeDto e = new EmployeeDto(rs.getInt("ID"), rs.getString("NAME"));
					employeeList.add(e);
				}
				return employeeList;
			}
		});
	     
		return list;
	}
	
	@Override
	public void saveEmployee(final String name, final int id) {
		final String sql = "INSERT INTO employee (name, id) VALUES(?, ?)";
		myJdbcTemplate.update(sql, name, id);
	}
	
	@Override
	public void deleteEmployee(final String name, final int id) {
		final String sql = "DELETE FROM employee WHERE name=? and id=?";
		myJdbcTemplate.update(sql, name, id);
	}
	
}
