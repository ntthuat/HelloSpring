package com.springzero.javacertificate.z803;

public class Question11 {
	public static void main(String[] args) {
		Speak speakIt = new Tell();
		Tell tellIt = new Tell();
		/*speakIt.tellItLikeItIs();*/ // this method fail because tellIdLikeItIs do not exist in Speak
		/*(Truth)speakIt.tellItLikeItIs();*/ // this method fail because tellIdLikeItIs do not exist in Speak
		((Truth)speakIt).tellItLikeItIs(); // it cast to Truth then cast to Tell because of line 5 execute the method
		/*((Truth2)speakIt).tellItLikeItIs();*/ // có thể cast được ở đây, nhưng chạy sẽ gặp lỗi ClassCastException
		tellIt.tellItLikeItIs();
		/*(Truth)tellIt.tellItLikeItIs();*/ // interface không thể cast cho 1 variable (void ở đây tính là variable)
		((Truth)tellIt).tellItLikeItIs();
	}
}

class Speak{
	public void abc() {
		System.out.println("abc");
	}
}

class Tell extends Speak implements Truth{

	@Override
	public void tellItLikeItIs() {
		System.out.println("Right on");
	}
	
}

interface Truth2 {
	public void tellItLikeItIs();
}

interface Truth{
	public void tellItLikeItIs();
}

class Tell2 extends Speak implements Truth{

	@Override
	public void tellItLikeItIs() {
		System.out.println("Right on 2");
	}
	
}


