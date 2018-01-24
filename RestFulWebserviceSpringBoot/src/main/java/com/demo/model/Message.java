package com.demo.model;

import javax.validation.constraints.Size;

/**
 * 
 * @author tnthien
 * @version 01/24/2018
 *
 */
public class Message {
	
	/**
	 * Customer external reference<br>
	 * Description:
	 * <pre>
	 * CDM: Individual. External reference
	 * </pre>
	 */
	@Size(max = 30)
	private String cusExRef;
	
	/**
	 * Customer Name<br>
	 * Description:
	 * <pre>
	 * CDM: Individual.Name
	 * </pre>
	 */
	@Size(max = 100)
	private String cusName;
	
	/**
	 * Case reference<br>
	 * Description:
	 * <pre>
	 * CDM: Case.iMX case reference
	 * </pre>
	 */
	@Size(max = 10)
	private String casRef;
	
	/**
	 * Box directory In<br>
	 * Description:
	 * <pre>
	 * Search in Message box.
	 * CDM: Message.Addresee (inbox)
	 * </pre>
	 */
	@Size(max = 20)
	private String msgBoxDirIn;
}
