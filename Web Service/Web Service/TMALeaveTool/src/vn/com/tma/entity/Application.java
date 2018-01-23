package vn.com.tma.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int leave_days;
	private String reason;
	private int status;
	private String start_date;
	private String username;
	public int getId() {
		return id;
	}
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Application(int leave_days, String reason,int status, String start_date, String username) {
		super();
		this.leave_days = leave_days;
		this.reason = reason;
		this.start_date = start_date;
		this.username = username;
		this.status=status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLeave_days() {
		return leave_days;
	}
	public void setLeave_days(int leave_days) {
		this.leave_days = leave_days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
