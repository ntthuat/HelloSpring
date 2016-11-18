package com.autowired.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Table {

	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Table() {
		System.out.println("This is table");
	}

	public void checkSpelling() {
		System.out.println("Inside checkSpelling.");
	}
}
