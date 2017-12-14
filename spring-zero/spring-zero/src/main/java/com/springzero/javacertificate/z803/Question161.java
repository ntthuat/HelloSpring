package com.springzero.javacertificate.z803;

public class Question161 {
	public static void main(String[] args) {
		Sun s2 = new Sun();
		((Star)s2).doStuff();
	}
}

class Star {
	public void doStuff() {
		System.out.println("Star");
	}
}

interface Universe {
	public void doStuff();
}

class Sun extends Star implements Universe{
	public void doStuff() {
		System.out.println("Sun");
	}
}
