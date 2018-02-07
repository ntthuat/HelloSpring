package com.springzero.configuration;

/**
 * 
 * @author Thuat T Nguyen
 * @version 02/07/2018
 *
 */
public interface ContextFactory {
	
	Context createContext();

	void disposeContext();
}
