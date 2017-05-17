package com.jdbczero.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbczero.entity.EmployeeDto;

public class EmployeeMapper implements RowMapper<EmployeeDto> {
	public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeDto e = new EmployeeDto();
		e.setId(rs.getInt("ID"));
		e.setName(rs.getString("NAME"));
		return e;
	}
}
