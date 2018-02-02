package com.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		assertEquals("1508140002", message.getCasRef());
		System.out.println(message);
	}
	
	@Test
	public void testListMessages() {
		MessageRequest rq = new MessageRequest();
		List<MessageResponse> list = messageService.getListMessage(rq);
		System.out.println(list.size());
		
	}
}
