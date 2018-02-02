package com.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.MessageDao;
import com.demo.model.MessageRequest;
import com.demo.model.MessageResponse;
import com.demo.model.MessageStatus;
import com.demo.utils.MessageUtils;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 * 
 */
@Service
public class MessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	public static HashMap<Integer, MessageRequest> hmMessage;
	
	public static HashMap<Integer, MessageResponse> hmMessageResponse;

	public static List<MessageRequest> listMessage;

	public HashMap<Integer, MessageRequest> getMessage(String cusExRef) {
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
		hmMessage = new HashMap<>();
		final MessageRequest messageRequest;
		messageRequest = messageDao.getMessage(cusExRef, cusName, casRef, msgBoxDirIn, msgBoxDirOut, msgFromDat,
				msgToDat, msgSearchBy, msgUnread, msgFilter);

		hmMessage.put(101, messageRequest);
		return hmMessage;
	}
	
	public List<MessageRequest> getListMessageRequest() {
		listMessage = new ArrayList<>();
		listMessage = messageDao.getListMessage("TEST_GNAC3YKW2JA2002697");
		return listMessage;
	}
	
	public MessageResponse getMessageResponse() {
		final MessageResponse message;
		message = messageDao.getMessageResponse("A600O5AQ");
		return message;
	}
	
	public List<Map<String, Object>> getMessage(MessageRequest messageRequest) {
		return messageDao.getMessage(messageRequest);
	}
	
	public List<MessageResponse> getListMessage(MessageRequest messageRequest) {
		List<Map<String, Object>> messageRequestList = messageDao.getMessage(messageRequest);
		List<MessageResponse> messageResponseList = new ArrayList<>();
		for (Map<String, Object> messageRequestMap : messageRequestList) {
			MessageResponse messageResponse = setMessageResponseFromMessageRequest(messageRequestMap);
			messageResponseList.add(messageResponse);
		}
		return messageResponseList;
	}
	
	private MessageResponse setMessageResponseFromMessageRequest(Map<String, Object> messageRequestMap){
		MessageResponse messageResponse = new MessageResponse();
		
		MessageStatus messageStatus = new MessageStatus();
		messageStatus.setAnswerRequested(MessageUtils.getBoolean((String)messageRequestMap.get("isReplyReq")));
		messageStatus.setAttachment(MessageUtils.getBoolean((String)messageRequestMap.get("isAttachment")));
		messageStatus.setUrgent(MessageUtils.getBoolean((String)messageRequestMap.get("isUrgent")));
		messageStatus.setImportant(MessageUtils.getBoolean((String)messageRequestMap.get("isImportant")));
		messageStatus.setToRead(MessageUtils.getBoolean((String)messageRequestMap.get("isRead")));
		
		messageResponse.setCasRef((String)messageRequestMap.get("casRef"));
		messageResponse.setDbName((String)messageRequestMap.get("dbName"));
		messageResponse.setCreditorName((String)messageRequestMap.get("creditorName"));
		messageResponse.setMsgRefInfo((String)messageRequestMap.get("msgRefInfo"));
		messageResponse.setMsgDat((Date)messageRequestMap.get("msgDat"));
		messageResponse.setMsgFrom((String)messageRequestMap.get("msgFrom"));
		messageResponse.setMsgTo((String)messageRequestMap.get("msgTo"));
		messageResponse.setMsgSubject((String)messageRequestMap.get("msgSubject"));
		messageResponse.setCasExRef((String)messageRequestMap.get("casExRef"));
		
		messageRequestMap.put("msgStatus", messageStatus.toString());
		
		messageResponse.setMsgStatus((String)messageRequestMap.get("msgStatus"));
		
		return messageResponse;
	}
}
