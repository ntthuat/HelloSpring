package com.junit;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MoneyTest extends TestCase{
	public void testAdd(){
		Money m1 = new Money(200, "VND");
		Money m2 = new Money(1000, "VND");
		Money result = m1.add(m2); // đối tượng lưu kết quả tính toán
	    Money expected = new Money(1200, "VND"); // kết quả dự kiến
	    Assert.assertEquals(result, expected);
	}
}
