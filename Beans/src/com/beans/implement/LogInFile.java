package com.beans.implement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogInFile {
	
	public LogInFile(String length, String breadth, String width) throws Exception {
		writeUsingFileWriter("@relation beans_pre\r\n" + 
				"\r\n" + 
				"@attribute LENGTH REAL\r\n" + 
				"@attribute BREADTH REAL\r\n" + 
				"@attribute WIDTH REAL\r\n" + 
				"@attribute NAME {BIG_DRUM,SMALL_DRUM,oloyin_beans,MILK_BEANS}\r\n" + 
				"\r\n" + 
				"@data\r\n" + length+","+breadth+","+width+",?");
	}
	 private static void writeUsingFileWriter(String data) throws Exception {
	        File file = new File("C:/Users/Public/beans_pro.arff");
	        FileWriter fr = null;
	        try {
	            fr = new FileWriter(file);
	            fr.write(data);
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            //close resources
	            try {
	                fr.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        dataSetClasss d =  new dataSetClasss();
	    }

	}
	
