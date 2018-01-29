package com.demo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.dao.MessageDao;
import com.demo.mapper.MessageRequestMapper;
import com.demo.mapper.MessageResponseMapper;
import com.demo.model.MessageRequest;
import com.demo.model.MessageResponse;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 *
 */
@Component("messageDao")
public class MessageDaoImpl implements MessageDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private static final MessageResponseMapper responseMapper = new MessageResponseMapper();
	private static final MessageRequestMapper requestMapper = new MessageRequestMapper();

	
	@Override
	public MessageRequest getMessage2(final String cusExRef) {
		final String sql = "SELECT g.refext cusExRef, g.nom cusName FROM g_individu g WHERE g.refext=:cusExRef";
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("cusExRef", cusExRef);
		final MessageRequest messageRequest = namedParameterJdbcTemplate.queryForObject(sql, argsMap, requestMapper);
		return messageRequest;
	}

	@Override
	public MessageRequest getMessage(final String cusExRef) {
		final String sql = "SELECT individu.refext cusExRef, individu.nom cusName, elements.refdoss casRef, information.encodeur msgBoxDirIn, information.refemetteur msgBoxDirOut, "
				+ "information.dtsaisie_dt msgFromDat, information.dtsaisie_dt msgToDat, information.typedoc msgUnread "
				+ "FROM " + "g_individu individu, " + "g_information information, " + "t_intervenants intervenants, "
				+ "t_elements elements " + "WHERE individu.refext=:cusExRef AND "
				+ "intervenants.refindividu = individu.refindividu AND "
				+ "elements.refdoss = intervenants.refdoss AND " + "information.refinfo = elements.refelem AND "
				+ "ROWNUM <= 1";
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("cusExRef", cusExRef);
		final MessageRequest messageRequest = namedParameterJdbcTemplate.queryForObject(sql, argsMap, requestMapper);
		return messageRequest;
	}

	/**
	 * for test: TEST_GNAC3YKW2JA2002697
	 */
	@Override
	public MessageRequest getMessage(final String cusExRef, final String cusName, final String casRef,
			final String msgBoxDirIn, final String msgBoxDirOut, final String msgFromDat, final String msgToDat,
			final String msgSearchBy, final Boolean msgUnread, final String msgFilter) {
		final String sql = "SELECT individu.refext cusExRef, individu.nom cusName, elements.refdoss casRef, information.encodeur msgBoxDirIn, information.refemetteur msgBoxDirOut, "
				+ "information.dtsaisie_dt msgFromDat, information.dtsaisie_dt msgToDat, information.typedoc msgUnread "
				+ "FROM " + "g_individu individu, " + "g_information information, " + "t_intervenants intervenants, "
				+ "t_elements elements " + "WHERE individu.refext=:cusExRef AND "
				+ "intervenants.refindividu = individu.refindividu AND "
				+ "elements.refdoss = intervenants.refdoss AND " + "information.refinfo = elements.refelem AND "
				+ "ROWNUM <= 1";
		final MessageRequestMapper mapper = new MessageRequestMapper();
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("cusExRef", cusExRef);
		final MessageRequest messageRequest = namedParameterJdbcTemplate.queryForObject(sql, argsMap, mapper);
		return messageRequest;
	}

	@Override
	public List<MessageRequest> getListMessage(final String cusExRef) {
		final String sql = "SELECT individu.refext cusExRef, individu.nom cusName, elements.refdoss casRef, information.encodeur msgBoxDirIn, information.refemetteur msgBoxDirOut, "
				+ "information.dtsaisie_dt msgFromDat, information.dtsaisie_dt msgToDat, information.typedoc msgUnread "
				+ "FROM " + "g_individu individu, " + "g_information information, " + "t_intervenants intervenants, "
				+ "t_elements elements " + "WHERE individu.refext=:cusExRef AND "
				+ "intervenants.refindividu = individu.refindividu AND "
				+ "elements.refdoss = intervenants.refdoss AND " + "information.refinfo = elements.refelem ";

		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("cusExRef", cusExRef);
		List<MessageRequest> list = namedParameterJdbcTemplate.query(sql, argsMap, requestMapper);
		return list;
	}
	
	/**
	 * Have mapped:
	 * 1. casExRef
	 * 2. msgRefInfo
	 * 3. msgDat
	 * 4. 
	 * 
	 * @param msgRefInfo
	 * @return
	 */
	public MessageResponse getMessageResponse(final String msgRefInfo) {
		final String sql = 
				"SELECT " + 
				"message.refinfo msgRefInfo, " + 
				"message.dtsaisie_dt msgDat, " + 
				"message.refemetteur msgFrom, " + 
				"message.libelinfo msgSubject, " + 
				"ti.refdossext casExRef, " + 
				"gi.nom creditorName, " + 
				"te.refdoss casRef " +
				"FROM " + 
				"g_information message, " + 
				"t_elements te, " + 
				"t_intervenants ti, " + 
				"g_individu gi " + 
				"WHERE te.refelem=message.refinfo " + 
				"AND ti.refdoss = te.refdoss " +
				"AND gi.refindividu = ti.refindividu " +
				"AND message.refinfo=:msgRefInfo " +
				"AND ROWNUM <= 1"
				;
		
		Map<String, String> argsMap = new HashMap<>();
		argsMap.put("msgRefInfo", msgRefInfo);
		final MessageResponse message = namedParameterJdbcTemplate.queryForObject(sql, argsMap, responseMapper);
		return message;
	}
	
	/**
	 * for test: TEST_GNAC3YKW2JA2002697
	 * 
	 * @param messageRequest
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getMessage(MessageRequest messageRequest) {
		Map<String, Object> argsMap = new HashMap<>();
		StringBuffer statementSQL = new StringBuffer();
		statementSQL.append(" SELECT ");
		
		StringJoiner selectSQL = new StringJoiner(", ");
		selectSQL.add("g_indi.refext cusExRef");
		selectSQL.add("g_indi.nom cusName");
		selectSQL.add("g_indi.nom dbName");
		selectSQL.add("g_indi.nom creditorName");
		selectSQL.add("t_ele.refdoss casRef");
		selectSQL.add("g_infor.encodeur msgBoxDirIn");
		selectSQL.add("g_infor.refemetteur msgBoxDirOut");
		selectSQL.add("g_infor.dtsaisie_dt msgFromDat");
		selectSQL.add("g_infor.dtsaisie_dt msgToDat");
		selectSQL.add("g_infor.typedoc msgUnread");
		selectSQL.add("g_infor.refinfo msgRefInfo");
		statementSQL.append(selectSQL.toString());
		
		statementSQL.append(" FROM ");
		
		StringJoiner fromSQL = new StringJoiner(", ");
		fromSQL.add("g_individu g_indi");
		fromSQL.add("g_information g_infor");
		fromSQL.add("t_intervenants t_inter");
		fromSQL.add("t_elements t_ele");
		statementSQL.append(fromSQL.toString());
		
		statementSQL.append(" WHERE ");
		
		StringJoiner whereSQL = new StringJoiner(" AND ");
		whereSQL.add("1=1");
		if (messageRequest.getCusExRef() != null) {
			whereSQL.add("g_indi.refext=:cusExRef");
			argsMap.put("cusExRef", messageRequest.getCusExRef());
		}
		if (messageRequest.getCusName() != null) {
			whereSQL.add("g_indi.nom=:cusName");
			argsMap.put("cusName", messageRequest.getCusName());
		}
		if (messageRequest.getCasRef() != null) {
			whereSQL.add("t_ele.refdoss=:casRef");
			argsMap.put("casRef", messageRequest.getCasRef());
		}
		if (messageRequest.getMsgBoxDirIn() != null) {
			whereSQL.add("g_infor.encodeur=:msgBoxDirIn");
			argsMap.put("msgBoxDirIn", messageRequest.getMsgBoxDirIn());
		}
		if (messageRequest.getMsgBoxDirOut() != null) {
			whereSQL.add("g_infor.refemetteur=:msgBoxDirOut");
			argsMap.put("msgBoxDirOut", messageRequest.getMsgBoxDirOut());
		}
		if (messageRequest.getMsgFromDat() != null) {
			whereSQL.add("g_infor.dtsaisie_dt=:msgFromDat");
			argsMap.put("msgFromDat", messageRequest.getMsgFromDat());
		}
		if (messageRequest.getMsgToDat() != null) {
			whereSQL.add("g_infor.dtsaisie_dt=:msgToDat");
			argsMap.put("msgToDat", messageRequest.getMsgToDat());
		}
		if (messageRequest.getMsgUnread() != null) {
			whereSQL.add("g_infor.typedoc=:msgUnread");
			argsMap.put("msgUnread", messageRequest.getMsgUnread());
		}
		whereSQL.add("t_inter.refindividu = g_indi.refindividu");
		whereSQL.add("t_ele.refdoss = t_inter.refdoss");
		whereSQL.add("t_ele.refdoss = t_inter.refdoss");
		whereSQL.add("g_infor.refinfo = t_ele.refelem");
		statementSQL.append(whereSQL.toString());
		
		List<Map<String, Object>> list = new ArrayList<>();
		argsMap.put("cusName", messageRequest.getCusName());
		argsMap.put("casRef", messageRequest.getCasRef());
		argsMap.put("msgBoxDirIn", messageRequest.getMsgBoxDirIn());
		argsMap.put("msgBoxDirOut", messageRequest.getMsgBoxDirOut());
		argsMap.put("msgFromDat", messageRequest.getMsgFromDat());
		argsMap.put("msgToDat", messageRequest.getMsgToDat());
		argsMap.put("msgUnread", messageRequest.getMsgUnread());
		argsMap.put("msgFilter", messageRequest.getMsgFilter());
		list = namedParameterJdbcTemplate.queryForList(statementSQL.toString(), argsMap);
		return list;
	}
}
