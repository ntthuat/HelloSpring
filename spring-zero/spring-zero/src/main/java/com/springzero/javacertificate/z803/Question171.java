package com.springzero.javacertificate.z803;

public class Question171 {
	
	public static void main(String[] args) {
		Test q = new Test();
		/*q.init();*/
		q.start();
	}
}

class Test {
	private void init() {
		System.out.println("init");
	}
	
	public void start() {
		System.out.println("start");
	}
}
