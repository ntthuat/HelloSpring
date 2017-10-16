package com.springzero.inmemory.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchUpdateUtils;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;

/**
 * 
 * @author tnguyen443
 * @version 10/16/2017
 */
public class InMemoryBatchUtils extends BatchUpdateUtils implements ConnectionCallback<Integer>{
	
	/**
     * logger definition
     */
    protected static final Logger logger = LoggerFactory.getLogger(InMemoryBatchUtils.class);

    /** ParsedSql cache */
	private static Map<String, ParsedSql> cacheParsedSql = new Hashtable<>();
	
	/** batch values */
	private final Map<String, Object>[] batchValuesArray;
	
	/** batch sql */
	private final String sql;
	
	/**
	 * Create new <code>InMemoryBatchUtils</code> with parameters
	 * 
	 * @param sql sql statement
	 * @param batchValuesArray batch values
	 */
	public InMemoryBatchUtils(final String sql, final Map<String, Object>[] batchValuesArray) {
		this.sql = sql;
		this.batchValuesArray = batchValuesArray;
	}
	
	public Integer doInConnection(final Connection con) throws SQLException, DataAccessException{
		int ret = 0;
		PreparedStatement ps = null;
		ParsedSql parsedSql = null;
		String sqlToUse = null;
		final boolean isAutoCommit = con.getAutoCommit();
		try {
			parsedSql = cacheParsedSql.get(sql);
			if (ps == null) {
				parsedSql = NamedParameterUtils.parseSqlStatement(sql);
				sqlToUse = NamedParameterUtils.substituteNamedParameters(parsedSql,
				    new MapSqlParameterSource(batchValuesArray[0]));
				cacheParsedSql.put(sql, parsedSql);
			}
			
			ps = con.prepareStatement(sqlToUse);
			ps.setPoolable(true);
			
			for (int i = 0; i < batchValuesArray.length; i++) {
				MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource(batchValuesArray[i]);

				Object[] values = NamedParameterUtils.buildValueArray(parsedSql, sqlParameterSource, null);
				int[] columnTypes = NamedParameterUtils.buildSqlTypeArray(parsedSql, sqlParameterSource);
				BatchUpdateUtils.setStatementParameters(values, ps, columnTypes);
				ps.addBatch();
			}
			
			ps.executeBatch();
			if (!isAutoCommit) {
				con.commit();
				
			}
		} catch (SQLException sqlEx) {
			if (!isAutoCommit) {
				con.rollback();
			}
			throw sqlEx;
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		
		return Integer.valueOf(ret);
	}
}

/**
 * Maven Library:
 * 1. ParsedSql
 * 	<dependency>
 *	<groupId>org.springframework</groupId>
 *	<artifactId>spring-jdbc</artifactId>
 *	<version>${spring-version}</version>
 *	</dependency>
 *
 */

