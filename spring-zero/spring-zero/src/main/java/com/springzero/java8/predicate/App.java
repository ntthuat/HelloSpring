package com.springzero.java8.predicate;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author tnguyen443
 * @version 10/20/2017
 */
public class App {
	
	private static List<Student> students = new ArrayList<>();
	
	public static void setUp(){
		students.add(new Student(1L, "Long", "Nguyen Thanh", "Male", 20, 4.0));
	    students.add(new Student(2L, "Thuong", "Nguyen Van", "Male", 21, 8.5));
	    students.add(new Student(3L, "Phuc", "Huynh Thi Kim", "Female", 20, 8.8));
	    students.add(new Student(4L, "Thuong", "Tran Than", "Male", 18, 5.4));
	    students.add(new Student(5L, "Ngoc", "Pham Bich", "Female", 19, 6.2));
	    students.add(new Student(6L, "Linh", "Tran Thi", "Female", 17, 8.5));
	    students.add(new Student(7L, "Le", "Vo Nhat", "Female", 17, 9.0));
	    students.add(new Student(8L, "Nga", "Nguyen Thi", "Female", 17, 3.0));
	}
	
	public static void main(String[] args) {
		//setUp
		setUp();
		
	    System.out.println("\n--- Danh sach hoc sinh nam ---");
	    System.out.println(StudentPredicate.filterStudents(students, StudentPredicate.isGenderEqualTo("Male")));
	    
	    System.out.println("\n--- Danh sach hoc sinh co diem toan >= 8.5 va < 9.0 ---");
	    System.out.println(StudentPredicate.filterStudents(students, StudentPredicate.isMathPointBetween(8.5, 9.0)));
	    
	    System.out.println("\n--- Danh sach hoc sinh ten la Thuong ---");
	    System.out.println(StudentPredicate.filterStudents(students, StudentPredicate.isFirstNameEqualTo("Thuong")));
	    
	    System.out.println("\n--- Danh sach hoc sinh co tuoi > 18");
	    System.out.println(StudentPredicate.filterStudents(students, StudentPredicate.isAdult()));
	}
}
