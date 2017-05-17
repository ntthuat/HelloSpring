package com.springzero.core.code;

import com.springzero.core.support.Disposable;
import com.springzero.core.support.Initializable;

/**
 * The interface defines common features for emulating a transformed legacy program.<br>
 * Có thể xem đây là interface phục vụ cho ProgramManager, thực tế thì ProgramManager nó sẽ gọi các CodeModel này.
 * Trong test thì mình cần tạo interface, chưa có các class implements nó chỉ để phục vụ cho việc chạy test ProgramManager.
 * 
 * @author Thuat T Nguyen
 * @version 05/17/2017
 *
 */
public interface CodeModel extends Disposable, Initializable{
	/**
	 * Returns program name that may be stored/used explicitly. This
	 *
	 * @return simple class name by default or specific implementation.
	 */
	String getName();

	/**
	 * setter of QreContext
	 *
	 * @param context - the QreContext, which can be regarded as user session
	 *//*
	void setContext(QreContext context);*/

	/**
	 * Main entry of a transformed program, which is invoked when a program is called.
	 * 
	 * @param args - arguments for executing mainline method
	 */
	void mainline(Object... args);

	/**
	 * This Method returns the return code. It is useful in Job execution environment.<br>
	 * However, this may or may not make sense to all types of legacy languages.
	 *
	 * @return Return Code
	 */
	int getReturnCode();

	/**
	 * Indicate if an implementation supports reentrant feature.<br>
	 * Some legacy programs, such as COBOL, RPG, support reentrant feature depending on how it exits the last time.
	 * However, some do not, such as CLP. *
	 *
	 * @return true/false to indicate if the implementation supports reentrant feature or not
	 */
	boolean isReentrantSupported();

	/**
	 * Indicates if the program has completed and to be unloaded.
	 *
	 * @return false if the program can be reused, true if the program should be unloaded and reinstaintated for the
	 *         next call.
	 */
	boolean isToUnload();
}
