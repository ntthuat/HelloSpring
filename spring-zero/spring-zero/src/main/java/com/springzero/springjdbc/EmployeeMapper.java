package com.springzero.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
public class EmployeeMapper implements RowMapper<EmployeeDto> {
	
	/**
	 * @param rs the ResultSet to map (pre-initialized for the current row)
	 * @param rowNum the number of the current row
	 * @return the result object for the current row
	 */
	@Override
	public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeDto e = new EmployeeDto();
		e.setId(rs.getInt("ID"));
		e.setName(rs.getString("NAME"));
		return e;
	}
}
