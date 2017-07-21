package com.springzero.core.loggers.mdc;

import org.slf4j.MDC;

/**
 * Example about advanced use of MDC (Mapped Diagnostic Context)
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public class Slf4jRunnable implements Runnable {
	private final Transfer tx;

    public Slf4jRunnable(Transfer tx) {
        this.tx = tx;
    }

    public void run() {

        MDC.put("transaction.id", tx.getTransactionId());
        MDC.put("transaction.owner", tx.getSender());

        new TransferServiceSlf4j().transfer(tx.getAmount());

        MDC.clear();

    }
}
