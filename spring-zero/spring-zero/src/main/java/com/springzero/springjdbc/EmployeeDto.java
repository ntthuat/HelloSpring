package com.springzero.springjdbc;

/**
 * @author Thuat T Nguyen
 * @version 04/10/2017
 */
public class EmployeeDto {
	private int id;
	private String name;
	public EmployeeDto() {
	}
	public EmployeeDto(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String talkAboutYourself(){
		return "id: " + id +
				"name: " + name;
	}
}
