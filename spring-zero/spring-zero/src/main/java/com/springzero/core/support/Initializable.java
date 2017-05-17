package com.springzero.core.support;


/**
 * Indicate its implementation can be initialised by invoking {@link #init()}. The details about what will be
 * initialised depending on specific situation.<br>
 * Nghĩa là các class nào có hàm init thì cần implements cái interface này.
 * 
 * @author Thuat T Nguyen
 * @version 05/17/2017
 *
 */
public interface Initializable {
	/**
	 * Do anything that may be regarded as initialization.
	 */
	void init();
}
