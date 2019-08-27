package com.quinnox.jdbc;

import java.io.*;

public class WriteTofile {
	public static void main(String[] args){
		try{
			FileWriter writer = new FileWriter("d:/names.txt", true);
			BufferedWriter bwr = new BufferedWriter(writer);
			
			bwr.write("James");
			bwr.write("\n");
			bwr.write("Hobbert");
			bwr.close();
			
			System.out.println("Successfully written to a file");
		
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
