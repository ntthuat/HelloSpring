package com.springzero.dataaccess.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springzero.dataaccess.ZeroDatabaseFile;
import com.springzero.dataaccess.ZeroDto;

/**
 * Provide basic methods for ZeroDatabaseFile Implementation
 * 
 * @author hpham21
 */
public abstract class AbstractZeroDatabaseFileImpl implements ZeroDatabaseFile{

	/** logger definition */
	protected static final Logger logger = LoggerFactory.getLogger(AbstractZeroDatabaseFileImpl.class);
	
	/** Actual dto */
	protected ZeroDto actualDto;
	
	/**
	 * Indicates if a file must be opened with transaction enabled
	 */
	protected boolean transactionRequired;
	
	public boolean isTransactionRequired() {
		return transactionRequired;
	}

	@Override
	public void setTransactionRequired(final boolean transactionRequired) {
		this.transactionRequired = transactionRequired;
	}
	
	@Override
	public ZeroDto getDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isShared() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setShared(boolean shared) {
		// TODO Auto-generated method stub
		
	}

}
