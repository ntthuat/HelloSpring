package com.springzero.javacertificate.z803;

public class Question227 {
	private int model;
	private String flavor;
	Question227(){
		model = 123;
		flavor = "red";
	}
	public static void main(String[] args) {
		Question227 test = new Question227();
		System.out.println(test.hashCode());
		System.out.println(test.flavor.hashCode());
		bake1(test);
		System.out.println(test.flavor);
	}
	
	public static void bake1(Question227 c) {
		c.flavor = "Strawberry";
		System.out.println(c.flavor.hashCode());
		c.model = 1200;
	}
}
