package com.test;

public class Database {
	// private constructor của Database để không thể khởi tạo nó ở ngoài
	private Database() {
		
	}
	
	// tạo ra 1 instance duy nhất, phải để static để method này thành method của lớp.
	private static Database INSTANCE;
	
	public static Database getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		return INSTANCE;
	}
	
	private boolean offSet;
	
	public static boolean isOffset(){
		return INSTANCE.offSet;
	}
}
