package com.springzero.java8.stream;

import java.time.LocalDate;

/**
 * 
 * @author tnguyen443
 * @version 10/20/2017
 */
public class Student {
	private Long id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate dateOfBirth;

	public Student(Long id, String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	// Setters & Getters goes here

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Student [" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ']';
	}
}
