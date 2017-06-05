package com.springzero.dataaccess.beans;

/**
 * Defines bean names that can be used programmatically and this must be a
 * naming convention around it.
 *
 * @author Thuat T Nguyen
 * @version 06/05/2017
 */
public final class SpringBeanNamesData {
	/** INTERNAL_DATA_SOURCE */
	public static final String INTERNAL_DATA_SOURCE = "internalDataSource";

	/** INTERNAL_JDBC_OPERATIONS */
	public static final String INTERNAL_JDBC_OPERATIONS = "internalJdbcOperations";

	/** INTERNAL_TRANSACTION_MANAGER */
	public static final String INTERNAL_TRANSACTION_MANAGER = "internalTransactionManager";

	/** APPLICATION_DATA_SOURCE */
	public static final String APPLICATION_DATA_SOURCE = "applicationDataSource";

	/** APPLICATION_JDBC_OPERATIONS */
	public static final String APPLICATION_JDBC_OPERATIONS = "applicationJdbcOperations";

	/** APPLICATION_JTA_JDBC_OPERATIONS */
	public static final String APPLICATION_JTA_JDBC_OPERATIONS = "applicationJtaJdbcOperations";

	/** LEGACY_TRANSACTION_MANAGER */
	public static final String LEGACY_TRANSACTION_MANAGER = "legacyTransactionManager";

	/** LEGACY_JTA_TRANSACTION_MANAGER */
	public static final String LEGACY_JTA_TRANSACTION_MANAGER = "legacyJtaTransactionManager";

	/** APPLICATION_TRANSACTION_MANAGER */
	public static final String APPLICATION_TRANSACTION_MANAGER = "applicationTransactionManager";

	/** TEMPORARY_DATA_SOURCE */
	public static final String TEMPORARY_DATA_SOURCE = "temporaryDataSource";

	/** TEMPORARY_JDBC_OPERATIONS */
	public static final String TEMPORARY_JDBC_OPERATIONS = "temporaryJdbcOperations";

	/** TEMPORARY_TRANSACTION_MANAGER */
	public static final String TEMPORARY_TRANSACTION_MANAGER = "temporaryTransactionManager";

	/** Hibernate Session Factory qualified name */
	public static final String SESSION_FACTORY = "sessionFactory";

	/**
	 * Bean name for DataAccessConfig
	 */
	public static final String DATA_ACCESS_CONFIG = "dataAccessConfig";

	/**
	 * Bean name for DataAccessBeans
	 */
	public static final String DATA_ACCESS_BEAN = "dataAccessBeans";

	/**
	 * DATA_AREA_MANAGER
	 */
	public static final String DATA_AREA_MANAGER = "dataAreaManager";

	/**
	 * Privatised constructor for utility class
	 */
	private SpringBeanNamesData() {
		// To avoid being constructed.
	}
}
