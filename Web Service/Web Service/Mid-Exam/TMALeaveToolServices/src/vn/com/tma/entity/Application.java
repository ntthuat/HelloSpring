package vn.com.tma.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="leave_days")
	private int leave_days;
	@Column(name="reason")
	private String reason;
	@Column(name="status")
	private int status;
	@Column(name="start_date")
	private String start_date;
	@Column(name="username")
	private String username;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Application() {
		super();
	}
	
	public Application(int id, int leave_days, String reason, int status, String start_date,String username) {
		super();
		this.id = id;
		this.leave_days = leave_days;
		this.reason = reason;
		this.status = status;
		this.start_date = start_date;
		this.username=username;
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
