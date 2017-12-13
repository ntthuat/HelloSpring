package com.springzero.javacertificate.z803;

import java.io.IOException;

public class Question1 {
	public static void main(String[] args) throws IOException {
		/*try {
			doSomething();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}*/
		int i = 5;
		System.out.println(System.identityHashCode(i));
		int abc = 5;
		System.out.println(System.identityHashCode(abc));
		abc = 10;
		System.out.println(System.identityHashCode(abc));
	}
	
	static void doSomething() throws IOException{
		if (Math.random() > 0.5) throw new IOException();
		throw new RuntimeException();
	}
}


