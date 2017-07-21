package com.springzero.transaction;

import org.springframework.transaction.TransactionDefinition;

/**
 * Class này để khai báo cái enum trong transaction cho spring thì phải?
 * 
 * @author Thuat T Nguyen
 * @version 04/19/2017
 */
public enum TransactionMode {

	/**
	 * This indicates if a transaction is supported or not in target application<br>
	 * NEVER indicates that no transaction management will be applied, and all transaction related legacy code
	 * operations will be ignored
	 */
	NONE(TransactionDefinition.PROPAGATION_NEVER),

	/**
	 * This indicates transaction management fully depends on how application manage the transactions<br>
	 */
	APPLICATION(TransactionDefinition.PROPAGATION_SUPPORTS),

	/**
	 * This indicates that framework transaction management will override application managed transaction operations<br>
	 * for online, a transaction will be started and ended per request<br>
	 * for batch, a transaction will be started and ended by unit of work as designed<br>
	 * all legacy transaction management operations will be ignored
	 */
	FRAMEWORK(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

	/**
	 * matching propagation in case it's required
	 */
	private final int propagation;

	private TransactionMode(final int propagation) {
		this.propagation = propagation;
	}

	public int getPropagation() {
		return propagation;
	}

}
