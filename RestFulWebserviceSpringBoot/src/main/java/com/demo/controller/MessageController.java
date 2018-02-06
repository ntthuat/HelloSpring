package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
/*@RequestMapping(value = "/")*/
@Api(name = "Messages", description = "Messages API")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageService messageSerivce;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list_messages", method = RequestMethod.GET)
	@ApiMethod(description = "Acquire the data of the list of messages")
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
		
		logger.info("Going to getlistMessage...");
		
		return messageSerivce.getListMessage(messageRequest);
	}
}
