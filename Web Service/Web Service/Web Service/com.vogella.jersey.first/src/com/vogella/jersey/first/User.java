package com.vogella.jersey.first;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int id;
	private String name;
	private String password;
	private String type_account;
	private String fullname;
	private String classPerson;
	

	public User() {
		// TODO Auto-generated constructor stub
	}	
	
	public User(String name, String password, String type_account, String fullname, String classPerson) {
		super();
		this.name = name;
		this.password = password;
		this.type_account = type_account;
		this.fullname = fullname;
		this.classPerson = classPerson;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getClassPerson() {
		return classPerson;
	}

	public void setClassPerson(String classPerson) {
		this.classPerson = classPerson;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType_account() {
		return type_account;
	}

	public void setType_account(String type_account) {
		this.type_account = type_account;
	}

	@Override
	public String toString() {
		return "user [id=" + id + 
				", name=" + name + 
				", password=" + password + 
				", type_account=" + type_account +
				"]";
	}
}
