package com.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public enum Method2 {
	instance;
	Connection conn = null;
	PreparedStatement query = null;

	private Method2() {
		// TODO Auto-generated constructor stub
	}	

	public void ChangeStatus(String id, String s) {
		try {
			String usrname = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/hibernatedemo2";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, usrname, password);

			query = conn.prepareStatement("update user set status = '" + s + "' where id = " + id);
			int a = query.executeUpdate("update user set status = '" + s + "' where id = " + id);
			System.out.println(a);
			query.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
