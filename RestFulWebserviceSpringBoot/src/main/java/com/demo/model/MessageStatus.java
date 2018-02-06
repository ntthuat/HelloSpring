package com.demo.model;

import java.util.StringJoiner;

import com.demo.constant.TableConstants;

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
	 * To indicate from a recipient that a message is ‘important’, when a message is
	 * received.
	 */
	private Boolean isImportant;

	private Boolean answerRequested;

	private Boolean attachment;

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

	public Boolean getAnswerRequested() {
		return answerRequested;
	}

	public void setAnswerRequested(Boolean answerRequested) {
		this.answerRequested = answerRequested;
	}

	public Boolean getAttachment() {
		return attachment;
	}

	public void setAttachment(Boolean attachment) {
		this.attachment = attachment;
	}

	public String toString() {
		StringJoiner str = new StringJoiner("|");
		
		str.add(parseBoolean(getToRead()));
		str.add(parseBoolean(getUrgent()));
		str.add(parseBoolean(getImportant()));
		str.add(parseReplyReqBoolean(getAnswerRequested()));
		str.add(parseAttachmentBoolean(getAttachment()));
		
		return str.toString();
	}

	private static String parseBoolean(Boolean val) {
		if (val != null && val == true) {
			return "O";
		} else {
			return "N";
		}
	}

	public static String parseReplyReqBoolean(Boolean val) {
		if (val != null && val == true) {
			return "R";
		} else {
			return "N";
		}
	}

	public static String parseAttachmentBoolean(Boolean val) {
		if (val != null && val == true) {
			return "A";
		} else {
			return "N";
		}
	}

}
