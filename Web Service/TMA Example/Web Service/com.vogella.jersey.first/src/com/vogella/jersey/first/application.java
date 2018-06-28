package com.vogella.jersey.first;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class application {
	private int id_application;
	private int id_user;
	private Date start_day;
	private Date end_day;
	private String reason;
	private String status;
	
	public application() {
		// TODO Auto-generated constructor stub
	}

	public application(int id_user, Date start_day, Date end_day, String reason, String status) {
		super();
		this.id_user = id_user;
		this.start_day = start_day;
		this.end_day = end_day;
		this.reason = reason;
		this.status = status;
	}

	public int getId_application() {
		return id_application;
	}

	public void setId_application(int id_application) {
		this.id_application = id_application;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public Date getStart_day() {
		return start_day;
	}

	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}

	public Date getEnd_day() {
		return end_day;
	}

	public void setEnd_day(Date end_day) {
		this.end_day = end_day;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "user [id_application=" + id_application +
				", id_user=" + id_user + 
				", start_day=" + start_day + 
				", end_day=" + end_day +
				", reason=" + reason +
				", status="+status+"]";
	}
}
