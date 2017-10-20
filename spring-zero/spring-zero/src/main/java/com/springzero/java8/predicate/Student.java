package com.springzero.java8.predicate;

/**
 * 
 * @author tnguyen443
 * @version 10/20/2017
 */
public class Student {
	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer age;
	private Double mathPoint;

	public Student(Long id, String firstName, String lastName, String gender, Integer age, Double mathPoint) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.mathPoint = mathPoint;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getMathPoint() {
		return mathPoint;
	}

	public void setMathPoint(Double mathPoint) {
		this.mathPoint = mathPoint;
	}

	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", mathPoint=" + mathPoint + "]";
	}
}
