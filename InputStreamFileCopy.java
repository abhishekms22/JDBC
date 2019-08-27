package com.quinnox.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamFileCopy {

	public static void main(String[] args) {
		try {
            InputStream is = new FileInputStream("d:/abhishekquinnox.txt");
            
            OutputStream os = new FileOutputStream("c:/temp/countries_copy.txt");
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while((bytesRead = is.read(buffer)) !=-1){
                os.write(buffer, 0, bytesRead);
            }
            System.out.println("File Copied");
            is.close();
            //flush OutputStream to write any buffered data to file
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();      
            }   
            }
            }