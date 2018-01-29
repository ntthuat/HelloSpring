package com.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.dao.MessageDao;
import com.demo.dao.impl.MessageDaoImpl;
import com.demo.model.MessageRequest;
import com.demo.model.MessageResponse;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 * 
 */
@Component
public class MessageService {
	
	private ApplicationContext appContext;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private DataSource datasource;
	
	public DataSource getDataSource() {
		return datasource;
	}
	
	public void setUp(){
		appContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dataaccess-application.xml");
		messageDao = (MessageDaoImpl)appContext.getBean("messageDao");
	}
	
	public static HashMap<Integer, MessageRequest> hmMessage;
	
	public static HashMap<Integer, MessageResponse> hmMessageResponse;

	public static List<MessageRequest> listMessage;

	public HashMap<Integer, MessageRequest> getMessage(String cusExRef) {
		/*if (appContext == null) {
			setUp();
		}*/
		hmMessage = new HashMap<>();
		final MessageRequest messageRequest;
		if (cusExRef == null) {
			messageRequest = messageDao.getMessage("TEST_GNAC3YKW2JA2002697");
		} else {
			messageRequest = messageDao.getMessage(cusExRef);
		}

		hmMessage.put(101, messageRequest);
		return hmMessage;
	}
	
	public HashMap<Integer, MessageRequest> getMessageFullParameter(String cusExRef, String cusName, String casRef,
			String msgBoxDirIn, String msgBoxDirOut, String msgFromDat, String msgToDat, String msgSearchBy,
			Boolean msgUnread, String msgFilter) {
		/*if (appContext == null) {
			setUp();
		}*/
		hmMessage = new HashMap<>();
		final MessageRequest messageRequest;
		System.out.println(cusExRef);
		messageRequest = messageDao.getMessage(cusExRef, cusName, casRef, msgBoxDirIn, msgBoxDirOut, msgFromDat,
				msgToDat, msgSearchBy, msgUnread, msgFilter);

		hmMessage.put(101, messageRequest);
		return hmMessage;
	}
	
	public List<MessageRequest> getListMessageRequest() {
		/*if (appContext == null) {
			setUp();
		}*/
		listMessage = new ArrayList<>();
		listMessage = messageDao.getListMessage("TEST_GNAC3YKW2JA2002697");
		return listMessage;
	}
	
	public MessageResponse getMessageResponse() {
		/*if (appContext == null) {
			setUp();
		}*/
		final MessageResponse message;
		message = messageDao.getMessageResponse("A3048843");
		return message;
	}
}
