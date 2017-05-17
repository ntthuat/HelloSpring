package com.springzero.core.constant;

/**
 * Class to hold constants that are just Strings. They are held here to avoid style rule warnings about repeated
 * Strings. These Strings are to be used in the case where the constant really is just a String without any special
 * contextual meaning. Where it DOES have contextual meaning, a named constant should be used instead.
 * 
 * @author Thuat T Nguyen
 * @version 05/09/2017
 */
public abstract class StringConstants {

	/**
	 * Special characters for regular expression.
	 */
	public static final String REGEX_SPECIAL_CHARS = "^$(){}[]\\.*+?|,";

	/** The String literal "0". */
	public static final String S0 = "0";

	/** The String literal "01". */
	public static final String S01 = "01";

	/** The String literal "0101". */
	public static final String S0101 = "0101";

	/** The String literal "00". */
	public static final String S00 = "00";

	/** The String literal "000". */
	public static final String S000 = "000";

	/** The String literal "0.". */
	public static final String S0_DOT = "0.";

	/** The String literal "0,". */
	public static final String S0_COMMA = "0,";

	/** The String literal ".0". */
	public static final String SDOT_0 = ".0";

	/** The String literal ",0". */
	public static final String SCOMMA_0 = ",0";

	/** The String literal "1". */
	public static final String S1 = "1";

	/** The String literal "2". */
	public static final String S2 = "2";

	/** The String literal "3". */
	public static final String S3 = "3";

	/** The String literal "4". */
	public static final String S4 = "4";

	/** The String literal "5". */
	public static final String S5 = "5";

	/** The String literal "6". */
	public static final String S6 = "6";

	/** The String literal "7". */
	public static final String S7 = "7";

	/** The String literal "8". */
	public static final String S8 = "8";

	/** The String literal "9". */
	public static final String S9 = "9";

	/** The String literal "10". */
	public static final String S10 = "10";

	/** The String literal "11". */
	public static final String S11 = "11";

	/** The String literal "12". */
	public static final String S12 = "12";

	/** The String literal "13". */
	public static final String S13 = "13";

	/** The String literal "14". */
	public static final String S14 = "14";

	/** The String literal "15". */
	public static final String S15 = "15";

	/** The String literal "16". */
	public static final String S16 = "16";

	/** The String literal "17". */
	public static final String S17 = "17";

	/** The String literal "18". */
	public static final String S18 = "18";

	/** The String literal "19". */
	public static final String S19 = "19";

	/** The String literal "20". */
	public static final String S20 = "20";

	/** The String literal "40". */
	public static final String S40 = "40";

	/** The String literal "0001-01-01". */
	public static final String S0001_01_01 = "0001-01-01";

	/** The String literal "0123456789". */
	public static final String S0_9 = "0123456789";

	/** The String literal "0123456789abcdef". */
	public static final String S0_F = "0123456789abcdef";

	/** String literal "String/Functions" */
	public static final String STR_FN = "String/Functions";
	/** The String literal "0123456789". */
	public static final String NUMBER_CHARS = "0123456789";

	/** The String literal "0123456789abcdef". */
	public static final String HEX_VALUE_CHARS = NUMBER_CHARS + "abcdef";

	/** The String literal "0123456789abcdef". */
	public static final String HEX_VALUE_CHARS_ALL = HEX_VALUE_CHARS + "abcdef".toUpperCase();

	// public static final String HEX_VALUE_CHARS_UPPER = NUMBER_CHARS + "ABCDEF";
	/**
	 * The String literal "/" or forward slash.
	 */
	public static final String SLASH = "/";

	/**
	 * The String literal "\" or backward slash.
	 */
	public static final String BSLASH = "\\";

	/**
	 * The String literal "." often referred to as a dot, full-stop, decimal point or period.
	 */
	public static final String DOT = ".";

	/** The String literal " " often referred to as a blank. */
	public static final String BK = " ";

	/** A null because I really want to return one without a style check bug. */
	public static final String RETNULL = null;

	/** The String literal "-" often referred to as a hyphen. */
	public static final String HYPHEN = "-";

	/** The String literal ":" often referred to as a colon. */
	public static final String COLON = ":";

	/** The String literal ";" often referred to as a semi-colon. */
	public static final String SEMI_COLON = ";";

	/** The String literal "'" often referred to as an apostrophe. */
	public static final String APOST = "'";

	/** The String literal "\"" often referred to as a quote. */
	public static final String QUOTE = "\"";

	/** The String literal "(" or Open Bracket. */
	public static final String OB = "(";

	/** The String literal ")" or Close Bracket. */
	public static final String CB = ")";

	/** The Special String literal "\n" or New Line. */
	public static final String SYS_NL = "\n";

	/** The String literal "String". */
	public static final String STRING = "String";

	/** The String literal "yyy". */
	public static final String SYYY = "yyy";

	/** The String literal "yyyy". */
	public static final String SYYYY = "yyyy";

	/** The String literal "&lt;", Open XML. */
	public static final String XML_O = "<";

	/** The String literal "&lt;/", Open XML for end of tag. */
	public static final String XML_OE = "</";

	/** The String literal "!", Exclamation Mark or Bang. */
	public static final String BANG = "!";

	/** The String literal "&", Ampersand. */
	public static final String AMP = "&";

	/** The String literal "*", Asterisk or Star. */
	public static final String AST = "*";

	/** The String literal ">", Close XML. */
	public static final String XML_C = ">";

	/** The String literal "OK". */
	public static final String SOK = "OK";

	/** The String literal "=". */
	public static final String EQ = "=";

	/** The String literal "!=". */
	public static final String NE = "!=";

	/** The String literal "yes". */
	public static final String YES_LC = "yes";

	/** The String literal "YES". */
	public static final String YES_UC = "YES";

	/** The String literal "Yes". */
	public static final String YES_CC = "Yes";

	/** The String literal Close Square Bracket, "]". */
	public static final String CSB = "]";

	/** The String literal Open Square Bracket, "[". */
	public static final String OSB = "[";

	/** The String literal ",". */
	public static final String COMMA = ",";

	/** The String literal "no". */
	public static final String NO_LC = "no";

	/** The String literal "No". */
	public static final String NO_CC = "No";

	/** The String literal "NO". */
	public static final String NO_UC = "NO";

	/** The String literal "Y". */
	public static final String SY = "Y";

	/** The String literal "N". */
	public static final String SN = "N";

	/** The String literal "true". */
	public static final String TRUE_LC = "true";

	/** The String literal "false". */
	public static final String FALSE_LC = "false";

	/** The String literal ", ". */
	public static final String CBK = ", ";

	/** SNULL */
	public static final String SNULL = "null";

	/** KNOWN_TOKENS */
	public static final String KNOWN_TOKENS = " \t\n\r\f,'";

	/** COMMA_SP */
	public static final String COMMA_SP = ", ";

	/** UNKNOWN */
	public static final String UNKNOWN = "Unknown";

	/** "Unsupported type of parameter - " */
	public static final String UNSUPPORTED_PARAMETER = "Unsupported type of parameter - ";

	/** TWENTY_ZEROES */
	public static final String TWENTY_ZEROES = "00000000000000000000";

}
