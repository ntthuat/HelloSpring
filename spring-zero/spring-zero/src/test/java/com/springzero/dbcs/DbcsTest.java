package com.springzero.dbcs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.Character.UnicodeScript;
import java.nio.charset.Charset;
import java.util.stream.Collector.Characteristics;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

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
	 * @throws DecoderException 
	 */
	@Test
	public void TestExample() throws DecoderException{
		String str = "大";
		char a = '大';
		System.out.println(str.getBytes().length);
		Charset EBCDIC_CHARSET = Charset.forName("cp037");
		Charset encoding = Charset.forName("cp037");
		boolean b = EBCDIC_CHARSET.contains(encoding);
		String codePage = "abcdef";
		
		// tạo ra nativeChars là bảng mã ASCII
		final char[] nativeChars = new char[256];
		for (int i = 0; i < nativeChars.length; i++) {
        	nativeChars[i] = (char) i;
        }
		String hex = DbcsFunctions.bytesToHex("大".getBytes());
		String space1byte = " ";
		System.out.println(new String(Hex.encodeHex(space1byte.getBytes())));
		String space2byte = "　";
		System.out.println(new String(Hex.encodeHex(space2byte.getBytes())));
	}
	
	@Test
	public void testSpace2Bytes(){
		String space1Byte = " ";
		String result = new String(Hex.encodeHex(space1Byte.getBytes()));
		assertEquals("20", result);
		String space2Bytes = "　";
		result = new String(Hex.encodeHex(space2Bytes.getBytes()));
		assertEquals("e38080", result);
	}
	
	@Test
	public void testBytesToHex(){
		// scenario 1
		String str = "A";
		String result = DbcsFunctions.bytesToHex(str.getBytes());
		String resultApache = new String(Hex.encodeHex(str.getBytes()));
		assertEquals("41", result);
		assertEquals("41", resultApache);
		
		// scenario 2
		str = "大";
		result = DbcsFunctions.bytesToHex(str.getBytes());
		resultApache = new String(Hex.encodeHex(str.getBytes()));
		assertEquals("E5A4A7", result);
		assertEquals("e5a4a7", resultApache);
		
		// scenario 3
		str = "A大";
		result = DbcsFunctions.bytesToHex(str.getBytes());
		resultApache = new String(Hex.encodeHex(str.getBytes()));
		assertEquals("41E5A4A7", result);
		assertEquals("41e5a4a7", resultApache);
	}
	
	@Test
	public void testDecodeHex() throws DecoderException{
		// scenario 1
		String str = "41";
		String resultApache = new String(Hex.decodeHex(str.toCharArray()));
		assertEquals("A", resultApache);	
		
		// scenario 2
		str = "e5a4a7";
		resultApache = new String(Hex.decodeHex(str.toCharArray()));
		assertEquals("大", resultApache);
		
		// scenario 3
		str = "e5a4a742";
		resultApache = new String(Hex.decodeHex(str.toCharArray()));
		assertEquals("大B", resultApache);
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
