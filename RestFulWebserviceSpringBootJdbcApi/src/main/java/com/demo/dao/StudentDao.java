package com.demo.dao;

import com.demo.entity.Student;

/**
 * 
 * @author Thuat T Nguyen
 * @version 01/28/2018
 *
 */
public interface StudentDao {
	public Student getStudent(final String name);
	public Student getStudent();
}
