package com.demo.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class str {
	private static Logger logger = Logger.getLogger(str.class);

	public str() {
	}

	public static String lPad(String sStr, int num, char chPad) {
		StringBuilder res = new StringBuilder();
		if (null != sStr) {
			int iLen = sStr.length();
			if (iLen < num) {
				for (int i = 1; i <= num - iLen; ++i) {
					res.append(chPad);
				}
			}

			res.append(sStr);
		}

		return res.toString();
	}

	public static String delLedingChr(String sStr, char cChar) {
		while (sStr.length() > 0 && sStr.charAt(0) == cChar) {
			sStr = sStr.substring(1);
		}

		return sStr;
	}

	public static boolean equals(String st1, String st2) {
		return null == st1 ? null == st2 : null != st2 && st1.equals(st2);
	}

	public static String toUpper(String instr) {
		return null == instr ? null : instr.toUpperCase();
	}

	public static int indexOf(String haystack, String needle) {
		return null == haystack ? -1 : (null == needle ? -1 : haystack.indexOf(needle));
	}

	public static String substr(String instr, int beginIndex, int endIndex) {
		if (instr == null) {
			return null;
		} else {
			int len = instr.length();
			return instr.substring(beginIndex, len < endIndex ? len : endIndex);
		}
	}

	public static String stripLeadingZeroes(String inStr) {
		String outStr = inStr;
		if (null != inStr) {
			Pattern p = Pattern.compile("^0{1,}(.+)");
			Matcher m = p.matcher(inStr);
			outStr = m.lookingAt() ? m.group(1) : inStr;
		}

		return outStr;
	}

	public static String ltrim(String source) {
		return ltrim(source, (Character) null);
	}

	public static String ltrim(String source, Character cChar) {
		return null == source ? null : source.replaceAll("^" + (null == cChar ? "\\s" : cChar) + "+", "");
	}

	public static String rtrim(String source) {
		return rtrim(source, (Character) null);
	}

	public static String rtrim(String source, Character cChar) {
		return null == source ? null : source.replaceAll((null == cChar ? "\\s" : cChar) + "+$", "");
	}

	public static String itrim(String source) {
		return null == source ? null : source.replaceAll("\\b\\s{2,}\\b", " ");
	}

	public static String trim(String in) {
		return null != in ? in.trim() : null;
	}

	public static String[] toStringArray(String string, int elementLength) {
		List<String> meta = new ArrayList();

		int i;
		for (i = 0; i < string.length(); i += elementLength) {
			i = i + elementLength > string.length() ? string.length() : i + elementLength;
			meta.add(string.substring(i, i));
		}

		String[] result = new String[meta.size()];

		for (i = 0; i < meta.size(); ++i) {
			result[i] = (String) meta.get(i);
		}

		return result;
	}

	public static String analyticalToNumber(String inString) {
		if (null != inString && inString.length() != 0) {
			inString = inString.replaceAll("\\s", "");
			if (inString.indexOf(44) != inString.lastIndexOf(44)) {
				inString = inString.replaceAll(",", "");
			}

			if (inString.indexOf(46) != inString.lastIndexOf(46)) {
				inString = inString.replaceAll("\\.", "");
			}

			inString = inString.replaceAll("[a-zA-Z]{3,}", "");
			return passNumberConversion(inString);
		} else {
			return null;
		}
	}

	public static String passNumberConversion(String inString) {
		try {
			return String.valueOf(Long.parseLong(inString));
		} catch (NumberFormatException var3) {
			try {
				return String.valueOf(Double.parseDouble(inString));
			} catch (NumberFormatException var2) {
				return null;
			}
		}
	}

	public static String nvl(String o, String o1) {
		return null != o && o.length() != 0 ? o : o1;
	}

	public static String nvl2(String o, String o1, String o2) {
		return null != o && o.length() != 0 ? o1 : o2;
	}

	public static String substituteSQLBindings(String sql, Object... args) {
		String substitutedSQL = null;

		try {
			substitutedSQL = sql.replaceAll("\\s+", " ");

			for (int i = 0; i < args.length; ++i) {
				if (args[i] == null) {
					substitutedSQL = substitutedSQL.replaceFirst("\\?", "NULL");
				} else {
					String s;
					if (args[i] instanceof String) {
						s = Matcher.quoteReplacement((String) args[i]);
						substitutedSQL = substitutedSQL.replaceFirst("\\?", "'" + s + "'");
					} else if (args[i] instanceof Integer) {
						substitutedSQL = substitutedSQL.replaceFirst("\\?", args[i].toString());
					} else if (args[i] instanceof Double) {
						substitutedSQL = substitutedSQL.replaceFirst("\\?", args[i].toString());
					} else if (args[i] instanceof Float) {
						substitutedSQL = substitutedSQL.replaceFirst("\\?", args[i].toString());
					} else if (args[i] instanceof Long) {
						substitutedSQL = substitutedSQL.replaceFirst("\\?", args[i].toString());
					} else if (args[i].getClass().isArray()) {
						int len = Array.getLength(args[i]);

						for (int j = 0; j < len; ++j) {
							substitutedSQL = substituteSQLBindings(substitutedSQL, Array.get(args[i], j));
						}
					} else {
						s = args[i].toString();
						if (s != null) {
							s = Matcher.quoteReplacement(s);
						}

						substitutedSQL = substitutedSQL.replaceFirst("\\?", "'" + s + "'");
					}
				}
			}
		} catch (Exception var6) {
			logger.error("exception in substituteSQLBindings(): " + var6.getMessage(), var6);
		}

		return substitutedSQL;
	}

	public static boolean isIn(String s, String... list) {
		for (int i = 0; i < list.length; ++i) {
			if (null == list[i]) {
				if (null == s) {
					return true;
				}
			} else if (null != s && list[i].equals(s)) {
				return true;
			}
		}

		return false;
	}

	public static String filterXMLInvalidCharacters(String in) {
		StringBuilder buffer = new StringBuilder(in.length());
		char[] inAsCharArray = in.toCharArray();

		for (int i = 0; i < inAsCharArray.length; ++i) {
			if (inAsCharArray[i] >= ' ' && inAsCharArray[i] != 127) {
				buffer.append(inAsCharArray[i]);
			} else {
				buffer.append('?');
			}
		}

		return buffer.toString();
	}

	public static String byteArrayToHexString(byte[] raw) {
		String HEXES = "0123456789ABCDEF";
		if (raw == null) {
			return null;
		} else {
			StringBuilder hex = new StringBuilder(2 * raw.length);
			byte[] arr$ = raw;
			int len$ = raw.length;

			for (int i$ = 0; i$ < len$; ++i$) {
				byte b = arr$[i$];
				hex.append("0123456789ABCDEF".charAt((b & 240) >> 4)).append("0123456789ABCDEF".charAt(b & 15));
			}

			return hex.toString();
		}
	}

	public static void main(String[] args) {
		System.out.println("CVS test!");
	}
}
