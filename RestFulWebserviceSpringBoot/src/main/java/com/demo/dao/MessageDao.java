package com.demo.dao;

import java.util.List;
import java.util.Map;

import com.demo.model.MessageRequest;
import com.demo.model.MessageResponse;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 *
 */
public interface MessageDao {
	
	public MessageRequest getMessage(final String cusExRef);

	public List<MessageRequest> getListMessage(final String cusExRef);

	public MessageRequest getMessage2(final String cusExRef);

	public MessageRequest getMessage(final String cusExRef, final String cusName, final String casRef,
			final String msgBoxDirIn, final String msgBoxDirOut, final String msgFromDat, final String msgToDat,
			final String msgSearchBy, final Boolean msgUnread, final String msgFilter);
	
	public MessageResponse getMessageResponse(final String msgRefInfo);
	
	public List<Map<String, Object>> getMessage(MessageRequest messageRequest);
}
