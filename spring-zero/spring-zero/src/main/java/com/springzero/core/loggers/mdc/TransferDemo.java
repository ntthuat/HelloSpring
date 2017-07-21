package com.springzero.core.loggers.mdc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Example about advanced use of MDC (Mapped Diagnostic Context)
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public class TransferDemo {
	public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        TransactionFactory transactionFactory = new TransactionFactory();

        for (int i = 0; i < 10; i++) {
            Transfer tx = transactionFactory.newInstance();

            // Runnable task = new Log4JRunnable(tx);
            // Runnable task = new Log4J2Runnable(tx);
            Runnable task = new Slf4jRunnable(tx);

            executor.submit(task);
        }

        executor.shutdown();

    }
}
