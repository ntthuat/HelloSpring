package com.springzero.dbcs;

/**
 * Class này dùng để viết các method về DBCS (Double Byte CharacterS Set).
 * 
 * @author Thuat T Nguyen
 * @version 05/26/2017
 */
public class DbcsFunctions {
	
	/**
	 * Class này dùng để kiểm tra xem trong chuỗi có chứa ký tự chinese hay không.<br>
	 * 
	 */
	public static boolean containsHanScript(String s) {
	    return s.codePoints().anyMatch(
	            codepoint ->
	            Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
	}
}
