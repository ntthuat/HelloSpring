package com.springzero.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Thuat T Nguyen
 * @version 2017/10/04
 */
@Component("employeeUsingJdbcDao")
public class EmployeeUsingJdbcDaoImpl implements EmployeeUsingJdbcDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired // Bắt buộc phải bỏ Autowired ở đây, vì datasource là bỏ vào tham số, nên cần vào context bean để kiếm datasouce thích hợp với type để bỏ vào đây
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}
	
	@Autowired
	public void setNamedParameterJdbcTemplate(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public EmployeeDto getEmployee(final int id) {
		final String sql = "SELECT * FROM employee WHERE id = ?";
		final Object[] args = new Object[]{id};
		final EmployeeMapper mapper = new EmployeeMapper();
		final EmployeeDto employeeDto = jdbcTemplate.queryForObject(sql, args, mapper);
		return employeeDto;
	}
	
	@Override
	public EmployeeDto getEmployeeUsingNamedParameterJdbcTemplate(final int id) {
		final String sql = "SELECT * FROM employee WHERE id=:id";
		Map<String, Object> argsMap = new HashMap<>();
		argsMap.put("id", id);
		final EmployeeMapper mapper = new EmployeeMapper();
		final EmployeeDto employeeDto = namedParameterJdbcTemplate.queryForObject(sql, argsMap, mapper);
		return employeeDto;
	}
	
	@Override
	public EmployeeDto getEmployee(final String name, final int id) {
		final String sql = "SELECT * FROM employee WHERE name=? and id = ?";
		final Object[] args = new Object[]{name, id};
		final EmployeeMapper mapper = new EmployeeMapper();
		final EmployeeDto employeeDto;
		try {
			employeeDto = jdbcTemplate.queryForObject(sql, args, mapper);
		} catch (DataAccessException e) {
			return null;
		}
		
		return employeeDto;
	}
	
	@Override
	public EmployeeDto getEmployeeUsingNamedParameterJdbcTemplate(final String name, final int id) {
		final String sql = "SELECT * FROM employee WHERE name=:name and id=:id";
		Map<String, Object> argsMap = new HashMap<>();
		argsMap.put("name", name);
		argsMap.put("id", id);
		final EmployeeMapper mapper = new EmployeeMapper();
		final EmployeeDto employeeDto = namedParameterJdbcTemplate.queryForObject(sql, argsMap, mapper);
		return employeeDto;
	}
	
	@Override
	public List<EmployeeDto> listEmployee(){
		final String sql = "SELECT id, name FROM employee WHERE 1=1";
		final List<EmployeeDto> list = jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeDto>>() {
			
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
		jdbcTemplate.update(sql, name, id);
	}
	
	@Override
	public void deleteEmployee(final String name, final int id) {
		final String sql = "DELETE FROM employee WHERE name=? and id=?";
		jdbcTemplate.update(sql, name, id);
	}
	
	@Override
	public int getRowCountEmployee(){
		final String sql = "SELECT COUNT(1) FROM employee WHERE 1=?";
		final int count = jdbcTemplate.queryForObject(
                sql, new Object[] {1}, Integer.class);
		return count;
	}
	
}
