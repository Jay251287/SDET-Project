package com.Vtiger.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {

	private FileUtil()
	{

	}

	/**
	 * @author SWATHI
	 * Description : This method for object creation for this which returns prop
	 * @return prop
	 */
	public static FileUtil objforFileUtil()
	{
		FileUtil prop = new FileUtil();
		return prop;
	}

	/**
	 * @author SWATHI
	 * Description : This method reads the data from prop file
	 * @param key
	 * @return Value from prop file
	 * @throws IOException 
	 */
	public String readDatafromPropFile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(IAutoConstants.proppath);
		Properties prop = new Properties();
		prop .load(fis);
		return prop.getProperty(key);
	}
	
	

}
