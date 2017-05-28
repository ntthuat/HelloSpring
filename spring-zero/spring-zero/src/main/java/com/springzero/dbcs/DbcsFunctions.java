package com.springzero.dbcs;

import java.nio.charset.Charset;

/**
 * Class này dùng để viết các method về DBCS (Double Byte CharacterS Set).
 * 
 * @author Thuat T Nguyen
 * @version 05/26/2017
 */
public class DbcsFunctions {
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	/**
	 * Method này dùng để kiểm tra xem trong chuỗi có chứa ký tự chinese hay không.<br>
	 * 
	 */
	public static boolean containsHanScript(String s) {
	    return s.codePoints().anyMatch(
	            codepoint ->
	            Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
	}
	
	/**
	 * Method này dùng để chuyển một character array sang mã Hex.<br>
	 * Dùng method String.getBytes() trước khi sử dụng method này.
	 */
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	/**
	 * in MS932 (CP932), <br>
	 * Lead-Byte Ranges is 0x81 - 0x9F & 0xE0 - 0xFC<br>
	 * Trail-Byte Ranges is 0x40 - 0xFC(except 0x7F)<br>
	 * 
     * @param c - char
     * @return - true if it's in the leading byte range
	 */
    public static boolean isDbcsLeadingChar(char c) {
    	return c >= 0x81 && c <= 0x9F || c >= 0xE0 && c <= 0xFC;
    }

    /**
     * 
	 * in MS932 (CP932), <br>
	 * Trail-Byte Ranges is 0x40 - 0xFC(except 0x7F)<br>
     * @param c - char
     * @return - true if it's in the trail byte range
     */
    public static boolean isTrailingChar(char c) {
    	return c >= 0x40 && c <= 0xFC && c != 0x7F;
    }
    
    /**
	 * Convert from <b>source</b> charset to <b>target</b> charset<br>
	 * The purpose of doing this is to allow customised conversion in relate to EBCDIC as it might be platform/jvm
	 * dependant result, which is not desirable. It would be safer to have a fixed way of converting from EBCDIC to/from
	 * ASCII.
	 *
	 * Ví dụ: từ windows-31j sang ISO-8859-1
	 *
	 * @param str - String to be converted, which is assumed not null and encoded in <b>source</b> charset
	 * @param fromCharset - source charset that the String is encoded
	 * @param toCharset - target charset to be encoded to
	 * @return String encoded in <b>target</b> character set
	 */
	public static String convertCharset(final String str, final Charset fromCharset, final Charset toCharset) {
		return fromCharset.equals(toCharset) ? str : new String(str.getBytes(fromCharset), toCharset);
	}
	
	/**
	 * Convert String literal, assumed in unicode, to be single byte String (e.g. SHIFT-JIS for Japanese characters).<br>
	 * Hình như windows-31j là MS932
	 * 
	 * @param s - String contains unicode characters
	 * @return s that have DBCS into single bytes
	 */
	public static String fromDbcs(final String s) {
		return DbcsFunctions.convertCharset(s, Charset.forName("windows-31j"), Charset.forName("ISO-8859-1"));
	}
}
