package com.sdet2practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropFile {

	public static void main(String[] args) throws IOException {
		String dirpath= System.getProperty("user.dir");
		String proppath = dirpath+ "/commondata.txt";
		
		FileInputStream fis = new FileInputStream(proppath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty("url");
	    System.out.println(value);

	}

}
