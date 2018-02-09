package com.demo.utils;

/*import codix.eu.soa_ws.common.exception.ConfigurationException;
import imx.util.jdbc;
import imx.util.prm;*/
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.demo.config.properties.DBProperties;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/08/2018
 *
 */
public class BasicDatasourceManager {

	/*private static Logger logger = Logger.getLogger(BasicDatasourceManager.class);

	public static final String DEFAULT_DB_DRIVER = "oracle.jdbc.OracleDriver";
	public static final String JDBC_ORACLE_THIN = "jdbc:oracle:thin:";
	public static final String DEFAULT_TNS_ENTRY = "C10";
	public static final String PROGRAM_TYPE_MARKER = "soa_integration";

	public static final int DEFAULT_MIN_IDLE = 1;
	public static final int DEFAULT_MAX_IDLE = 5;
	public static final int DEFAULT_MAX_ACTIVE = 15;

	private String dbURL;
	private boolean testOnBorrow = false;
	private String validationQuery;

	private DBProperties dbProperties;
	private Properties dbConnectionProperties = new Properties();

	private BasicDataSource bds = new BasicDataSource();

	public BasicDatasourceManager(DBProperties dbProperties) throws ConfigurationException {
		try {
			this.dbProperties = dbProperties;
			initDataSource();
			if (testOnBorrow) {
				validateConnection(this.getConnection());
			}
		} catch (ClassNotFoundException e) {
			logger.error(e, e);
			throw new ConfigurationException(e);
		} catch (SQLException e) {
			logger.error(e, e);
			throw new ConfigurationException(e);
		}
	}

	public BasicDataSource getBasicDataSource() {
		return bds;
	}

	public void initDataSource() throws SQLException, ClassNotFoundException {

		setupConnectionProperties();
		// the settings below are optional -- dbcp can work with defaults
		bds.setConnectionProperties(convertToBDSString(dbConnectionProperties));

		bds.setMinIdle(DEFAULT_MIN_IDLE);
		bds.setMaxIdle(DEFAULT_MAX_IDLE);
		bds.setMaxActive(DEFAULT_MAX_ACTIVE);
		bds.setDefaultAutoCommit(false);
	}

	private String convertToBDSString(Properties dbConnectionProperties) {
		StringBuilder properties = new StringBuilder();
		properties.append("[");
		logger.info(dbConnectionProperties.toString());
		for (Object o : dbConnectionProperties.keySet()) {
			String property = o.toString() + "=" + dbConnectionProperties.get(o) + ";";
			properties.append(property);
		}
		properties.append("]");

		return properties.toString();
	}

	public Connection getConnection() throws SQLException {
		return bds.getConnection();
	}

	private void validateConnection(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(validationQuery);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				throw new SQLException("Connection validation query returned no rows!!");
			}
		} finally {
			jdbc.close(rs);
			jdbc.close(pstmt);
		}
	}

	private void setupConnectionProperties() throws SQLException, ClassNotFoundException {
		// choose a driver to use
		String dbDriver = str.nvl(System.getProperty("db.driver", dbProperties.getDriver()),
				System.getenv("IMX_INT_DBDRV"));
		if (prm.isEmpty(dbDriver)) {
			dbDriver = DEFAULT_DB_DRIVER;
		}

		dbConnectionProperties = new Properties();
		dbConnectionProperties.put("SetBigStringTryClob", "true");
		dbConnectionProperties.put("v$session.program", PROGRAM_TYPE_MARKER);

		// figure if wallet is to be used or not
		if (useWallet()) {
			logger.info("Using wallet method");

			// fetch check we have a usable wallet location
			String walletLocation = findWalletLocation();
			if (prm.isEmpty(walletLocation)) {
				throw new SQLException("Was set up to use wallet but couldn't find passed WALLET_LOCATION property");
			}

			// fetch check we have a usable TNS_ADMIN location
			String tnsAdminPath = findTNSAdminLocation();
			if (prm.isEmpty(tnsAdminPath)) {
				throw new SQLException("Was set up to use wallet but couldn't find passed usable TNS_ADMIN property");
			}

			// figure the TNS entry to use - it always defaults to C10 if nothing is passed
			// so we don't check it here
			String tnsEntry = findTNSEntry();
			// set up dbURL variable to point valid:db:url:/@WALLET_ALIAS
			logger.info("Ignoring any passed dbURL, using only TNS entry -> " + tnsEntry);

			dbURL = JDBC_ORACLE_THIN + "/@" + tnsEntry;
			System.setProperty("oracle.net.tns_admin", tnsAdminPath);
			System.setProperty("oracle.net.wallet_location", walletLocation);
		} else {
			logger.info("Using plain user/password method");

			String dbUser = str.nvl(System.getProperty("db.user", dbProperties.getUser()),
					System.getenv("IMX_INT_DBUSR"));
			String dbPassword = str.nvl(System.getProperty("db.password", dbProperties.getPassword()),
					System.getenv("IMX_INT_DBPWD"));

			if (prm.isEmpty(dbUser)) {
				throw new SQLException("Can't find configuration parameter for the database USER to use");
			}
			if (prm.isEmpty(dbPassword)) {
				throw new SQLException("Can't find configuration parameter for the database PASSWORD to use");
			}

			bds.setUsername(dbUser);
			bds.setPassword(dbPassword);
			String tnsAdminPath = findTNSAdminLocation();
			if (!prm.isEmpty(tnsAdminPath)) {
				System.setProperty("oracle.net.tns_admin", tnsAdminPath);

				// figure the TNS entry to use - it always defaults to C10 if nothing is passed
				// so we don't check it here
				String tnsEntry = findTNSEntry();
				logger.info("Ignoring any passed dbURL, using only TNS entry -> " + tnsEntry);
				dbURL = JDBC_ORACLE_THIN + "/@" + tnsEntry;
			} else {
				dbURL = str.nvl(System.getProperty("db.url", dbProperties.getUrl()), System.getenv("IMX_INT_DBURL"));
				if (prm.isEmpty(dbURL)) {
					throw new SQLException("Couldn't find usable database URL");
				}
			}
		}
		bds.setUrl(dbURL);

		Class.forName(dbDriver);
		logger.info("Using dbURL -> " + dbURL);
		validationQuery = dbProperties.getTestQuery();
		// TODO: bds.setValidationQuery(validationQuery);
		if (!prm.isEmpty(validationQuery)) {
			testOnBorrow = true;
		}
	}

	private boolean useWallet() {
		String hiddenDbPassPrm = str.nvl(System.getProperty("db.use_wallet", dbProperties.isUse_wallet()),
				System.getenv("IMX_HIDDEN_DB_PASS"));
		return "TRUE".equalsIgnoreCase(hiddenDbPassPrm);
	}

	private String findTNSAdminLocation() {
		String tnsAdminPath = str.nvl(System.getProperty("oracle.net.tns_admin"), System.getenv("TNS_ADMIN"));
		if (!prm.isEmpty(tnsAdminPath)) {
			if (!((new File(tnsAdminPath)).exists() && (new File(tnsAdminPath)).isDirectory()
					&& (new File(tnsAdminPath, "tnsnames.ora")).exists())) {
				tnsAdminPath = null;
			}
		}
		return tnsAdminPath;
	}

	private String findTNSEntry() {
		String tnsEntry = str.nvl(System.getProperty("db.tns_entry"), System.getenv("TWO_TASK"));
		if (prm.isEmpty(tnsEntry)) {
			logger.info("No tns_entry passed, using default -> " + DEFAULT_TNS_ENTRY);
			tnsEntry = DEFAULT_TNS_ENTRY;
		}
		return tnsEntry;
	}

	private String findWalletLocation() throws SQLException {
		String walletLocation = System.getProperty("oracle.net.wallet_location");
		if (prm.isEmpty(walletLocation)) {
			String imxClt = System.getenv("IMX_CLT");
			if (!prm.isEmpty(imxClt)) {
				walletLocation = imxClt + File.separator + "private";
			}
		}

		return walletLocation;
	}*/
}
