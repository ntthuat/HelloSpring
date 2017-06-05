package com.springzero.core.constant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComparisonOperatorTest {
	
	@Test
	public void testComparisonOperator(){
		ComparisonOperator c = ComparisonOperator.EQUAL;
		assertEquals("=", c.rendered());
		assertEquals(ComparisonOperator.NOT_EQUAL, c.getNegated());
	}
}
