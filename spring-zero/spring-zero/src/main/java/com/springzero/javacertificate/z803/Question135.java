package com.springzero.javacertificate.z803;

public class Question135 {
	private StringBuilder str = new StringBuilder("default");
	
	public StringBuilder getStr() {
		return str;
	}

	public void setStr(StringBuilder str) {
		this.str = str;
	}

	public int ivalue = 17;

	Question135(StringBuilder s) {
		str = s;
	}

	Question135(int i) {
		ivalue = i;
	}

	void print() {
		System.out.println(str + " " + ivalue);
	}

	public static void main(String[] args) {
		Question135 q1 = new Question135(new StringBuilder("hello"));
		Question135 q2 = new Question135(92);
		StringBuilder s = q1.getStr();
		s.append("123");
		System.out.println("end");
	}
}
