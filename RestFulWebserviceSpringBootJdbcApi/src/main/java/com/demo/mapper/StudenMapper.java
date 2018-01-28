package com.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.entity.Student;

public class StudenMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getLong("id"));
		student.setName(rs.getString("name"));
		student.setSubject(rs.getString("subject"));
		return student;
	}

}
