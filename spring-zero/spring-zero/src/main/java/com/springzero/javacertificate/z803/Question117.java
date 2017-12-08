package com.springzero.javacertificate.z803;

public class Question117 {
	private int i;

	void disp() {
		while (i <= 5) {
			for (int i = 1; i <= 5;) {
				System.out.print(i + " ");
				i++;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		new Question117().disp();
		System.out.println("end");
	}
}
