package com.demo.config.properties;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import hello.Application;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AppPropertiesTest{
	
	private AppProperties app;

    @Autowired
    public void setApp(AppProperties app) {
        this.app = app;
    }

	@Test
	public void testGetAppProperties() {
		System.out.println(app.toString());
	}
}
