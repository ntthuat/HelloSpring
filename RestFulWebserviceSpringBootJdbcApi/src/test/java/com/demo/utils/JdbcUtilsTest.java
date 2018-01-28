package com.demo.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcUtilsTest {
	
	private ApplicationContext appContext;
	
	private static final int rowCountGIndividu = 18174;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dao-jdbc.xml");
	}
	
	private static String abc;
	public static void init() {
		abc = "abd";
	}
	
	/**
     * Test get row count in table "gen$huis.g_individu"<br>
     */
	@Test
	public void testEmployeeJdbc() {
		System.out.println(abc);
		int count = JdbcUtils.getRowCount("gen$huis", "g_individu");
		assertEquals(rowCountGIndividu, count);
	}
}
