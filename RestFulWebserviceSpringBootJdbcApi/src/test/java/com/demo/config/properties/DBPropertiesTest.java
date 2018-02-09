package com.demo.config.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hello.Application;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/08/2018
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DBPropertiesTest {
	
	DBProperties db;

	@Autowired
	public void setDB(DBProperties db) {
		this.db = db;
	}
	
	@Test
	public void testDB() {
		System.out.println(db.toString());
	}
}
