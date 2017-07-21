package com.springzero.core.loggers.mdc;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Example about advanced use of MDC (Mapped Diagnostic Context)
 * 
 * Ignore cái này đi. Khó hiểu quá.
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public interface NumberCruncher extends Remote{
	int[] factor(int number) throws RemoteException;
}
