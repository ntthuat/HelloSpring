package com.springzero.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * File này dùng để chạy thử các thư viện trong Slf4j. Ví dụ như LoggerFactory
 * 
 * @author Thuat T Nguyen
 * @version 05/05/2017
 *
 */
public class Slf4jHello {
	private final Logger slf4jLogger = LoggerFactory.getLogger(Slf4jHello.class);
	 
    /**
     * Print hello in log.
     * 
     * @param name
     */
    public void sayHello(String name) {
        slf4jLogger.info("Hi, {}", name);
        slf4jLogger.info("Welcome to the HelloWorld example of Slf4j");
    }
}
