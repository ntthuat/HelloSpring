package com.springzero.springhibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Đây là các entities sẽ map với schema "db", table "employee"
 * 
 * @author Thuat T Nguyen
 * @version 06/02/2017
 */
@Entity
@Table(name = "employee")
public class Employee {
	private int id;
	private String name;

	@Id
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
