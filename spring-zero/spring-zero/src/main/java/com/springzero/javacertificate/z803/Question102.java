package com.springzero.javacertificate.z803;

public class Question102 {
	static void m(int[] i) {
		i[0] = 7;
		i[1] = 8;
	}

	public static void main(String[] args) {
		int[] j = new int[2];
		j[0] = 12;
		j[1] = 13;
		m(j);
		System.out.println(j[0]);
		System.out.println(j[1]);
	}
}
