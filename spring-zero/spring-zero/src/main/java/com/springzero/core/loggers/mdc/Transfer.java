package com.springzero.core.loggers.mdc;

/**
 * Example about advanced use of MDC (Mapped Diagnostic Context)
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public class Transfer {
    private String transactionId;
    private String sender;
    private Long amount;
     
    public Transfer(String transactionId, String sender, long amount) {
        this.transactionId = transactionId;
        this.sender = sender;
        this.amount = amount;
    }
     
    public String getSender() {
        return sender;
    }
 
    public String getTransactionId() {
        return transactionId;
    }
 
    public Long getAmount() {
        return amount;
    }
}
