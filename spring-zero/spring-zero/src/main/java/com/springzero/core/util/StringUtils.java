package com.springzero.core.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.springzero.core.constant.NumberConstants;
import com.springzero.core.constant.StringConstants;

/**
 * @author Thuat T Nguyen
 * @version 05/17/2017
 *
 */
public final class StringUtils {
	/**
	 * EBCDIC charset to be used, which is default to cp037, which may need to be reviewed in according to project
	 * requirement
	 */
	private static final Charset EBCDIC_CHARSET = Charset.forName("cp037");
	/**
	 * Regular expression for extracting trailing numbers.<br>
	 * ?: forces a non-capturing group, which ensure the numbers being captured is group(1) <br>
	 * .*? is a reluctant match so it won't gobble up everything. <br>
	 * \\d+ is the group matching trailing numbers
	 */
	private static final Pattern PATTERN_TRAILING_NUMBER = Pattern.compile("^(?:.*?(\\d+))$");

	/** COPY1_EQ */
	private static final String COPY1_EQ = "Copy1='";

	/** B_TO_B */
	private static final String B_TO_B = " to ";

	/** CBQ */
	private static final String CBQ = ": '";

	/** D0_5 */
	private static final double D0_5 = 0.5;

	/** HEX_F0 */
	private static final int HEX_F0 = 0xF0;

	/** HEX_F9 */
	private static final int HEX_F9 = 0xF9;

	/** HEX_100 */
	private static final int HEX_100 = 0x100;

	/** knownWords */
	private static List<String> knownWords = new ArrayList<>();

	/**
	 * HEXDECODE array use in decodeHexString function
	 */
	private static final byte[] HEXDECODE = new byte[NumberConstants.I255];

	static {
		// Initialising HEXDECODE
		final char[] valid = "0123456789abcdefABCDEF".toCharArray();
		for (int i = 0; i < valid.length; i++) {
			HEXDECODE[valid[i]] = (byte) Character.digit(valid[i], NumberConstants.I16);
		}
	}

	static {
		knownWords.add("Mr");
		knownWords.add("Mrs");
		knownWords.add("Dr");
	}

	/**
	 * Constructor
	 */
	private StringUtils() {
		super();
	}
	
	/**
	 * Checks to see whether the input <code>Object</code> when converted to a String is empty. Empty, in this context,
	 * means
	 * <ul>
	 * <li>is null
	 * <li>has a length of zero
	 * <li>contains only spaces
	 * <li>contains the String "null" (not case sensitive)
	 * </ul>
	 *
	 * @param input Object to be converted to a String.
	 * @return true/false.
	 */
	public static boolean isEmpty(final Object input) {
		return input == null || isEmpty(String.valueOf(input));
	}
	
	/**
	 * Checks to see whether the input String is empty. Empty, in this context, means
	 * <ul>
	 * <li>is null
	 * <li>has a length of zero
	 * <li>contains only spaces
	 * <li>contains the String "null" (not case sensitive)
	 * </ul>
	 *
	 * @param inputStr to be examined.
	 * @return true/false.
	 */
	public static boolean isEmpty(final String inputStr) {
		return inputStr == null || inputStr.trim().length() == 0 || StringConstants.SNULL.equalsIgnoreCase(inputStr);
	}
}
