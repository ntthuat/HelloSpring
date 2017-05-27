package com.springzero.dbcs;

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
}
