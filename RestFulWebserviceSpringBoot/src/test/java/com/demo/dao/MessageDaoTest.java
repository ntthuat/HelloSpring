package com.demo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.impl.MessageDaoImpl;
import com.demo.model.MessageRequest;
import com.demo.model.MessageResponse;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 * 
 */
public class MessageDaoTest {
	
	private ApplicationContext appContext;
	private MessageDao messageDao;
	
	@Autowired
	private DataSource datasource;
	
	public DataSource getDataSource() {
		return datasource;
	}
	
	@Before
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dataaccess-application.xml");
		messageDao = (MessageDaoImpl)appContext.getBean("messageDao");
	}
	
	@Test
	public void testGetMessage() {
		MessageRequest messageRequest = messageDao.getMessage("TEST_GNAC3YKW2JA2002697");
		assertEquals("TEST_GNAC3YKW2JA2002697", messageRequest.getCusExRef());
		assertEquals("DEPARTEMENT SINISTRE", messageRequest.getCusName());
		assertEquals("1406160015", messageRequest.getCasRef());
		assertEquals(null, messageRequest.getMsgBoxDirIn());
		assertEquals(null, messageRequest.getMsgBoxDirOut());
		assertEquals("2014-06-16 00:00:00.0", messageRequest.getMsgFromDat());
		assertEquals("2014-06-16 00:00:00.0", messageRequest.getMsgToDat());
		assertEquals(null, messageRequest.getMsgUnread());
	}
	
	@Test
	public void testGetListMessage() {
		List<MessageRequest> list = messageDao.getListMessage("TEST_GNAC3YKW2JA2002697");
		assertEquals(161, list.size());
	}
	
	@Test
	public void testGetMessageResponse() {
		MessageResponse message = messageDao.getMessageResponse("A3048843");
		assertEquals("0310170002", message.getCasRef());
		System.out.println(message);
	}
	
	@Test
	public void testGetMessage2() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setCusExRef("TEST_GNAC3YKW2JA2002697");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(161, list.size());
	}
	
	@Test
	public void testGetMessage3() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setCusExRef("TEST_GNAC3YKW2JA2002697");
		messageRequest.setCusName("DEPARTEMENT SINISTRE");
		messageRequest.setCasRef("1406160015");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(6, list.size());
		
	}
}
