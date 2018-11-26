package com.springinteg.adapter.filter;


import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("maxItemsFilter")
public class MaxItemsFilter {
    private static int MAX_THRESHOLD = 10;
    public boolean checkThreshold(Message<?> orderId) {
       if (orderId.getPayload() != null) {
    	   int orderVal = (Integer) orderId.getPayload();
    	   if(orderVal > MAX_THRESHOLD) {
    		   return true;
    	   }
       }  
       return false;
    }
}
