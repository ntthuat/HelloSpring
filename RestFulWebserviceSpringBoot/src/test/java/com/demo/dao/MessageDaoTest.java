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
		MessageRequest messageRequest = messageDao.getMessage("67457547");
		assertEquals("67457547", messageRequest.getCusExRef());
		assertEquals("ECA_COMPANY", messageRequest.getCusName());
		assertEquals("1508140002", messageRequest.getCasRef());
		assertEquals(null, messageRequest.getMsgBoxDirIn());
		assertEquals(null, messageRequest.getMsgBoxDirOut());
		assertEquals("2015-10-08 00:00:00.0", messageRequest.getMsgFromDat());
		assertEquals("2015-10-08 00:00:00.0", messageRequest.getMsgToDat());
		assertEquals(null, messageRequest.getMsgUnread());
	}
	
	@Test
	public void testGetListMessage() {
		List<MessageRequest> list = messageDao.getListMessage("67457547");
		assertEquals(843, list.size());
	}
	
	@Test
	public void testGetMessageResponse() {
		MessageResponse message = messageDao.getMessageResponse("A600O8VC");
		assertEquals("1508100003", message.getCasRef());
	}
	
	@Test
	public void testGetMessage2() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setCusExRef("40300383");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(2, list.size());
	}
	
	@Test
	public void testGetMessage3() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setCusExRef("40300383");
		/*messageRequest.setCasRef("1406160015");*/
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(2, list.size());
	}
	
	/**
	 * Test with parameter:
	 * msgFromDat = "2015-09-28"
	 */
	@Test
	public void testGetListMessageFromDate() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setMsgFromDat("2015-09-28");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(21, list.size());
	}
	
	/**
	 * Test with parameter:
	 * toDat = "2015-09-27"
	 */
	@Test
	public void testGetListMessageToDate() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setMsgToDat("2015-09-27");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(21, list.size());
	}
	
	@Test
	public void testGetListMessageUnread() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setMsgUnread(true);
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(7, list.size());
		messageRequest.setMsgUnread(null);
		list = messageDao.getMessage(messageRequest);
		assertEquals(21, list.size());
	}
	
	/**
	 * A6008J6X
	 */
	@Test
	public void testGetListMessageFromSearch() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setMsgSearchBy("from");
		messageRequest.setMsgFilter("A6008J6X");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(0, list.size());
	}
	
	/**
	 * 97000002
	 */
	@Test
	public void testGetListMessageToSearch() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setMsgSearchBy("to");
		messageRequest.setMsgFilter("97000002");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(1, list.size());
	}
	
	/**
	 * LIS REM 2 NO INFO
	 */
	@Test
	public void testGetListMessageSubjectSearch() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setMsgSearchBy("subject");
		messageRequest.setMsgFilter("LIS REM 2 NO INFO");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(0, list.size());
	}
	
	/**
	 * 1508130010
	 */
	@Test
	public void testGetListMessageCaseSearch() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setMsgSearchBy("case");
		messageRequest.setMsgFilter("1508130010");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(1, list.size());
	}
	
	/**
	 * BUSINESS UNIT 1
	 * Issue: java heap space
	 */
	@Test
	public void testGetListMessageDebtorSearch() {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setMsgSearchBy("debtor");
		messageRequest.setMsgFilter("BUSINESS UNIT 1");
		List<Map<String, Object>> list = messageDao.getMessage(messageRequest);
		assertEquals(0, list.size());
	}
}
