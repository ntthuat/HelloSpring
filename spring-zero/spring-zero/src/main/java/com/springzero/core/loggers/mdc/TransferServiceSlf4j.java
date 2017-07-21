package com.springzero.core.loggers.mdc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example about advanced use of MDC (Mapped Diagnostic Context)
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public class TransferServiceSlf4j extends TransferService{
	private static final Logger logger = LoggerFactory.getLogger(TransferServiceSlf4j.class);

    @Override
    protected void beforeTransfer(long amount) {
        logger.info("Preparing to transfer {}$.", amount);
    }

    @Override
    protected void afterTransfer(long amount, boolean outcome) {
        logger.info("Has transfer of {}$ completed successfully ? {}.", amount, outcome);
    }
}
