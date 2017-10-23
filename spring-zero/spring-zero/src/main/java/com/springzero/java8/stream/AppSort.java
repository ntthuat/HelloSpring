package com.springzero.java8.stream;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author tnguyen443
 * @version 10/23/2017
 */
public class AppSort {
	
	private static List<Student> students = new ArrayList<>();
	
	public static void setUp(){
		students.add(new Student(1L, "Long", "Nguyen", Gender.MALE, LocalDate.of(1992, Month.JANUARY, 20)));
	    students.add(new Student(3L, "Phong", "Nguyen", Gender.MALE, LocalDate.of(1990, Month.AUGUST, 1)));
	    students.add(new Student(2L, "Lan", "Do", Gender.FEMALE, LocalDate.of(1993, Month.OCTOBER, 10)));
	    students.add(new Student(6L, "Ngoc", "Le", Gender.FEMALE, LocalDate.of(1992, Month.SEPTEMBER, 26)));
	    students.add(new Student(5L, "Ngan", "Nguyen", Gender.FEMALE, LocalDate.of(1992, Month.JANUARY, 3)));
	}
	
	public static void main(String[] args) {
		// set up
		setUp();
		
		// Sử dụng stream().sorted để sắp xếp lại
		List<Student> idStudent = students.stream().sorted((st1, st2) -> st1.getId().compareTo(st2.getId()))
		.collect(Collectors.toList());
		
		// In ra màn hình list đã sắp xếp
		idStudent.stream().forEach(System.out::println);
		
		System.out.println("=================================");
		
		// Multiple sorting
		Comparator<Student> byFistName = (st1, st2) -> st1.getFirstName().compareTo(st2.getFirstName());
		Comparator<Student> byLastName = (st1, st2) -> st1.getLastName().compareTo(st2.getLastName());
		
		List<Student> nameStudent = students.stream().sorted(byLastName.thenComparing(byFistName)).collect(Collectors.toList());
		nameStudent.stream().forEach(System.out::println);
		
	}
}
