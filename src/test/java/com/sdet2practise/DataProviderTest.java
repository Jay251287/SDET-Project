package com.sdet2practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider = "getValue")
	public void print(String value1, String value2, int value3)
	{
		System.out.println(value1 + " "+ value2+" "+value3);
	}
	
	@DataProvider
	public Object[][] getValue()
	{
		Object array [][] = new Object[4][3];
		
		array [0][0] = "TYSS";
		array [0][1] = "Banglore";
		array [0][2] = 250;
		
		array [1][0] = "Qspiders";
		array [1][1] = "Kphb";
		array [1][2] = 350;
		
		array [2][0] = "Jspiders";
		array [2][1] = "Jntu";
		array [2][2] = 100;
		
		array [3][0] = "QJspiders";
		array [3][1] = "Gutta";
		array [3][2] = 550;
		
		return array;
		
	}
	

}
