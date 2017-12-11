package com.springzero.javacertificate.z803;

public class Question215 {
	public static void main(String[] args) {
		String s1 = "Java";
		char s2[] = {'J','a','v','a'};
		String s3 = null;
		String s4 = null;
		for (char c : s2) {
			s3 = s3 + c;
		}
		if (s1.equals(s3)) {
			System.out.println("Succesfful");
		} else {
			System.out.println("Unsuccesfful");
		}
	}
}
