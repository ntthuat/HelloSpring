package com.springzero.javacertificate.z803;

public class Question11 {
	public static void main(String[] args) {
		Speak speakIt = new Tell();
		Tell tellIt = new Tell();
		/*speakIt.tellItLikeItIs();*/ // this method fail because tellIdLikeItIs do not exist in Speak
		/*(Truth)speakIt.tellItLikeItIs();*/ // this method fail because tellIdLikeItIs do not exist in Speak
		((Truth)speakIt).tellItLikeItIs();
	}
}

class Speak{
	
}

class Tell extends Speak implements Truth{

	@Override
	public void tellItLikeItIs() {
		System.out.println("Right on");
	}
	
}

interface Truth{
	public void tellItLikeItIs();
}


