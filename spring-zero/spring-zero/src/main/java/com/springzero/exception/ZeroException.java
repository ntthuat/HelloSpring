package com.springzero.exception;

/**
 * 
 * @author tnguyen443
 * @version 10/24/2017
 */
public class ZeroException extends RuntimeException{

	// RuntimeException là unchecked exception
	// Unchecked exception là exception không cần try catch.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1351557374477435312L;
	
	/**
	 * Constructor
	 */
	public ZeroException() {
		super();
	}
	
	/**
	 * Constructor
	 * 
	 * @param message message
	 * @param cause cause
	 */
	public ZeroException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause cause
	 */
	public ZeroException(final Throwable cause) {
		super(cause);
	}

	public ZeroException getThrowable() {
		return this;
	}

}
