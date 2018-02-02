package com.demo.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author tnthien
 * @version 01/31/2018
 *
 */
public final class TableConstants {
	
	/**
	 * Hidden.
	 */
	private TableConstants() {
	}
	
	/** COMMA_SP */
	public static final String COMMA_SP = ", ";
	
	/** SPACE */
	public static final String SPACE = " ";
	
	/** DOT */
	public static final String DOT = ".";
	
	public static final String g_individu = "g_individu";
	public static final String g_individu_temp = "cusi";
	
	public static final String g_information = "g_information";
	public static final String g_information_temp = "msg";
	
	public static final String t_intervenants = "t_intervenants";
	public static final String t_intervenants_temp = "customer";
	
	public static final String t_elements = "t_elements";
	public static final String t_elements_temp = "elem";
	
	public static final Map<String, String> tableMap = new HashMap<String, String>() {
		/**
		 * UID
		 */
		private static final long serialVersionUID = -8748761042942919737L;
		{
			put(g_individu, g_individu_temp);
			put(g_information, g_information_temp);
			put(t_intervenants, t_intervenants_temp);
			put(t_elements, t_elements_temp);
		}
	};
}
