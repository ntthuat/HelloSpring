package com.jdbczero.code;

import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * Class này dùng để test cho class Slf4jHello
 * 
 * @author tnguyen443
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
