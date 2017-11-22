package com.springzero.javacertificate.z803;

public class Question8 extends X{
	Question8(){};
	private void two(){
		one();
	}
	public static void main(String[] args) {
		new Question8().two();
	}
}

class X{
	X(){};

	protected void one() { // phải đặt protected ở đây để class con có thể xài
		System.out.println("Question 8 finished");
	};
}
