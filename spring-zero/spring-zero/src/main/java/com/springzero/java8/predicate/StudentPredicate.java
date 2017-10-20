package com.springzero.java8.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author tnguyen443
 * @version 10/20/2017
 */
public class StudentPredicate {

	public static Predicate<Student> isGenderEqualTo(final String gender) {
		return p -> p.getGender().equalsIgnoreCase(gender);
	}

	public static Predicate<Student> isMathPointBetween(final Double minPoint, final Double maxPoint) {
		return p -> minPoint <= p.getMathPoint() && p.getMathPoint() < maxPoint;
	}

	public static Predicate<Student> isFirstNameEqualTo(final String firstName) {
		return p -> p.getFirstName().equalsIgnoreCase(firstName);
	}

	public static Predicate<Student> isAdult() {
		return p -> p.getAge() > 18;
	}

	public static List<Student> filterStudents(List<Student> students, Predicate<Student> predicate) {
		return students.stream().filter(predicate).collect(Collectors.<Student>toList());
	}
}
