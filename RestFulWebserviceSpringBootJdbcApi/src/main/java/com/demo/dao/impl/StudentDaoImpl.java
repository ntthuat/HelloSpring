package com.demo.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.dao.StudentDao;
import com.demo.entity.Student;
import com.demo.mapper.StudenMapper;

/**
 * 
 * @author Thuat T Nguyen
 * @version 01/28/2018
 *
 */
@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static final StudenMapper mapper = new StudenMapper();

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public Student getStudent() {
		final String sql = "SELECT id, name, subject FROM student WHERE 1=1";
		Map<String, String> argsMap = new HashMap<>();
		final Student student = namedParameterJdbcTemplate.queryForObject(sql, argsMap, mapper);
		return student;
	}
	
	@Override
	public Student getStudent(final String name) {
		StringBuffer selectSql = new StringBuffer();
		selectSql.append("SELECT * FROM ");
		selectSql.append(Student.STUDENT_TABLE);
		selectSql.append(" WHERE 1=1 ");
		selectSql.append(" AND ");
		selectSql.append(" name =  :name");
		
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("name", name);
		
		final Student student = namedParameterJdbcTemplate.queryForObject(selectSql.toString(), argsMap, mapper);
		return student;
	}
}
