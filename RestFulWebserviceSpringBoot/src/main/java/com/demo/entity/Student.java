package com.demo.entity;

import java.util.Date;

/**
 * @author tnthien
 * @version 01/22/0218
 */
public class Student {

	private long id;
	private String name;
	private String subject;

	public Student() {
	}

	public Student(final String name, final String subject) {
		this.id = (new Date()).getTime();
		this.name = name;
		this.subject = subject;
	}
	
	public Student(final long id, final String name, final String subject) {
		this.id = id;
		this.name = name;
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", subject='" + subject + '\'' + '}';
	}
}
