package com.springzero.javacertificate.z803;

import java.io.IOException;

public class Question1 {
	public static void main(String[] args) throws IOException {
		try {
			doSomething();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	static void doSomething() throws IOException{
		if (Math.random() > 0.5) throw new IOException();
		throw new RuntimeException();
	}
}
