package com.springzero.sequencegenerator.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Thuat nguyen
 * @version 10/27/2017
 */
@Entity
public class Employee implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5315515169536750056L;

	private long unique_number;
	private String name;

	public Employee() {
	}

	public Employee(long unique_number, String name) {
		this.unique_number = unique_number;
		this.name = name;
	}

	@Id
	@Column(name = "UNIQUE_NUMBER", nullable = false)
	public long getUnique_number() {
		return this.unique_number;
	}

	public void setUnique_number(long unique_number) {
		this.unique_number = unique_number;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
