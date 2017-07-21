package com.springzero.core.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Ví dụ tất tần tật về log4j.
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public class LoggerExample {
	
	public static final Logger logger = LoggerFactory.getLogger(LoggerExample.class);
	
	public static void main(String[] args) {
		// check debug mode
		final boolean isDebugModeEnable = logger.isDebugEnabled();
		System.out.println(isDebugModeEnable);
		
		// use MDC
		MDC.put("first", "Richard");
	    MDC.put("last", "Nixon");

		/*System.out.println(MDC.get("key1"));*/
		logger.info("Check enclosed.");
		logger.debug("Check enclosed.");
	}
}
