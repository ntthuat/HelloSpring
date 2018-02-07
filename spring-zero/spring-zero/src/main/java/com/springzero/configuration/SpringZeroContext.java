package com.springzero.configuration;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
public class SpringZeroContext {
	private static SpringZeroContext springZeroContext = null;

	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}
	
	private SpringZeroContext() {
	}

	public static void init(DataSource dataSource) {
		System.out.println("Thuat T Nguyen - excute method init() in SpringZeroContext");
		if (springZeroContext == null) {
			springZeroContext = new SpringZeroContext();
			springZeroContext.dataSource = dataSource;
			
			springZeroContext.jdbcTemplate = new JdbcTemplate(dataSource);
			springZeroContext.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			
			// setup runtime Context from codix.imxlib.int:bo
			/*RuntimeContext.setContextFactory(new ContextFactory() {
				final Connection conn = messagesContext.getDataSource().getConnection();

				public Context createContext() {
					Context ctx = new Context();
					try {
						ctx.setDatabaseConnection(conn);
					} catch (Exception e) {
						throw new RuntimeException("failed to open a connection");
					}
					ctx.setRunnerName("ecom_ws");
					return ctx;
				}

				public void disposeContext() {
					try {
						conn.rollback();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					jdbc.close(conn);
				}
			});*/
		}
	}

	public static SpringZeroContext getContext() throws Error {
		if (springZeroContext == null) {
			throw new Error("SpringZeroContext was not initialized -> null");
		} else {
			return springZeroContext;
		}
	}
}
