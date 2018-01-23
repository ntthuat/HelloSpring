package com.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;



public class TestMySQL {
	public static void main(String[] args) {
		Connection con;
		
		try {
			String username="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/test";
//			String url="jdbc:mysql://127.0.0.1:3306/databasehaibernate";
	//		String url="jdbc:mysql://localhost/databasehaibernate";
			con=DriverManager.getConnection(url, username, password);
			
			
			System.out.println("---CONNECTION DATABASE SUCCESS---");
			Statement s=con.createStatement();
			s.executeQuery("select name from tmatest");
			ResultSet rss = s.getResultSet();
			while(rss.next()){
				System.out.println(rss.getString(1));
			}
			/*s.executeQuery("UPDATE tmatest SET name='thuat' WHERE id=1");*/
			s.executeUpdate("UPDATE tmatest SET name='thuat' WHERE id=1");
			s.executeQuery("SELECT * FROM tmatest");
			ResultSet rs=s.getResultSet();
			while(rs.next())
			{
				String id_user =rs.getString("id");
				/*int id = Integer.parseInt(id_user);
				User user = new User();
				
	
				user.setId(id);

				System.out.println(user.toString());*/
			}
			
			 con.close();
			 
			 System.out.println("---CLOSE CONNECTION---");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("---CONNECTION FAIL---");
		}
		
		
	
	}

}
