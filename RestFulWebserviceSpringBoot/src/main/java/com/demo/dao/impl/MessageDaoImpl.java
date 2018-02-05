package com.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.constant.TableConstants;
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
	
	private static final Logger logger = LoggerFactory.getLogger(MessageDaoImpl.class);

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
	
	private String buildSELECTStatementSQL() {
		StringJoiner selectSQL = new StringJoiner(TableConstants.COMMA_SP);
		selectSQL.add(TableConstants.t_elements_temp + ".refdoss" + " casRef");
		selectSQL.add(TableConstants.g_information_temp + ".refinfo" + " msgRefInfo");
		selectSQL.add(TableConstants.g_individu_temp + ".refext" + " cusExRef");
		selectSQL.add(TableConstants.g_individu_temp + ".nom" + " creditorName");
		selectSQL.add("dbi.nom" + " dbName");
		selectSQL.add(TableConstants.g_information_temp + ".dtsaisie_dt" + " msgDat");
		selectSQL.add(TableConstants.g_information_temp + ".refemetteur" + " msgFrom");
		selectSQL.add(TableConstants.g_information_temp + ".encodeur" + " msgTo");
		selectSQL.add(TableConstants.g_information_temp + ".libelinfo" + " msgSubject");
		selectSQL.add(TableConstants.g_information_temp + ".typedoc" + " isRead");
		selectSQL.add(TableConstants.g_information_temp + ".fg_urgent" + " isUrgent");
		selectSQL.add(TableConstants.g_information_temp + ".fg_important" + " isImportant");
		selectSQL.add(TableConstants.g_information_temp + ".str_10_1" + " isReplyReq");
		selectSQL.add(TableConstants.g_information_temp + ".typemetteur" + " isAttachment");
		selectSQL.add(TableConstants.t_intervenants_temp + ".refdossext" + " casExRef");
		return selectSQL.toString();
	}
	
	/**
	 * Build FROM Statement SQL
	 * 
	 * @param tables
	 * @return
	 */
	private String buildWHEREStatementSQL(MessageRequest messageRequest) {
		StringJoiner whereSQL = new StringJoiner(" AND ");
		whereSQL.add("1=1");
		if (messageRequest.getCusName() != null) {
			whereSQL.add("(cusi.nom LIKE :cusName)");
		}
		if (messageRequest.getCusExRef() != null) {
			whereSQL.add("(cusi.refext LIKE :cusExRef)");
		}
		if (messageRequest.getCasRef() != null) {
			whereSQL.add("(elem.refdoss LIKE :casRef)");
		}
		if (messageRequest.getMsgBoxDirIn() != null) {
			whereSQL.add("(msg.encodeur LIKE :msgBoxDirIn)");
		}
		if (messageRequest.getMsgBoxDirOut() != null) {
			whereSQL.add("(msg.refemetteur LIKE :msgBoxDirOut)");
		}
		if (messageRequest.getMsgFromDat() != null) {
			whereSQL.add("(msg.dtsaisie_dt >= to_date(:msgFromDat, 'YYYY-MM-DD'))");
		}
		if (messageRequest.getMsgToDat() != null) {
			whereSQL.add("(msg.dtsaisie_dt >= to_date(:msgToDat, 'YYYY-MM-DD') + 1)");
		}
		if (messageRequest.getMsgUnread() !=null ) {
			if (messageRequest.getMsgUnread() == true) {
				whereSQL.add("(nvl(msg.typedoc, 'N') = 'N')");
			}
		}
		if (messageRequest.getMsgSearchBy() != null) {
			if (messageRequest.getMsgSearchBy().equals("from")) {
				whereSQL.add("(msg.refemetteur LIKE :msgFilter)");
			}
			if (messageRequest.getMsgSearchBy().equals("to")) {
				whereSQL.add("(msg.encodeur LIKE :msgFilter)");
			}
			if (messageRequest.getMsgSearchBy().equals("subject")) {
				whereSQL.add("(msg.libelinfo LIKE :msgFilter)");
			}
			if (messageRequest.getMsgSearchBy().equals("case")) {
				whereSQL.add("(elem.refdoss LIKE :msgFilter OR msg.refext2 LIKE :msgFilter)");
			}
			if (messageRequest.getMsgSearchBy().equals("debtor")) {
				whereSQL.add("(dbi.nom LIKE :msgFilter)");
			}
		}
		
		whereSQL.add("(customer.reftype = 'CL')");
		
		whereSQL.add("(debtor.reftype = 'DB')");
		whereSQL.add("(debtor.refindividu = dbi.refindividu)");
		whereSQL.add("(elem.refdoss = debtor.refdoss (+))");
		
		whereSQL.add("(elem.typeelem = 'ms')");
		whereSQL.add("("+TableConstants.t_intervenants_temp + ".refindividu" + "=" + TableConstants.g_individu_temp + ".refindividu"+")");
		whereSQL.add("("+TableConstants.t_elements_temp + ".refdoss" + "=" + TableConstants.t_intervenants_temp + ".refdoss (+)"+")");
		whereSQL.add("("+TableConstants.g_information_temp + ".refinfo" + "=" + TableConstants.t_elements_temp + ".refelem"+")");
		/*s*/
		return whereSQL.toString();
	}
	
	/**
	 * Build FROM Statement SQL
	 * 
	 * @param tables
	 * @return
	 */
	private String buildFROMStatementSQL(final String...tables ) {
		StringJoiner fromSQL = new StringJoiner(TableConstants.COMMA_SP);
		for (String table : tables) {
			fromSQL.add(table + TableConstants.SPACE + TableConstants.tableMap.get(table));
		}
		
		fromSQL.add("t_intervenants debtor");
		fromSQL.add("g_individu dbi");
		
		return fromSQL.toString();
	}
	
	/**
	 * for test: 
	 * cusExRef=TEST_GNAC3YKW2JA2002697
	 * casRef=1406160015
	 * 
	 * @param messageRequest
	 * @return
	 */
	@Override
	@Transactional
	public List<Map<String, Object>> getMessage(MessageRequest messageRequest) {
		Map<String, Object> argsMap = new HashMap<>();
		argsMap.put("cusExRef", messageRequest.getCusExRef());
		argsMap.put("cusName", messageRequest.getCusName());
		argsMap.put("casRef", messageRequest.getCasRef());
		argsMap.put("msgBoxDirIn", messageRequest.getMsgBoxDirIn());
		argsMap.put("msgBoxDirOut", messageRequest.getMsgBoxDirOut());
		argsMap.put("msgFromDat", messageRequest.getMsgFromDat());
		argsMap.put("msgToDat", messageRequest.getMsgToDat());
		argsMap.put("msgUnread", messageRequest.getMsgUnread());
		argsMap.put("msgFilter", messageRequest.getMsgFilter());
		argsMap.put("msgSearchBy", messageRequest.getMsgSearchBy());
		
		StringBuffer statementSQL = new StringBuffer();
		
		// build SELECT statement SQL
		statementSQL.append("SELECT ");
		statementSQL.append(buildSELECTStatementSQL());
		
		// build FROM statement SQL
		statementSQL.append(" FROM ");
		statementSQL.append(buildFROMStatementSQL(TableConstants.g_individu, TableConstants.g_information, TableConstants.t_intervenants, TableConstants.t_elements));
		
		// build WHERE statement SQL
		statementSQL.append(" WHERE ");
		statementSQL.append(buildWHEREStatementSQL(messageRequest));
		
		statementSQL.append(" ORDER BY elem.refdoss, msg.dtsaisie_dt DESC NULLS LAST");
		
		logger.debug(statementSQL.toString());
		return namedParameterJdbcTemplate.queryForList(statementSQL.toString(), argsMap);
	}
}
