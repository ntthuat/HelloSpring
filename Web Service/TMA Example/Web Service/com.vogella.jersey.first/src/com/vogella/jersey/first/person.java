package com.vogella.jersey.first;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class person {
	private int id;
	private String name;
	private String classPerson;
	private String type_projectTest;
	private int num_question;
	private int score;
	public person() {
		// TODO Auto-generated constructor stub
	}
	public person(String name, String classPerson, String type_projectTest, int num_question, int score) {
		super();
		this.name = name;
		this.classPerson = classPerson;
		this.type_projectTest = type_projectTest;
		this.num_question = num_question;
		this.score = score;
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
	public String getClassPerson() {
		return classPerson;
	}
	public void setClassPerson(String classPerson) {
		this.classPerson = classPerson;
	}
	public String getType_projectTest() {
		return type_projectTest;
	}
	public void setType_projectTest(String type_projectTest) {
		this.type_projectTest = type_projectTest;
	}
	public int getNum_question() {
		return num_question;
	}
	public void setNum_question(int num_question) {
		this.num_question = num_question;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "person [id=" + id +
				", name=" + name + 
				", classPerson=" + classPerson + 
				", type_projectTest=" + type_projectTest + 
				", num_question=" + num_question + 
				", score=" + score + 
				"]";
	}
}
