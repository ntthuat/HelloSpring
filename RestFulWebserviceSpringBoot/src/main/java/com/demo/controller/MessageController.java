package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.MessageRequest;
import com.demo.model.MessageResponse;
import com.demo.service.MessageService;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 * 
 */
@RestController
@RequestMapping(value = "/")
public class MessageController {
	
	@Autowired
	private MessageService messageSerivce;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "message", method = RequestMethod.GET)
	public HashMap<Integer, MessageRequest> getMessage(@RequestParam(value = "cusExRef", required = false) String cusExRef) {
		return messageSerivce.getMessage(cusExRef);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "messageFullParameter", method = RequestMethod.GET)
	public HashMap<Integer, MessageRequest> getMessageFullParameter(
			@RequestParam(value = "cusExRef", required = false) String cusExRef,
			@RequestParam(value = "cusName", required = false) String cusName,
			@RequestParam(value = "casRef", required = false) String casRef,
			@RequestParam(value = "msgBoxDirIn", required = false) String msgBoxDirIn,
			@RequestParam(value = "msgBoxDirOut", required = false) String msgBoxDirOut,
			@RequestParam(value = "msgFromDat", required = false) String msgFromDat,
			@RequestParam(value = "msgToDat", required = false) String msgToDat,
			@RequestParam(value = "msgSearchBy", required = false) String msgSearchBy,
			@RequestParam(value = "msgUnread", required = false) Boolean msgUnread,
			@RequestParam(value = "msgFilter", required = false) String msgFilter) {
		return messageSerivce.getMessageFullParameter(cusExRef, cusName, casRef, msgBoxDirIn, msgBoxDirOut, msgFromDat,
				msgToDat, msgSearchBy, msgUnread, msgFilter);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "list_messages_request", method = RequestMethod.GET)
	public List<MessageRequest> getListMessageRequest() {
		return messageSerivce.getListMessageRequest();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "message_response", method = RequestMethod.GET)
	public MessageResponse getMessageResponse() {
		return messageSerivce.getMessageResponse();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "list_messages", method = RequestMethod.GET)
	public List<MessageResponse> getListMessage(MessageRequest messageRequest,
			@RequestParam(value = "cusExRef", required = false) String cusExRef,
			@RequestParam(value = "cusName", required = false) String cusName,
			@RequestParam(value = "casRef", required = false) String casRef,
			@RequestParam(value = "msgBoxDirIn", required = false) String msgBoxDirIn,
			@RequestParam(value = "msgBoxDirOut", required = false) String msgBoxDirOut,
			@RequestParam(value = "msgFromDat", required = false) String msgFromDat,
			@RequestParam(value = "msgToDat", required = false) String msgToDat,
			@RequestParam(value = "msgSearchBy", required = false) String msgSearchBy,
			@RequestParam(value = "msgUnread", required = false) Boolean msgUnread,
			@RequestParam(value = "msgFilter", required = false) String msgFilter) {
		return messageSerivce.getListMessage(messageRequest);
	}
	
	/**
	 * 
	 * address test: http://localhost:8080/test/list_messages?cusExRef=TEST_GNAC3YKW2JA2002697&casRef=1406160015
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/test/list_messages", method = RequestMethod.GET)
	public List<Map<String, Object>> getListMessageTest1(MessageRequest messageRequest,
			@RequestParam(value = "cusExRef", required = false) String cusExRef,
			@RequestParam(value = "cusName", required = false) String cusName,
			@RequestParam(value = "casRef", required = false) String casRef,
			@RequestParam(value = "msgBoxDirIn", required = false) String msgBoxDirIn,
			@RequestParam(value = "msgBoxDirOut", required = false) String msgBoxDirOut,
			@RequestParam(value = "msgFromDat", required = false) String msgFromDat,
			@RequestParam(value = "msgToDat", required = false) String msgToDat,
			@RequestParam(value = "msgSearchBy", required = false) String msgSearchBy,
			@RequestParam(value = "msgUnread", required = false) Boolean msgUnread,
			@RequestParam(value = "msgFilter", required = false) String msgFilter) {
		return messageSerivce.getMessage(messageRequest);
	}
}
