package com.springzero.java8.stream;

import java.util.List;import ch.qos.logback.core.net.SyslogOutputStream;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

/**
 * 
 * @author tnguyen443
 * @version 10/20/2017
 */
public class AppFilter {
	
	private static List<Student> students = new ArrayList<>();
	
	public static void setUp(){
		students.add(new Student(1L, "Long", "Nguyen", Gender.MALE, LocalDate.of(1992, Month.JANUARY, 20)));
	    students.add(new Student(2L, "Phong", "Nguyen", Gender.MALE, LocalDate.of(1990, Month.AUGUST, 1)));
	    students.add(new Student(3L, "Lan", "Do", Gender.FEMALE, LocalDate.of(1993, Month.OCTOBER, 10)));
	    students.add(new Student(4L, "Ngoc", "Le", Gender.FEMALE, LocalDate.of(1992, Month.SEPTEMBER, 26)));
	    students.add(new Student(5L, "Ngan", "Nguyen", Gender.FEMALE, LocalDate.of(1992, Month.JANUARY, 3)));
	}
	
	public static void main(String[] args) {
		//setUp
		setUp();
		
		// Loc va in ra man hinh cac sv co ho la Nguyen , sinh vao thang 01, nam 1992
		students.stream()
				.filter(student -> student.getLastName().equalsIgnoreCase("Nguyen")
						&& student.getDateOfBirth().getMonth().equals(Month.JANUARY)
						&& student.getDateOfBirth().getYear()==1992)
				.forEach(System.out::println);
		System.out.println("======================");
		 // Loc va in ra man hinh cac sv co ten bat dau la ky tu 'L', gioi tinh nu (FEMALE)
		students.stream()
				.filter(student -> student.getFirstName().startsWith("L") 
						&& student.getGender().equals(Gender.FEMALE))
				.forEach(System.out::println);
		System.out.println("======================");
		
		// Loc va in ra man hinh cac sinh vien co tuoi <= 25, gia su thoi diem
		// hien tai la 2016-DECEMBER-20
		students.stream().filter(student -> {
			LocalDate currentLocalDate = LocalDate.of(2016, Month.DECEMBER, 20);
			LocalDate dateOfBirth = student.getDateOfBirth();
			Period period = Period.between(dateOfBirth, currentLocalDate);

			return period.getYears() >= 25;
		}).forEach(System.out::println);
	}
}
