package com.demo.model;

import javax.validation.constraints.Size;

/**
 * 
 * @author tnthien
 * @version 01/25/2018
 *
 */
public class MessageResponse {
	
	/**
	 * Status<br>
	 * Description:
	 * <pre>
	 * CDM: Message. To read (checked - read)
	 * CDM: Message. To read (unchecked – unread)
	 * PDM: G_INFORMATION.FG_URGENT (urgent)
	 * PDM: G_INFORMATION.FG_IMPORTANT
	 * CDM: CDM: Message. Answer requested (reply required)
	 * PDM: G_INFORMATION.TYPEMETTEUR
	 * (attachment)
	 * </pre>
	 */
	@Size(max = 64)
	private String msgStatus;
	
	/**
	 * Refinfo<br>
	 * Description:
	 * <pre>
	 * PDM: G_INFORMATION.REFINFO
	 * </pre>
	 */
	@Size(max = 8)
	private String msgRefInfo;
	
	/**
	 * Your reference<br>
	 * Description:
	 * <pre>
	 * CDM: Involved party.External case reference of the involved party
	 * </pre>
	 */
	@Size(max = 80)
	private String casExRef;
	
	/**
	 * Date<br>
	 * Description:
	 * <pre>
	 * CDM: Message. Message date
	 * </pre>
	 */
	@Size(max = 10)
	private String msgDat;
	
	/**
	 * From<br>
	 * Description:
	 * <pre>
	 * CDM: Individual. Name || “” ||Individual. Surname
	 * </pre>
	 */
	@Size(max = 100)
	private String msgFrom;
	
	/**
	 * To<br>
	 * Description:
	 * <pre>
	 * CDM: Individual. Name || “” ||Individual. Surname
	 * </pre>
	 */
	@Size(max = 100)
	private String msgTo;
	
	/**
	 * Subject<br>
	 * Description:
	 * <pre>
	 * CDM: Message. Subject
	 * </pre>
	 */
	@Size(max = 100)
	private String msgSubject;
	
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
	 * Debtor<br>
	 * Description:
	 * <pre>
	 * CDM: Individual. Name || “” ||Individual. Surname
	 * </pre>
	 */
	@Size(max = 10)
	private String dbName;
	
	/**
	 * Creditor<br>
	 * Description:
	 * <pre>
	 * CDM: Individual. Name || “” ||Individual. Surname
	 * </pre>
	 */
	@Size(max = 10)
	private String creditorName;

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	public String getMsgRefInfo() {
		return msgRefInfo;
	}

	public void setMsgRefInfo(String msgRefInfo) {
		this.msgRefInfo = msgRefInfo;
	}

	public String getCasExRef() {
		return casExRef;
	}

	public void setCasExRef(String casExRef) {
		this.casExRef = casExRef;
	}

	public String getMsgDat() {
		return msgDat;
	}

	public void setMsgDat(String msgDat) {
		this.msgDat = msgDat;
	}

	public String getMsgFrom() {
		return msgFrom;
	}

	public void setMsgFrom(String msgFrom) {
		this.msgFrom = msgFrom;
	}

	public String getMsgTo() {
		return msgTo;
	}

	public void setMsgTo(String msgTo) {
		this.msgTo = msgTo;
	}

	public String getMsgSubject() {
		return msgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		this.msgSubject = msgSubject;
	}

	public String getCasRef() {
		return casRef;
	}

	public void setCasRef(String casRef) {
		this.casRef = casRef;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getCreditorName() {
		return creditorName;
	}

	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}
}
