package com.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageUtils {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

	public static Boolean getBoolean(String val) {
		if (val != null && val.toUpperCase().matches("O|Y")) {
			return true;
		}
		return false;
	}

	public static String parseBoolean(Boolean val) {
		if (val != null && val == true) {
			return "O";
		} else {
			return "N";
		}
	}

	public static Date getDate(String strDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			return dateFormat.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}
}
