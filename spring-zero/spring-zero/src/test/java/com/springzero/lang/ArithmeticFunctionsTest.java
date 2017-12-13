package com.springzero.lang;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 * @author Maximus TTN
 *
 */
public class ArithmeticFunctionsTest {
	
	@Test
	public void testLeftZerosPadding(){
		int number = 9;
		String s = ArithmeticFunctions.leftZeroPadding(5, number);
		Assert.assertEquals(s,"00009");
	}
}
