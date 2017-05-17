package com.springzero.core.constant;

/**
 * @author Thuat T Nguyen
 * @version 05/09/2017
 */
public final class CharConstants {

	/**
	 * Used for hex decoding. Contains those characters that are valid in hex. For example, 0, "a" and "A" are all valid
	 * hex characters.
	 */
	public static final byte[] HEX_DECODE = initHexDecode();

	// public static final char[] HEX_VALUE_CHARS_ALL = StringConstants.HEX_VALUE_CHARS_ALL.toCharArray();

	/** HEX_VALUE_CHARS */
	public static final char[] HEX_VALUE_CHARS = StringConstants.HEX_VALUE_CHARS.toCharArray();

	/** ZERO */
	public static final char ZERO = '0';

	/** NINE */
	public static final char NINE = '9';

	/** HIGH_VALUE */
	public static final char HIGH_VALUE = 0xFF;

	/** LOW_VALUE */
	public static final char LOW_VALUE = 0x00;

	/** ASTERISK */
	public static final char ASTERISK = '*';

	/** SPACE */
	public static final char SPACE = 0x20;

	/** QUOTE */
	public static final char QUOTE = '"';

	/** SINGLE_QUOTE */
	public static final char SINGLE_QUOTE = '\'';

	/** E */
	public static final char E = 'E';

	/** HYPHEN */
	public static final char HYPHEN = '-';

	/** DOT */
	public static final char DOT = '.';

	/** SLASH */
	public static final char SLASH = '/';

	/** UNDERSCORE */
	public static final char UNDERSCORE = '_';

	/** AMPERSAND */
	public static final char AMPERSAND = '&';

	/** BACK_SLASH */
	public static final char BACK_SLASH = '\\';

	/** CARET */
	public static final char CARET = '^';

	/** COLON */
	public static final char COLON = ':';

	/** COMMA */
	public static final char COMMA = ',';

	/** BRACKET_SQUARE_OPEN */
	public static final char BRACKET_SQUARE_OPEN = '[';
	/** BRACKET_SQUARE_RIGHT */
	public static final char BRACKET_SQUARE_RIGHT = ']';

	/** DOLLAR */
	public static final char DOLLAR = '$';

	/** PLUS */
	public static final char PLUS = '+';

	/**
	 * MINUS
	 */
	public static final char MINUS = '-';

	/** Z */
	public static final char Z = 'Z';

	/**
	 * ONE
	 */
	public static final char ONE = '1';

	/**
	 * Privatised constructor for utility class
	 */
	private CharConstants() {
		// To avoid being constructed.
	}

	/**
	 * Returns Decoded hex value
	 *
	 * @return decoded hex value
	 */
	private static byte[] initHexDecode() {
		final byte[] hexDecode = new byte[NumberConstants.I255];

		final char[] allHexValueChars = StringConstants.HEX_VALUE_CHARS_ALL.toCharArray();
		for (int i = 0; i < allHexValueChars.length; i++) {
			hexDecode[allHexValueChars[i]] = (byte) Character.digit(allHexValueChars[i], NumberConstants.I16);
		}
		return hexDecode;
	}


}
