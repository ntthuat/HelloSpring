package com.demo.dao;

import java.util.List;

import com.demo.model.Message;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 *
 */
public interface MessageDao {
	
	public Message getMessage(final String cusExRef);

	public List<Message> getListMessage(final String cusExRef);

	public Message getMessage2(final String cusExRef);

	public Message getMessage(final String cusExRef, final String cusName, final String casRef,
			final String msgBoxDirIn, final String msgBoxDirOut, final String msgFromDat, final String msgToDat,
			final String msgSearchBy, final Boolean msgUnread, final String msgFilter);
}
