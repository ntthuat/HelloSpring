package com.springzero.time;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class TimeFunctionsTest {
	
	@Test
	public void timeBasicTest() throws ParseException{
		SimpleDateFormat timeFormater = new SimpleDateFormat("HHmmss");
		long curTime = System.currentTimeMillis(); // example: 1506935915422 (13 digits)
		Date date = new Date(System.currentTimeMillis());
		System.out.println("date:"+date);
		System.out.println(curTime);
		Date time = null;
		time = timeFormater.parse("34760000");
		System.out.println(time);
		System.out.println(timeFormater.parse("34755087"));
	}
}
