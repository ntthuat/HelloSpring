package com.springzero.javacertificate.z803;

public class Question213 {
	public static void main(String[] args) {
		Question213Z obj = new Question213Z();
		System.out.println(obj.x3);
	}
}

class Question213X {
	int x1, x2, x3;
}

class Question213Y extends Question213X {
	int y1;
	Question213Y() {
		x1 = 1;
		x2 = 2;
		y1 = 10;
	}
}

class Question213Z extends Question213Y {
	int z1;
	Question213Z() {
		x1 = 3;
		y1 = 20;
		z1 = 100;
	}
}
