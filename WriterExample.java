package com.quinnox.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {
	public static void main(String[] args){
		try{
			Writer w = new FileWriter("d:data.txt");
			String content = "She sells sea shells in the sea";
			w.write(content);
			w.close();
			System.out.println("Data Written");
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
