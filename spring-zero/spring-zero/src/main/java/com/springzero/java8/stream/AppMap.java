package com.springzero.java8.stream;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Run thử function stream().map();
 * 
 * @author tnguyen443
 * @version 10/23/2017
 */
public class AppMap {

	private static List<Student> students = new ArrayList<>();

	public static void setUp() {
		students.add(new Student(1L, "Long", "Nguyen", Gender.MALE, LocalDate.of(1992, Month.JANUARY, 20)));
		students.add(new Student(2L, "Phong", "Nguyen", Gender.MALE, LocalDate.of(1990, Month.AUGUST, 1)));
		students.add(new Student(3L, "Lan", "Do", Gender.FEMALE, LocalDate.of(1993, Month.OCTOBER, 10)));
		students.add(new Student(4L, "Ngoc", "Le", Gender.FEMALE, LocalDate.of(1992, Month.SEPTEMBER, 26)));
		students.add(new Student(5L, "Ngan", "Nguyen", Gender.FEMALE, LocalDate.of(1992, Month.JANUARY, 3)));
	}

	public static void main(String[] args) {
		// set up
		setUp();

		students.stream().map(Student::getDateOfBirth).forEach(System.out::println);
	}
}
