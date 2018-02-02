package com.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.MessageResponse;

public class MessageResponseMapper implements RowMapper<MessageResponse> {

	@Override
	public MessageResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		MessageResponse message = new MessageResponse();
		message.setCasExRef(rs.getString("casExRef"));
		message.setMsgRefInfo(rs.getString("msgRefInfo"));
		message.setMsgDat(rs.getDate("msgDat"));
		message.setCasRef(rs.getString("casRef"));
		return message;
	}

}
