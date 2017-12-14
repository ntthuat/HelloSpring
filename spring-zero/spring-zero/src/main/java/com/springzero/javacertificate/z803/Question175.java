package com.springzero.javacertificate.z803;

public class Question175 {
	static void dispResult(int[] num) {
		try {
			System.out.println(num[1]/(num[1]-num[2]));
		} catch (ArithmeticException e) {
			System.out.println("first exception");
		}
		System.out.println("Done");
	}
	
	public static void main(String[] args) {
		try {
			int[] arr = {100,100};
			dispResult(arr);
		} catch (IllegalArgumentException e) {
			System.out.println("second exception");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("third exception");
		}
	}
}
