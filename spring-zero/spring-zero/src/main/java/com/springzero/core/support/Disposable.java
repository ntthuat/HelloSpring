package com.springzero.core.support;

/**
 * The interface indicating that its implementation can be disposed somehow, e.g. release some resources explicitly by
 * certain time.<br>
 * 
 * @author Thuat T Nguyen
 * @version 05/05/2017
 */
public interface Disposable {

	/**
	 * Release any resources that needs to be disposed. <br>
	 * Note that, NO exception should be thrown from this method and either specific action is to be taken or the
	 * exception is suppressed with warning message
	 */
	void dispose();

}
