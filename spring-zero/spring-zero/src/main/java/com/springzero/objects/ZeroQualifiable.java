package com.springzero.objects;

/**
 * The interface defines attributes that can be used for qualifying an zero object
 * 
 * @author Thuat T Nguyen
 * @version 06/05/2017
 */
public interface ZeroQualifiable {

	/**
	 * Get Object name
	 * 
	 * @return name of the object, which was no more than 10 characters on spring zero project.
	 */
	String getName();

	/**
	 * Get the library name that the object resides, which is used as qualifier
	 * 
	 * @return library name, which was no more than 10 characters on spring zero project.
	 */
	String getLibrary();
}
