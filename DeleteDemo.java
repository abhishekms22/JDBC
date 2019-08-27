package com.quinnox.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {
	public static void main(String[] args){
		Connection con;
		Statement stmt;
		int cnt=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "rhrh");
			String str="delete from locations where city='Tokyo'";
			System.out.println(" ");
			stmt = con.createStatement();
			int rowcount=stmt.executeUpdate(str);
			if(rowcount>0){
				System.out.println("Record deleted");
			}
		
		
		con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
