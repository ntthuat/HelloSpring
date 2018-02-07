package com.springzero.configuration;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
public class Context {
	private Connection databaseConnection;
	private String runnerName;
	private Map<String, Object> properties = new HashMap();

	public Context() {
	}

	public void setDatabaseConnection(Connection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public Connection getDatabaseConnection() {
		if (null == this.databaseConnection) {
			throw new RuntimeException();
		} else {
			return this.databaseConnection;
		}
	}

	public void setRunnerName(String runnerName) {
		this.runnerName = runnerName;
	}

	public String getRunnerName() {
		if (null == this.runnerName) {
			throw new RuntimeException();
		} else {
			return this.runnerName;
		}
	}

	public Object getProperty(String key) {
		return this.properties.get(key);
	}

	public void setProperty(String key, Object value) {
		this.properties.put(key, value);
	}

	public Map<String, Object> getProperties() {
		return this.properties;
	}

	public void addProperties(Map<String, Object> properties) {
		this.properties.putAll(properties);
	}

	public String toString() {
		return "------Context dump:\n connection : " + this.databaseConnection + '\n' + "runner name : "
				+ this.runnerName + '\n' + " properties : " + this.properties + '\n';
	}
}
