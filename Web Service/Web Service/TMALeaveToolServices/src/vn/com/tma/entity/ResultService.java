package vn.com.tma.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultService {
	private int error;
	private String messsage;
	public int getError() {
		return error;
	}
	public ResultService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultService(int error, String messsage) {
		super();
		this.error = error;
		this.messsage = messsage;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
}
