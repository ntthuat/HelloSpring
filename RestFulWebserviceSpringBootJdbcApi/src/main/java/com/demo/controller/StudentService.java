package com.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.StudentDao;
import com.demo.entity.Student;

import hello.Application;

@RestController
@RequestMapping(value="/rest/student")
class StudentService{

	@Autowired
	private StudentDao studentDao;

	/*@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public HashMap<Long, Student> getAllStudents() {
		return Application.hmStudent;
	}*/

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public Student getAllStudents2() {
		return studentDao.getStudent("THUAT");
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public Student getAllStudents3() {
		Student student = new Student();
		student.setId(123);
		student.setName("John");
		student.setSubject("ABC");
		return student;
	}
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public Student getAllStudents4() {
		return studentDao.getStudent("THUAT");
	}
}