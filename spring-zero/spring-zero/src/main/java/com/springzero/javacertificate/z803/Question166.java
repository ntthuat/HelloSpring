package com.springzero.javacertificate.z803;

public class Question166 {
	public static void main(String[] args) {
		int i = 25;
		int j = i++ + 1;
		if (j % 5 == 0) {
			System.out.println(j + " is divisible by 5");
		} else {
			System.out.println(j + " is not divisible by 5");
		}
		System.out.println("Done");
	}
}
