package com.springzero.time;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

public class TimeFunctionsTest {
	
	private static final long DAY_IN_MILLISECOND = 24 * 60 * 60 * 1000;
	private static final SimpleDateFormat timeFormater = new SimpleDateFormat("HHmmss");
	
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

	// support hiển thị in ra time có milliseconds
	@Test
	public void printMilliseconds(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		final long b4delay = System.currentTimeMillis();
		Date date = new Date(b4delay);
		System.out.println("date:"+sdf.format(date));
	}
	
	/**
	 * 
	 */
	@Test
	public void testDelay(){
		long delay = 3; // hẹn thời gian delay là 3s
		long millisecondsDelay = delay*1000;
		final long b4Delay = System.currentTimeMillis();
		
		doExecuteDelay(delay); // truyền vào là giây
		assertExecute(b4Delay, millisecondsDelay);
	}
	
	@Test
	public void testResume() {
		final long delay = 5;
		final long resumeTimeMilliseconds = delay * 1000;
		final long b4delay = System.currentTimeMillis();
		final long currentTimeMilliseconds = b4delay % 1000;
		final long expectedDelay = resumeTimeMilliseconds - currentTimeMilliseconds;
		long resumeTime = b4delay + resumeTimeMilliseconds; // Delay for 5s
		String resumeTimeAsString = timeFormater.format(new Date(resumeTime));

		// Execute delay job, and check for return time
		doExecuteResume(resumeTimeAsString);
		assertExecute(b4delay, expectedDelay);
	}
	
	private void assertExecute(final long b4Delay, final long expectedDelay) {
		Assert.assertTrue("Check if after delay time (milliseconds) - before delay is no less than " + expectedDelay,
			(System.currentTimeMillis() - b4Delay) >= expectedDelay);
	}
	
	/**
	 * Get delay time in milliseconds.
	 * @return 
	 */
	private static Long getDelayTime(final long millisecondsDelay) {
		Long delay = millisecondsDelay;
		if (delay != null && delay >= 0) {
			return delay * 1000; // Convert into milliseconds
		} else {
			return (long) 0;
		}
	}
	
	/**
	 * Get resume time in milliseconds.
	 * @return 
	 */
	private static Long getResumeTime(final String resumeString) {
		Long resumeTime = null;
		if (resumeString != null) {
			resumeTime = toTime(resumeString).getTime();
			long curTime = System.currentTimeMillis() % DAY_IN_MILLISECOND; // Get current time (no date)
			if (curTime <= resumeTime) { // Up coming milliseconds
				resumeTime = resumeTime - curTime;
			}
			else { // Next day
				resumeTime = DAY_IN_MILLISECOND - (curTime - resumeTime);
			}
		}

		return resumeTime;
	}
	
	/**
	 * Convert string to time (date information is trimmed)
	 * @param timeAsString time as string
	 * @return return time
	 */
	private static Date toTime(String timeAsString) {
		Date time = null;
		try {
			time = timeFormater.parse(timeAsString);
		}
		catch (ParseException exc) {
			//logger.error("Failed to parse '" + timeAsString + "' to datetime", exc);
		}

		return time;
	}
	
	/**
	 * Delay job. Hàm này delay 1 khoảng thời gian theo milliseconds
	 * 
	 * @param delay - time to delay
	 */
	private void delay(final long delay) {
		final long starting = System.currentTimeMillis();
		long remainTime = delay;
		while (remainTime > 0) {
			try {
				Thread.sleep(remainTime);
			} catch (InterruptedException exc) {
				break;
			} finally {
				remainTime = remainTime - (System.currentTimeMillis() - starting);
			}
		}
	}
	
	protected void doExecuteDelay(final long millisecondsDelay) {
		Long delay = getDelayTime(millisecondsDelay);
		if (delay != null && delay != 0) {
			delay(delay);
		}
	}
	
	protected void doExecuteResume(final String resumeString) {
		Long delay = getResumeTime(resumeString);
		if (delay != null && delay != 0) {
			delay(delay);
		}
	}
}
