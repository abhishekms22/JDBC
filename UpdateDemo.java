package com.quinnox.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {
	public static void main(String[] args){
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		String sqlUpdate;
		int cnt=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "rhrh");
			sqlUpdate="Update employees "+"Set job_id=?"+"Where employee_id=?";
			
			pstmt = con.prepareStatement(sqlUpdate);
//			int rowcount=stmt.executeUpdate(str);
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter employee id:");
			int eid = s.nextInt();
			s.nextLine();
			System.out.println("Enter new job title: ");
			String strm = s.nextLine();
			
			pstmt.setString(1, strm);
			pstmt.setInt(2,  eid);
			
			int rowAffected = pstmt.executeUpdate();
			System.out.println("Row Affected"+rowAffected);
			
		
			strm="Sales Head";
			eid=1370;
			pstmt.setString(1, strm);
			pstmt.setInt(2,  eid);
			rowAffected = pstmt.executeUpdate();
			
			System.out.println("Row affected "+rowAffected);
			con.close();
		
	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
