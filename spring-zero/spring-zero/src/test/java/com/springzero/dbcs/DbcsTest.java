package com.springzero.dbcs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.Character.UnicodeScript;
import java.util.stream.Collector.Characteristics;

import org.junit.Test;

/**
 * Class này dùng để chạy thử các ví dụ về DBCS (Double Byte CharacterS Set)
 * 
 * @author Thuat T Nguyen
 * @version 05/25/2017
 */
public class DbcsTest {
	
	/**
	 * Class này dùng để chạy thử các ví dụ về DBCS.<br>
	 */
	@Test
	public void TestExample(){
		String s = "大";
		char a = '大';
		System.out.println(s.getBytes().length);
	}
	
	/**
	 * Test DbcsFunctions.containsDbcsScript
	 */
	@Test
	public void TestContainsHanScript(){
		String chineseStr = "xxx已下架xxx";
		boolean result = DbcsFunctions.containsHanScript(chineseStr);
		assertTrue(result);
		
		chineseStr = "已下";
		result = DbcsFunctions.containsHanScript(chineseStr);
		assertTrue(result);
		
		chineseStr = "已";
		result = DbcsFunctions.containsHanScript(chineseStr);
		assertTrue(result);
		
		chineseStr = "Thận";
		result = DbcsFunctions.containsHanScript(chineseStr);
		assertFalse(result);
		
		chineseStr = "ư";
		result = DbcsFunctions.containsHanScript(chineseStr);
		assertFalse(result);
		
		chineseStr = " ";
		result = DbcsFunctions.containsHanScript(chineseStr);
		assertFalse(result);
	}
}
