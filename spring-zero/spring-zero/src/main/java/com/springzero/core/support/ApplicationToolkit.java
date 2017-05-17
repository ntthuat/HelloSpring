package com.springzero.core.support;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Defines interfaces that are commonly used by application. It should be implemented by a specific application and
 * configured to be used.<br>
 * Interface này định nghĩa 1 design cho Application để chạy befor cho test, có liên quan đến session.
 * 
 * @author Thuat T Nguyen
 * @version 05/17/2017
 *
 */
public interface ApplicationToolkit {
	
	/**
	 * Get a String representing application name.<br>
	 * This is not compulsory, but it's omething good to have
	 * 
	 * @return String representing application name
	 */
	String getApplicationName();

	/**
	 * Get current date
	 * 
	 * @return current date
	 */
	Date getCurrentDate();

	/**
	 * Get current time stamp
	 * 
	 * @return current timestamp
	 */
	Timestamp getCurrentTimestamp();

	/**
	 * Get current time in milliseconds
	 * 
	 * @return value
	 */
	long getCurrentTimeInMills();
}
