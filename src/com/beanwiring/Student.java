package com.beanwiring;

public class Student {
	private int age;
	private String name;
	private Address address;
	public Student() {
		super();
	}
	public Student(int age, String name, Address address) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
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
