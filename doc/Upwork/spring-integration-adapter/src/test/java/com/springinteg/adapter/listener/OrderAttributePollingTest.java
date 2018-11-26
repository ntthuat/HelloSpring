package com.springinteg.adapter.listener;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import com.springinteg.adapter.mbean.OrderMBean;


public class OrderAttributePollingTest{
	ClassPathXmlApplicationContext context = null;
	
	
	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("spring-integ-context.xml");
	}
	

	@After
	public void destroy() {
		context.stop();
	}
	
	@Test
	public void testJmxNotification() throws InterruptedException {
		OrderMBean orderMBean = context.getBean("orderMBean",OrderMBean.class);
		orderMBean.incrementOrder();
		Thread.sleep(2000);
		for (int i=1; i<=300;i++) {
			QueueChannel processedOrder = context.getBean("processedOrders", QueueChannel.class);
			Message<String> processedMsg = (Message<String>) processedOrder.receive();
			assertNotNull(processedMsg);
			System.out.println(processedMsg.getPayload());	
			orderMBean.incrementOrder();
			Thread.sleep(1000);
			
		}
		
	}
	
}
