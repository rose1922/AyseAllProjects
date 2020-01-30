package com.practices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFiles {

	public static void main(String[] args) throws IOException {
		
		FileReader fis=new FileReader("src\\test\\java\\com\\practices\\Example.properties");
		
		Properties prop=new Properties();
		prop.load(fis);

		System.out.println(prop.get("userName"));		
	}
}
