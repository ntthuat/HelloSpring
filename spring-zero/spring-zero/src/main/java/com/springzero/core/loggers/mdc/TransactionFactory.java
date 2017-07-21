package com.springzero.core.loggers.mdc;

import static java.lang.Math.floor;
import static java.lang.Math.random;

/**
 * Example about advanced use of MDC (Mapped Diagnostic Context)
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public class TransactionFactory {

	private static final String[] NAMES = { "John", "Susan", "Marc", "Samantha" };
	private static long nextId = 1;

	public Transfer newInstance() {
		String transactionId = String.valueOf(nextId++);
		String owner = NAMES[(int) floor(random() * NAMES.length)];
		long amount = (long) (random() * 1500 + 500);
		Transfer tx = new Transfer(transactionId, owner, amount);
		return tx;
	}

}
