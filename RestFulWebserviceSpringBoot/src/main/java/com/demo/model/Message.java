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
	 * <b>CDM: Individual. External reference</b>
	 * </pre>
	 */
	@Size(max = 30)
	private String cusExRef;
	
	/**
	 * Customer Name<br>
	 * Description:
	 * <pre>
	 * <b>CDM: Individual.Name</b>
	 * </pre>
	 */
	@Size(max = 100)
	private String cusName;
	
	/**
	 * Case reference<br>
	 * Description:
	 * <pre>
	 * <b>CDM: Case.iMX case reference</b>
	 * </pre>
	 */
	@Size(max = 10)
	private String casRef;
	
	/**
	 * Box directory In<br>
	 * Description:
	 * <pre>
	 * Search in Message box.
	 * <b>CDM: Message.Addresee (inbox)</b>
	 * </pre>
	 */
	@Size(max = 20)
	private String msgBoxDirIn;
	
	/**
	 * Box directory Out<br>
	 * Description:
	 * <pre>
	 * <b>CDM: Message.Sender (outbox)</b>
	 * </pre>
	 */
	@Size(max = 20)
	private String msgBoxDirOut;
	
	/**
	 * Date from<br>
	 * <pre>
	 * Allows search with a date range. 
	 * It presents the min date for the range.
	 * <b>CDM: Message.Message date</b>
	 * </pre>
	 */
	@Size(max = 80)
	private String msgFromDat;
	
	/**
	 * Date to<br>
	 * Description:
	 * <pre>
	 * Allows search with a date range. 
	 * It presents the max date for the range.
	 * <b>CDM: Message.Message date</b>
	 * </pre>
	 */
	@Size(max = 100)
	private String msgToDat;
	
	/**
	 * Search by<br>
	 * Description:
	 * <pre>
	 * Presents list of all fields on which search can be performed.
	 * <i>Property form translation tool message.types</i>
	 * <i>Possible values: from, to, subject, case, debtor</i>
	 * </pre>
	 */
	@Size(max = 10)
	private String msgSearchBy;
	
	/**
	 * Show unread messages<br>
	 * Description:
	 * <pre>
	 * <b>CDM: Message. To read (Boolean)</b>
	 * </pre>
	 */
	private Boolean msgUnread;
	
	/**
	 * Filter<br>
	 * Description:
	 * <pre>
	 * <b>A free text search field
	 * CDM: Message.Addresee + filter
	 * CDM: Message.Sender + filter
	 * CDM: Message.Subject + filter
	 * CDM: CDM: Individual. Name + filter
	 * (PDM :t_intervenats, type = DB ;
	 * CDM: Case. Case reference + filter (or PDM, to be used g_information : g_information.refext2)</b>
	 * </pre>
	 */
	@Size(max = 100)
	private String msgFilter;

	public String getCusExRef() {
		return cusExRef;
	}

	public void setCusExRef(String cusExRef) {
		this.cusExRef = cusExRef;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCasRef() {
		return casRef;
	}

	public void setCasRef(String casRef) {
		this.casRef = casRef;
	}

	public String getMsgBoxDirIn() {
		return msgBoxDirIn;
	}

	public void setMsgBoxDirIn(String msgBoxDirIn) {
		this.msgBoxDirIn = msgBoxDirIn;
	}

	public String getMsgBoxDirOut() {
		return msgBoxDirOut;
	}

	public void setMsgBoxDirOut(String msgBoxDirOut) {
		this.msgBoxDirOut = msgBoxDirOut;
	}

	public String getMsgFromDat() {
		return msgFromDat;
	}

	public void setMsgFromDat(String msgFromDat) {
		this.msgFromDat = msgFromDat;
	}

	public String getMsgToDat() {
		return msgToDat;
	}

	public void setMsgToDat(String msgToDat) {
		this.msgToDat = msgToDat;
	}

	public String getMsgSearchBy() {
		return msgSearchBy;
	}

	public void setMsgSearchBy(String msgSearchBy) {
		this.msgSearchBy = msgSearchBy;
	}

	public Boolean getMsgUnread() {
		return msgUnread;
	}

	public void setMsgUnread(Boolean msgUnread) {
		this.msgUnread = msgUnread;
	}

	public String getMsgFilter() {
		return msgFilter;
	}

	public void setMsgFilter(String msgFilter) {
		this.msgFilter = msgFilter;
	}
}
