package com.demo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.impl.MessageDaoImpl;
import com.demo.model.Message;

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
		Message message = messageDao.getMessage("TEST_GNAC3YKW2JA2002697");
		assertEquals("TEST_GNAC3YKW2JA2002697", message.getCusExRef());
		assertEquals("DEPARTEMENT SINISTRE", message.getCusName());
		assertEquals("1406160015", message.getCasRef());
		assertEquals(null, message.getMsgBoxDirIn());
		assertEquals(null, message.getMsgBoxDirOut());
		assertEquals("2014-06-16 00:00:00.0", message.getMsgFromDat());
		assertEquals("2014-06-16 00:00:00.0", message.getMsgToDat());
		assertEquals(null, message.getMsgUnread());
	}
	
	@Test
	public void testGetListMessage() {
		List<Message> list = messageDao.getListMessage("TEST_GNAC3YKW2JA2002697");
		assertEquals(161, list.size());
	}
}
