package com.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Message;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 *
 */
public class MessageMapper implements RowMapper<Message> {

	/**
	 * @param rs the ResultSet to map (pre-initialized for the current row)
	 * @param rowNum the number of the current row
	 * @return the result object for the current row
	 */
	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setCusExRef(rs.getString("cusExRef"));
		message.setCusName(rs.getString("cusName"));
		message.setCasRef(rs.getString("casRef"));
		message.setMsgBoxDirIn(rs.getString("msgBoxDirIn"));
		message.setMsgBoxDirOut(rs.getString("msgBoxDirOut"));
		message.setMsgFromDat(rs.getString("msgFromDat"));
		message.setMsgToDat(rs.getString("msgToDat"));
		//message.setMsgSearchBy("");
		// message.setMsgUnread(rs.getBoolean("msgUnread"));
		return message;
	}

}
