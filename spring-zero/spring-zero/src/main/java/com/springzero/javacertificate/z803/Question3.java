package com.springzero.javacertificate.z803;

public class Question3 {
	public static void main(String[] args) {
		Question3SampleClass sc = new Question3SampleClass();
		Question3AnotherSampleClass asc = new Question3AnotherSampleClass();
		sc = asc;
	}
}

class Question3SampleClass{
	
}

class Question3AnotherSampleClass extends Question3SampleClass{
	
}
