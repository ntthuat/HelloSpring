package com.springzero.javacertificate.z803;

public class Question200 {
	public static void main(String[] args) {
		Sun s = new Sun();
		((Star)s).doStuff();
	}
}

class Star {
	public void doStuff(){
		System.out.println("Star");
	}
}

class Sun extends Star {
	public void doStuff(){
		System.out.println("Sun");
	}
}
