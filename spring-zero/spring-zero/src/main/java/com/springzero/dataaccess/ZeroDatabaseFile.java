package com.springzero.dataaccess;

/**
 * Change class to be interface, which allows further implementation.
 * 
 * @author Thuat T Nguyen
 * @version 06/05/2017
 */
public interface ZeroDatabaseFile {

	/**
	 * Get record area
	 * @return instance of ZeroDto
	 */
	ZeroDto getDto();
	
	/**
	 * Indicate if file is opened in shared mode
	 * @return true/false
	 */
	boolean isShared(); 
	
	/**
	 * Indicate if the file is opened in shared mode
	 * @param shared - true/false
	 */
	void setShared(boolean shared);
	
	/**
	 * Indicates if the file must have transaction enabled when it's openned
	 * @param transactionRequired - true/false
	 */
	void setTransactionRequired(boolean transactionRequired);
}
