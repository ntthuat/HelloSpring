package com.demo.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.config.DataAccessBeans;

public class JdbcUtilsTest {
	
	private ApplicationContext appContext;
	
	private static final int rowCountGIndividu = 18234;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dao-jdbc.xml");
	}
	
	/**
     * Test get row count in table "gen$huis.g_individu"<br>
	 * @throws Exception 
     */
	@Test
	public void testEmployeeJdbc() throws Exception {
		int count = JdbcUtils.getRowCount("gen$huis", "g_individu");
		assertEquals(rowCountGIndividu, count);
	}
}
