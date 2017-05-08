/******************************************************
 * Unpublished confidential information of Computer Sciences Corporation. Do not disclose.<br>
 * Copyright (c) Computer Sciences Corporation 2010 to present.<br>
 * All rights reserved.
 ******************************************************/

package com.jdbczero.core.process;

import org.junit.Test;

import junit.framework.Assert;

/**
 * This class tests for AbstractContextObject class.
 * 
 * @author tnguyen443
 * @version 05/08/2017
 */
public class AbstractContextObjectTest {

	@Test
	public void testMethod(){
		// test save method
		String id = "1-id";
		Object o = new Object();
		AbstractContextObject context = new AbstractContextObject();
		context.saveObject(id, o);
		Assert.assertEquals(1, context.getLength());
		// test retrieve method
		System.out.println(context.retrieveObject("1-id"));
		Assert.assertEquals(o, context.retrieveObject("1-id"));
		Object o2 = new Object();
		context.saveObject(o2); // tương đương với context.saveObject("java.lang.Object", o2);
		Assert.assertEquals(2, context.getLength());
		context.saveObject(Object.class, o2); // vì câu này cũng sẽ lấy java.lang.Object làm key nên store cũng vẫn chỉ có 2 value
		Assert.assertEquals(2, context.getLength());
		// test remove method
		context.removeObject(o2); // remove instance
		Assert.assertEquals(1, context.getLength());
		context.saveObject(o2);
		Assert.assertEquals(2, context.getLength());
		context.removeObject(Object.class); // tương đương context.removeObject(o2)
		Assert.assertEquals(1, context.getLength());
	}
}
