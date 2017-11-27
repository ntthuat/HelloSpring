package com.springzero.javacertificate.z803;

public class Question73 {
	
}

class StaticMethods {
	static void one() {
		two();
		StaticMethods.two();
		/*three();*/
		/*StaticMethods.four();*/
	}

	static void two() {
	}

	void three() {
		one();
		StaticMethods.two();
		four();
		/*StaticMethods.four();*/
	}

	void four() {
	}
}
