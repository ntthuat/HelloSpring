package com.demo.model;

/**
 * 
 * @author tnthien
 * @version 01/26/2018
 *
 */
public class MessageStatus {
	
	/**
	 * Message is to be read
	 */
	private Boolean isToRead;
	
	/**
	 * To indicate from a sender that a message is ‘urgent’ when a message is sent
	 */
	private Boolean isUrgent;
	
	/**
	 * To indicate from a recipient that a message is ‘important’, when a message is received.
	 */
	private Boolean isImportant;
	
	/**
	 * 'I': Do not display alert:
	 * O - Do not display alert
	 * N or null - Display alert
	 * 
	 * else: Answer requested: 
	 * ‘A’ - already replied
	 * ‘R’ - reply required
	 * ‘N’ - new message (not read)
	 */
	private String answerRequested;
	
	/**
	 * Indicate if the message has attachment 
	 * ‘A’ - means has attachment 
	 * null - no attachment
	 */
	private String attachment;

	public Boolean getToRead() {
		return isToRead;
	}

	public void setToRead(Boolean isToRead) {
		this.isToRead = isToRead;
	}

	public Boolean getUrgent() {
		return isUrgent;
	}

	public void setUrgent(Boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public Boolean getImportant() {
		return isImportant;
	}

	public void setImportant(Boolean isImportant) {
		this.isImportant = isImportant;
	}

	public String getAnswerRequested() {
		return answerRequested;
	}

	public void setAnswerRequested(String answerRequested) {
		this.answerRequested = answerRequested;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
}
