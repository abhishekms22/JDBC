package com.quinnox.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {
	public static void main(String[] args){
		Connection con;
		Statement stmt;
		int cnt=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "rhrh");
			String str="insert into departments values(301, 'Sports', 204, 2500)";
			stmt = con.createStatement();
			int rowcount=stmt.executeUpdate(str);
			if(rowcount>0){
				System.out.println("Record inserted successfully");
			}
		
		String str1="Select count(location_id)from locations";
		ResultSet rs=stmt.executeQuery(str1);
		while(rs.next()){
			cnt=rs.getInt(1);
			System.out.println("Total no of records is :" +cnt);
			
		}
		con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
