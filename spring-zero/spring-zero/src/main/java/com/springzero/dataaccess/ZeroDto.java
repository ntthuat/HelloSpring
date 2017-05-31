package com.springzero.dataaccess;

import java.util.Date;

import com.springzero.core.support.Dumpable;

/**
 * Indicates its implementation is a data transfer object, which will be used in transformed program.<br>
 *
 * @author Thuat T Nguyen
 * @version 05/30/2017
 */
public interface ZeroDto extends Dumpable{

	/**
	 * To clean all fields of record. <br>
	 * This assumes single record structure
	 */
	void clear();
	
	/**
	 * To clean all fields of record with considering given noKey flag.<br>
	 * 
	 * @param noKey true to skip cleaning key fields, false to clean all fields
	 */
	void clear(boolean noKey);
	
	/**
	 * Set unique number
	 * 
	 * @param id unique number
	 */
	void setUniqueNumber(long id);
	
	/**
	 * Get unique number.<br>
	 * @return unique number
	 */
	long getUniqueNumber();
	
	/**
	 * Set last modified date.<br>
	 * 
	 * @param lastModified last modified date
	 */
	void setLastModified(Date lastModified);
	
	/**
	 * Get mapped do class, which is specified using {@link MappedType} on dto class.<br>
	 * 
	 * @return class or null if no {@link MappedType} is annotated
	 */
	/*Class<? extends ZeroDo> getDoType();*/
	
	/**
	 * Clear all fields, which doesn't do anything more than {@link #clear()} for now, but keep it as extension point.<br>
	 */
	void clearAll();
	
	/**
	 * To clean all fields of record with considering given noKey flag.<br>
	 * 
	 * @param noKey true to skip cleaning key fields, false to clean all fields
	 */
	void clearAll(boolean noKey);

	/**
	 * Initialize all fields, which doesn't do anything more than {@link #clear()} for now, but keep it as extension point.<br>
	 */
	void initializeAll();
	
	/**
	 * Copy to specified ZeroDto.<br>
	 * 
	 * @param dto Specified ZeroDto being copied to
	 */
	void copyTo(ZeroDto dto);
	
	/**
	 * Copy to specified String.<br>
	 * 
	 * @param data Specified String being copied to
	 */
	void copyTo(String data);
	
	/**
	 * Get String instance represent record value of the dto.<br>
	 * 
	 * @return String instance represent record value of the DTO
	 */
	String getStringRec();
	
	/**
	 * Set to specified ZeroDto.<br>
	 * 
	 * @param data Specified String being set to
	 */
	void set(String data);
}
