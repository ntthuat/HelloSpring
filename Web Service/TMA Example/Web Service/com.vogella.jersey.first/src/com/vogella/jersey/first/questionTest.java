package com.vogella.jersey.first;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class questionTest {
	private int id;
	private String content;
	private String type;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String trueAnswer;
	public questionTest() {
		// TODO Auto-generated constructor stub
	}
	public questionTest(String content, String type, String answerA, String answerB, String answerC, String answerD,
			String trueAnswer) {
		super();
		this.content = content;
		this.type = type;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.trueAnswer = trueAnswer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public String getAnswerD() {
		return answerD;
	}
	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}
	public String getTrueAnswer() {
		return trueAnswer;
	}
	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}
	
	@Override
	public String toString() {
		return "question [id=" + id +
				", content=" + content + 
				", type=" + type + 
				", answerA=" + answerA + 
				", answerB=" + answerB + 
				", answerD=" + answerD + 
				", answerD=" + answerD + 
				", trueAnswer=" + trueAnswer + 
				"]";
	}
}
