package com.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.MessageRequest;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 *
 */
public class MessageMapper implements RowMapper<MessageRequest> {

	/**
	 * @param rs the ResultSet to map (pre-initialized for the current row)
	 * @param rowNum the number of the current row
	 * @return the result object for the current row
	 */
	@Override
	public MessageRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setCusExRef(rs.getString("cusExRef"));
		messageRequest.setCusName(rs.getString("cusName"));
		messageRequest.setCasRef(rs.getString("casRef"));
		messageRequest.setMsgBoxDirIn(rs.getString("msgBoxDirIn"));
		messageRequest.setMsgBoxDirOut(rs.getString("msgBoxDirOut"));
		messageRequest.setMsgFromDat(rs.getString("msgFromDat"));
		messageRequest.setMsgToDat(rs.getString("msgToDat"));
		//message.setMsgSearchBy("");
		// message.setMsgUnread(rs.getBoolean("msgUnread"));
		return messageRequest;
	}

}
