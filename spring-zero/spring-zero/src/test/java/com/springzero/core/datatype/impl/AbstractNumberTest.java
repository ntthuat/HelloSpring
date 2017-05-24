package com.springzero.core.datatype.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

/**
 * Class này dùng để test cho class AbstractNumber
 * 
 * @author Thuat T Nguyen
 * @version 05/23/2017
 *
 */
public class AbstractNumberTest {
	
	@Test
	public void testBigDecimal(){
		BigDecimal big1 = new BigDecimal("24.451");
		BigDecimal big2 = big1.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(big1);
		System.out.println(big2);
	}
}
