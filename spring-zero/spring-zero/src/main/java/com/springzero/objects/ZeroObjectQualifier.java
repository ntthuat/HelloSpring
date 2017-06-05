package com.springzero.objects;

import com.springzero.core.util.StringUtils;

/**
 * Any zero object could be qualified by object name and library name that the object resides. <br>
 * On zero, a qualified object name can be either
 * a 20 characters String (the 1st 10 characters represents object name, and the rest represents library name), or
 * a library name + slash + an object name.
 * 
 * @author Thuat T Nguyen
 * @version 06/05/2017
 */
public class ZeroObjectQualifier implements ZeroQualifiable{

	/**
	 * Library name that the object resides. It could be a predefined one, such as *LIBL, *CURLIB (these two are most
	 * frequently used)
	 */
	private final String library;
	/**
	 * object name
	 */
	private final String name;
	
	/**
	 * Construct a qualifier with library and name provided in separate
	 * 
	 * @param library - library name
	 * @param name - object name
	 */
	protected ZeroObjectQualifier(final String library, final String name) {
		super();
		this.library = library;
		this.name = name;
	}
	
	/**
	 * get instance by given library and file name
	 * @param library - library name
	 * @param name - file name
	 * @return
	 */
	public static ZeroObjectQualifier forName(final String library, final String name) {
		final String theLib;
		if (StringUtils.isEmpty(library)) {
			theLib = null;
		} else {
			theLib = library.trim().toUpperCase();
		}
		return new ZeroObjectQualifier(theLib, name == null ? null : name.trim().toUpperCase());
	}
	
	/**
	 * parse a qualified name as a qualifier
	 * 
	 * @param theQualifiedName - qualified name, , which can be either a 20 characters String (the 1st 10 characters
	 *            represents object name, and the rest represents library name), or a library name + slash + an object
	 *            name.
	 * @return IseriesObjectQualifier
	 *//*
	public static IseriesObjectQualifier forQualifiedName(final String qualifiedName) {
		AssertUtils.notNull(qualifiedName);
		final String library;
		final String name;
		// Check if a delimiter is included
		final char configuredDelimiter = IseriesConfig.getQualifierDelimiter();
		int delimiterIndex = qualifiedName.indexOf(IseriesConfig.getQualifierDelimiter());
		if (delimiterIndex < 0 && CharConstants.DOT != configuredDelimiter) { // check with .
			delimiterIndex = qualifiedName.indexOf(CharConstants.DOT);
		}
		if (delimiterIndex < 0 && CharConstants.SLASH != configuredDelimiter) { // check with /
			delimiterIndex = qualifiedName.indexOf("/");
		}
		if (delimiterIndex >= 0) {
			library = qualifiedName.substring(0, delimiterIndex);
			name = qualifiedName.substring(delimiterIndex + 1);
		} else {
			// The qualified name is 10 as name following by 10 chars as library
			if (qualifiedName.length() > NumberConstants.I10) {
				library = qualifiedName.substring(NumberConstants.I10);
				name = qualifiedName.substring(0, NumberConstants.I10);
			} else {
				library = IseriesLibraryConstants.LIBL.toString();
				name = qualifiedName;
			}
		}

		return IseriesObjectQualifier.forName(library, name);
	}*/
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getLibrary() {
		return library;
	}

}
