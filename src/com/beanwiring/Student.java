package com.beanwiring;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Student {
	private int age;
	private String name;
	private Address address;
	
	List<String> books;
	Map<String, Subject> timeTable;
	Properties hobbies;
	
	public Student() {
		super();
	}
	public Student(int age, String name, Address address) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
	}
	
	public List<String> getBooks() {
		return books;
	}
	public void setBooks(List<String> books) {
		this.books = books;
	}
	public Map<String, Subject> getTimeTable() {
		return timeTable;
	}
	public void setTimeTable(Map<String, Subject> timeTable) {
		this.timeTable = timeTable;
	}
	public Properties getHobbies() {
		return hobbies;
	}
	public void setHobbies(Properties hobbies) {
		this.hobbies = hobbies;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
