package com.springzero.dbcs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;

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
	 * 
	 * @throws DecoderException
	 */
	@Test
	public void TestExample() throws DecoderException {
		String str = "a昨大昨";
		char a = '大';
		System.out.println(str.charAt(1));
		System.out.println(a);
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
	public void testFromDbcs(){
		String str = DbcsFunctions.fromDbcs("a昨夜のコンサートは最高でした");
		assertEquals("aðéÌRT[gÍÅÅµ½", str);
		String str2 = DbcsFunctions.convertCharset(str, Charset.forName("ISO-8859-1"), Charset.forName("windows-31j"));
		assertEquals("a昨夜のコンサートは最高でした", str2);
		
		String str3 = "昨";
		byte[] b = str3.getBytes();
		String hex = new String(Hex.encodeHex(b));
	}
	
	@Test
	public void testSpace2Bytes() {
		String space1Byte = " ";
		String result = new String(Hex.encodeHex(space1Byte.getBytes()));
		assertEquals("20", result);
		String space2Bytes = "　";
		result = new String(Hex.encodeHex(space2Bytes.getBytes()));
		assertEquals("e38080", result);
	}

	@Test
	public void testCharToHeximal(){
		assertEquals("5a", Integer.toHexString((int) 'Z'));
		String str = String.valueOf((char)240);
		String strHex = new String(Hex.encodeHex(str.getBytes()));
		System.out.println(str);
		System.out.println(strHex);
		System.out.println(Integer.toHexString(240));
		byte[] b = str.getBytes();
	}
	
	/**
	 * Method này dùng để test character 240 trong bảng mã ASCII.<br>
	 * <pre>
	 * Output characters in range: 240
	 * Unicode Number (int): 240
	 * Unicode Number (hex): f0
	 * Raw Hex: c3b0
	 * Decimal array: [-61, -80]
	 * Binary array: [1100 0011, 1011 0000]
	 * Character: ð
	 * </pre>
	 * Tham khảo: http://dev.networkerror.org/utf8/
	 */
	@Test
	public void testEncode240(){
		char c = 'ð';
		
		// method chuyển sang số thứ tự trong bảng mã ASCii
		assertEquals(240, (int)c);
		
		// method chuyển sang số thự tụ heximal trong bảng mã ASCII
		assertEquals("f0", Integer.toHexString((int)c));
		
		// method chuyển sang raw hex
		String str = String.valueOf(c);
		assertEquals("c3b0", new String(Hex.encodeHex(str.getBytes()))); //c3b0 nghĩa là 1100 0011 1011 0000
		
		// method chuyển sang byte array
		byte[] b = str.getBytes();
		assertEquals(-61, b[0]); // -61 nghĩa là 1100 0011
		assertEquals(-80, b[1]); // -80 nghĩa là 1011 0000
	}
	
	/**
	 * Method này dùng để test character 127 trong bảng mã ASCII.<br>
	 * <pre>
	 * Output characters in range: 127
	 * Unicode Number (int): 127
	 * Unicode Number (hex): 7f
	 * Raw Hex: c281
	 * Character: DEL
	 * </pre>
	 * Tham khảo: http://dev.networkerror.org/utf8/
	 */
	@Test
	public void testEncodeC281() throws DecoderException{
		String str = "c281";
		String resultApache = new String(Hex.decodeHex(str.toCharArray()));
		System.out.println(resultApache);
	}
	
	/**
	 * Method này dùng để test character 15112361 trong UTF-8.<br>
	 * <pre>
	 * Output characters in range: 26152
	 * Unicode Number (int): 26152
	 * Unicode Number (hex): 6628
	 * Raw Hex: E698A8
	 * Decimal array: [-26, -104, -88]
	 * Binary array: [1110 0110, 1001 1000, 1010 1000]
	 * Character: 昨
	 * </pre>
	 * Tham khảo: http://dev.networkerror.org/utf8/
	 */
	@Test
	public void testEncode26152(){
		char c = '昨';
		// Unicode Number (int)
		assertEquals(26152, (int)c);
		
		// Unicode Number (hex)
		assertEquals("6628", Integer.toHexString((int)c));
		
		
		String str = String.valueOf(c);
		// Raw Hex
		assertEquals("e698a8", new String(Hex.encodeHex(str.getBytes())));
		
		byte[] b = str.getBytes();
		// Binary array
		assertEquals(-26, b[0]);
		assertEquals(-104, b[1]);
		assertEquals(-88, b[2]);
		
		String fromDbcs = DbcsFunctions.fromDbcs(str);
		String dbcs1 = "";
		String dbcs2 = "ð";
		System.out.println( new String(Hex.encodeHex(dbcs1.getBytes())));
		System.out.println( new String(Hex.encodeHex(dbcs2.getBytes())));
	}
	
	@Test
	public void testBytesToHex() {
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
	public void testDecodeHex() throws DecoderException {
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

	@Test
	public void testCheckLeadAndTrailByte() {
		// scenario 1: c=0x40=@
		char c = 0x40;
		assertEquals('@', c);
		assertTrue(DbcsFunctions.isTrailingChar(c));
		assertFalse(DbcsFunctions.isDbcsLeadingChar(c));

		// scenario 2: c=0x41=A
		c = 0x41;
		assertEquals('A', c);
		assertTrue(DbcsFunctions.isTrailingChar(c));
		assertFalse(DbcsFunctions.isDbcsLeadingChar(c));

		// scenario 3: c=0x3d='='
		c = 0x3d;
		assertEquals('=', c);
		assertFalse(DbcsFunctions.isTrailingChar(c));
		assertFalse(DbcsFunctions.isDbcsLeadingChar(c));

		// scenario 4: c=0x81
		c = 0x81;
		assertTrue(DbcsFunctions.isTrailingChar(c));
		assertTrue(DbcsFunctions.isDbcsLeadingChar(c));
		
		// scenario 5: c=0xa1
		c = 0xa1;
		assertTrue(DbcsFunctions.isTrailingChar(c));
		assertFalse(DbcsFunctions.isDbcsLeadingChar(c));
	}

	/**
	 * Test DbcsFunctions.containsDbcsScript
	 */
	@Test
	public void TestContainsHanScript() {
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
