package com.springzero.annotation;

@Hibernate_Table("HocSinh")
public class Student {
	
	@Hibernate_Field("ID")
	private int id;
	
	@Hibernate_Field("TEN")
	private String name;
	
	@Hibernate_Field("DIEM")
	private String score;
}
