package com.demo.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.demo.model.MessageResponse;

/**
 * 
 * @author tnthien
 * @version 01/26/2018
 */
public class MessageServiceTest {

	@Test
	public void test() {
		MessageService messageService = new MessageService();
		MessageResponse message = messageService.getMessageResponse();
		assertEquals("0310170002", message.getCasRef());
		System.out.println(message);
	}
}
