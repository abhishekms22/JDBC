package com.quinnox.jdbc;
import java.sql.*;
public class MysqlCon {
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "rhrh");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees");
			while(rs.next())
				System.out.println(rs.getInt(1)+ "\t "+ rs.getString(2)+ "\t "+ rs.getString(3));
			con.close();
		}catch(Exception e){System.out.println(e);}
	}
}
