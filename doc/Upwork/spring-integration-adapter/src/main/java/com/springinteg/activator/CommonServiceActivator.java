package com.springinteg.activator;

import org.springframework.messaging.Message;

public class CommonServiceActivator {
	
	public String attributePolled(Message<?> msg) {
		String processedMsg = "Order Id ::" + msg.getPayload().toString() + " is being processed";
		return processedMsg;
	}

}
