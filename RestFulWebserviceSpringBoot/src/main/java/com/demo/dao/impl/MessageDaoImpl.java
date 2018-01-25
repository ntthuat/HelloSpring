package com.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.dao.MessageDao;
import com.demo.mapper.MessageMapper;
import com.demo.model.Message;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 *
 */
@Component("messageDao")
public class MessageDaoImpl implements MessageDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Message getMessage2(final String cusExRef) {
		final String sql = "SELECT g.refext cusExRef, g.nom cusName FROM g_individu g WHERE g.refext=:cusExRef";
		final MessageMapper mapper = new MessageMapper();
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("cusExRef", cusExRef);
		final Message message = namedParameterJdbcTemplate.queryForObject(sql, argsMap, mapper);
		return message;
	}

	@Override
	public Message getMessage(final String cusExRef) {
		final String sql = "SELECT individu.refext cusExRef, individu.nom cusName, elements.refdoss casRef, information.encodeur msgBoxDirIn, information.refemetteur msgBoxDirOut, "
				+ "information.dtsaisie_dt msgFromDat, information.dtsaisie_dt msgToDat, information.typedoc msgUnread "
				+ "FROM " + "g_individu individu, " + "g_information information, " + "t_intervenants intervenants, "
				+ "t_elements elements " + "WHERE individu.refext=:cusExRef AND "
				+ "intervenants.refindividu = individu.refindividu AND "
				+ "elements.refdoss = intervenants.refdoss AND " + "information.refinfo = elements.refelem AND "
				+ "ROWNUM <= 1";
		final MessageMapper mapper = new MessageMapper();
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("cusExRef", cusExRef);
		final Message message = namedParameterJdbcTemplate.queryForObject(sql, argsMap, mapper);
		return message;
	}

	@Override
	public Message getMessage(final String cusExRef, final String cusName, final String casRef,
			final String msgBoxDirIn, final String msgBoxDirOut, final String msgFromDat, final String msgToDat,
			final String msgSearchBy, final Boolean msgUnread, final String msgFilter) {
		final String sql = "SELECT individu.refext cusExRef, individu.nom cusName, elements.refdoss casRef, information.encodeur msgBoxDirIn, information.refemetteur msgBoxDirOut, "
				+ "information.dtsaisie_dt msgFromDat, information.dtsaisie_dt msgToDat, information.typedoc msgUnread "
				+ "FROM " + "g_individu individu, " + "g_information information, " + "t_intervenants intervenants, "
				+ "t_elements elements " + "WHERE individu.refext=:cusExRef AND "
				+ "intervenants.refindividu = individu.refindividu AND "
				+ "elements.refdoss = intervenants.refdoss AND " + "information.refinfo = elements.refelem AND "
				+ "ROWNUM <= 1";
		final MessageMapper mapper = new MessageMapper();
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("cusExRef", cusExRef);
		final Message message = namedParameterJdbcTemplate.queryForObject(sql, argsMap, mapper);
		return message;
	}

	@Override
	public List<Message> getListMessage(final String cusExRef) {
		final String sql = "SELECT individu.refext cusExRef, individu.nom cusName, elements.refdoss casRef, information.encodeur msgBoxDirIn, information.refemetteur msgBoxDirOut, "
				+ "information.dtsaisie_dt msgFromDat, information.dtsaisie_dt msgToDat, information.typedoc msgUnread "
				+ "FROM " + "g_individu individu, " + "g_information information, " + "t_intervenants intervenants, "
				+ "t_elements elements " + "WHERE individu.refext=:cusExRef AND "
				+ "intervenants.refindividu = individu.refindividu AND "
				+ "elements.refdoss = intervenants.refdoss AND " + "information.refinfo = elements.refelem ";
		final MessageMapper mapper = new MessageMapper();
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("cusExRef", cusExRef);
		List<Message> list = namedParameterJdbcTemplate.query(sql, argsMap, mapper);
		return list;
	}
}
