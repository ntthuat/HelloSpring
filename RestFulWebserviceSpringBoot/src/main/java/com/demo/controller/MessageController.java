package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.MessageDao;
import com.demo.dao.impl.MessageDaoImpl;
import com.demo.model.Message;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 * 
 */
@RestController
@RequestMapping(value = "/")
public class MessageController {
	
	private ApplicationContext appContext;
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
	
	public static HashMap<Integer, Message> hmMessage;

	public static List<Message> listMessage;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "message", method = RequestMethod.GET)
	public HashMap<Integer, Message> getMessage(@RequestParam(value = "cusExRef", required = false) String cusExRef) {
		setUp();
		hmMessage = new HashMap<>();
		final Message message;
		if (cusExRef == null) {
			message = messageDao.getMessage("TEST_GNAC3YKW2JA2002697");
		} else {
			message = messageDao.getMessage(cusExRef);
		}

		hmMessage.put(101, message);
		return hmMessage;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "messageFullParameter", method = RequestMethod.GET)
	public HashMap<Integer, Message> getMessageFullParameter(
			@RequestParam(value = "cusExRef", required = false) String cusExRef,
			@RequestParam(value = "cusName", required = false) String cusName,
			@RequestParam(value = "casRef", required = false) String casRef,
			@RequestParam(value = "msgBoxDirIn", required = false) String msgBoxDirIn,
			@RequestParam(value = "msgBoxDirOut", required = false) String msgBoxDirOut,
			@RequestParam(value = "msgFromDat", required = false) String msgFromDat,
			@RequestParam(value = "msgToDat", required = false) String msgToDat,
			@RequestParam(value = "msgSearchBy", required = false) String msgSearchBy,
			@RequestParam(value = "msgUnread", required = false) Boolean msgUnread,
			@RequestParam(value = "msgFilter", required = false) String msgFilter
		) {
		setUp();
		hmMessage = new HashMap<>();
		final Message message;
		message = messageDao.getMessage(cusExRef, cusName, casRef, msgBoxDirIn, msgBoxDirOut, msgFromDat, msgToDat, msgSearchBy, msgUnread, msgFilter);

		hmMessage.put(101, message);
		return hmMessage;
	}
	
	@RequestMapping(value = "list_messages", method = RequestMethod.GET)
	public List<Message> getListMessage() {
		setUp();
		listMessage = new ArrayList<>();
		listMessage = messageDao.getListMessage("TEST_GNAC3YKW2JA2002697");
		return listMessage;
	}
}
