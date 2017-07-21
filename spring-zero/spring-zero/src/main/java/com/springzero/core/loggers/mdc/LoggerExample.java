package com.springzero.core.loggers.mdc;

import org.slf4j.MDC;

/**
 * Chạy thử MDC từ package loggers
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public class LoggerExample {
	
	public static void main(String[] args) {
		System.out.println(MDC.get("key1")); // in ra null.
		// Rõ ràng MDC không có link từ package này sang package khác
	}
}
