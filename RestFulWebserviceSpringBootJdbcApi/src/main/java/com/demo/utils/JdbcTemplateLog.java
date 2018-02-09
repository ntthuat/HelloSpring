package com.demo.utils;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/08/2018
 *
 */
public class JdbcTemplateLog extends JdbcTemplate {
	
	private static Logger logger = Logger.getLogger(JdbcTemplateLog.class);

	public JdbcTemplateLog() {
	}

	public JdbcTemplateLog(DataSource dataSource) {
		super(dataSource);
	}

	public JdbcTemplateLog(DataSource dataSource, boolean lazyInit) {
		super(dataSource, lazyInit);
	}

	@Override
	public int update(String sql, Object... args) throws DataAccessException {
		String sqlLog = str.substituteSQLBindings(sql, args);
		logger.info(sqlLog);
		return super.update(sql, args);
	}

	@Override
	public <T> T queryForObject(String sql, Class<T> clazz, Object... args) throws DataAccessException {
		String sqlLog = str.substituteSQLBindings(sql, args);
		logger.info(sqlLog);
		return super.queryForObject(sql, clazz, args);
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql, Object... args) throws DataAccessException {
		String sqlLog = str.substituteSQLBindings(sql, args);
		logger.info(sqlLog);
		return super.queryForList(sql, args);
	}

}
