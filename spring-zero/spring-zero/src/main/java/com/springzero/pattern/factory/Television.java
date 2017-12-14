package com.springzero.pattern.factory;

public class Television implements Product{

	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Television(String color) {
		super();
		this.color = color;
	}
	
	public Television() {
	}

	@Override
	public void show() {
		System.out.println("Showing Tv");
	}

}
