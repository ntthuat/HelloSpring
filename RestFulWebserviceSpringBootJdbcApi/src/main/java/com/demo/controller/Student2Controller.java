package com.demo.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;

/**
 * @author tnthien
 * @version 01/23/2018
 */
@RestController
@RequestMapping(value = "/rest/student2")
public class Student2Controller {

	public static HashMap<Long, Student> hmStudent;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HashMap<Long, Student> getAllStudents() {
		hmStudent = new HashMap<Long, Student>();
		Student student1 = new Student(101, "John", "Math");
		Student student2 = new Student(102, "Jane", "History");
		hmStudent.put(student1.getId(), student1);
		hmStudent.put(student2.getId(), student2);
		return hmStudent;
	}
}
