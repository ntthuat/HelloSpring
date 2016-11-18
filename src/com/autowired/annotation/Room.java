package com.autowired.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Room {
	
	@Autowired
	private Table table;

	public Room() {
		System.out.println("This is room");
	}

	//Có thể đặt @Autowired ở đây
/*	public Room(Table table) {
		this.table = table;
	}*/

	public Table getTable() {
		return table;
	}

	//Có thể đặt @Autowired ở đây
	public void setTable(Table table) {
		this.table = table;
	}
	
	public void spellCheck(){
		table.checkSpelling();
	}
	
}
