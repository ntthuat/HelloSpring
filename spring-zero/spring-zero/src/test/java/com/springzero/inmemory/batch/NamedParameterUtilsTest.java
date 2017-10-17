package com.springzero.inmemory.batch;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Helper methods for named parameter parsing.
 * 
 * @author tnguyen443
 * @version 10/16/2017
 */
public class NamedParameterUtilsTest {
	
	/*@Autowired
	private DataSource jdbcDataSource;*/ // Để làm được cái autowired này, cần biến class này thành instance, mà mình chưa làm được
	
	private Connection connection;
	
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	
	public Connection getConnection() {
        return connection;
    }
 
	@Before
	public void setUp() throws SQLException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bean-dao-jdbc-2.xml");
		NamedParameterUtilsTest test = (NamedParameterUtilsTest) context.getBean("namedParameterUtilsTest");
		connection = test.getConnection();
		/*jdbcDataSource = context.getBean(requiredType)*/
		/*connection = jdbcDataSource.getConnection();*/
	}
	
	@Test
	public void testParseSqlStatement() throws SQLException{
		//ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement("SELECT id FROM emp WHERE age=:age");
		ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement("SELECT name FROM employee WHERE id=:id");
		SqlParameterSource source = new MapSqlParameterSource("id", 2); // name=Max when id=2
		String finalQuery = new PreparedStatementCreatorFactory(NamedParameterUtils.substituteNamedParameters(parsedSql,
                source), NamedParameterUtils.buildSqlTypeArray(parsedSql, source))
                .newPreparedStatementCreator(NamedParameterUtils.buildValueArray(parsedSql, source, null))
                .createPreparedStatement(connection).toString();
		System.out.println("---End testParseSqlStatement---");
	}
}
