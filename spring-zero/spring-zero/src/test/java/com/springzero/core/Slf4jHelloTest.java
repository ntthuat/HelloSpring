package com.springzero.core;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import com.springzero.core.Slf4jHello;

/**
 * Class này dùng để test cho class Slf4jHello
 * 
 * @author Thuat T Nguyen
 * @version 05/23/2017
 *
 */
public class Slf4jHelloTest {
	
	@Test
	public void testSayHello(){
		Slf4jHello slf4jHello = new Slf4jHello();
		slf4jHello.sayHello("Thuat");
	}
	
	@Test
	public void testLoggerFactory(){
		LoggerFactory.getLogger(Slf4jHelloTest.class).debug("Thuat"); // dòng code này sẽ ra luôn chữ Thuật
	}
}
