package com.quinnox.jdbc;

import java.sql.DriverManager;
import java.sql.*;

public class CallableDemo {
	Connection con;
	CallableStatement cstmt;
	ResultSet rs;
	
	CallableDemo(){
		
	}
	
	void createConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "rhrh");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void addDept(){
		try{
			String query="{call adjust_salary(100,10)}";
			cstmt = con.prepareCall(query);
			
			int cnt=cstmt.executeUpdate();
			Statement stm=con.createStatement();
			String query1 = "select employee_id, first_name, salary from emp2 where employee_id=100";
			rs=stm.executeQuery(query1);
			while(rs.next())
				System.out.println(rs.getInt(1)+ "\t "+ rs.getString(2)+ "\t "+ rs.getString(3));
//			int cnt=cstmt.executeUpdate();
			if(cnt>0){
				System.out.println("Salary Updated");
				
				
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args){
		CallableDemo cd1 = new CallableDemo();
		cd1.createConnection();
		cd1.addDept();
	}
	
	
}
