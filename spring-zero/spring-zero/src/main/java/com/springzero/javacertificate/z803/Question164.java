package com.springzero.javacertificate.z803;

public class Question164 {
	public static void main(String[] args) {
		int i = 1;
		do {
			if (i % 2 == 0)
				continue;
			if (i == 5)
				break;
			System.out.print(i + "\t");
			i++;
		} while (true);
	}
}
