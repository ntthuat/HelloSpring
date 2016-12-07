package com.test;

public class Test {
	public static void main(String[] args) {
		boolean a = Database.getInstance().isOffset();
		boolean b = Database.getInstance().isOffset();
		b = true;
		System.out.println(a);
		System.out.println(b);
	}
}
