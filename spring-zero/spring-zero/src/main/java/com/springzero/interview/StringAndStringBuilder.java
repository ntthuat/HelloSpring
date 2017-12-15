package com.springzero.interview;

public class StringAndStringBuilder {
	public static void main(String[] args) {
		String s = "abc";
		for (int i = 0; i < 1000; i++) {
			s = s + i;
		}
		StringBuilder sb = new StringBuilder("123456789012345"); // default length = 16
		sb.append("12345");
	}
}
