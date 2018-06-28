package vn.com.tma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paramater")
public class Paramater {
	@Id
	@Column(name="day")
	private int day;

	public Paramater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paramater(int day) {
		super();
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
}
