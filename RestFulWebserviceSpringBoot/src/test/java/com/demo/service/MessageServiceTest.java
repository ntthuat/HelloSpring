package com.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.MessageDao;
import com.demo.dao.impl.MessageDaoImpl;
import com.demo.model.MessageRequest;
import com.demo.model.MessageResponse;

/**
 * 
 * @author tnthien
 * @version 01/26/2018
 */
public class MessageServiceTest {

	private ApplicationContext appContext;
	
	private MessageService messageService;
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dataaccess-application.xml");
		messageService = (MessageService)appContext.getBean("messageService");
	}
	
	@Test
	public void test() {
		MessageResponse message = messageService.getMessageResponse();
		assertEquals("0310170002", message.getCasRef());
		System.out.println(message);
	}
}
