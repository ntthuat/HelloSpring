package com.demo.config.properties;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
	
	private GlobalProperties global;

	private GlobalProperties2 global2;
	
    @Autowired
    public void setApp(AppProperties app) {
        this.app = app;
    }

    @Autowired
    public void setGlobal(GlobalProperties global) {
        this.global = global;
    }
    
    @Autowired
    public void setGlobal2(GlobalProperties2 global2) {
        this.global2 = global2;
    }
    
    /**
	 * Test annotation @ConfigurationProperties using @Value
	 * GlobalProperties map to email and thread-pool in config/global.properties
	 */
	@Test
	public void testGetGlobalProperties() {
		System.out.println(global.toString());
		assertEquals(global.toString(), "threadPool: 200\n" + "email: test@global2.com");
	}
	
	/**
	 * Test annotation @ConfigurationProperties using prefix
	 * GlobalProperties map to global.email and global.thread-pool in config/application.properties
	 */
	@Test
	public void testGetGlobalProperties2() {
		System.out.println(global2.toString());
		assertEquals(global2.getEmail(), "test@global3.com");
		assertEquals(global2.getThreadPool(), 300);
	}
	
	/**
	 * Test annotation @ConfigurationProperties using prefix
	 * AppProperties map to prefix "app" in config/application.properties
	 */
	@Test
	public void testGetAppProperties() {
		System.out.println(app.toString());
		
		assertEquals(app.getError(), "/error/");
		
		assertEquals(app.getCompiler().getOutputFolder(), "/temp/");
		assertEquals(app.getCompiler().getTimeout(), "5");
		
		assertEquals(app.getMenus().get(0).getTitle(), "Home");
		assertEquals(app.getMenus().get(0).getName(), "Home");
		assertEquals(app.getMenus().get(0).getPath(), "/");
		assertEquals(app.getMenus().get(1).getTitle(), "Login");
		assertEquals(app.getMenus().get(1).getName(), "Login");
		assertEquals(app.getMenus().get(1).getPath(), "/login");
	}
}
