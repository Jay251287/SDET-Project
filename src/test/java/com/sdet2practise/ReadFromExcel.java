package com.sdet2practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 
		String dirpath= System.getProperty("user.dir");
		String Excelpath = dirpath+ "./scriptdata.xlsx";
		
		FileInputStream fis = new FileInputStream(Excelpath);
		
		Workbook workbook = WorkbookFactory.create(fis);
		
		Sheet sheet = workbook.getSheet("sheet1");
		
		Row row = sheet.getRow(1);
		String value = row.getCell(1).getStringCellValue();
		int i = Integer.parseInt(value);
		
		System.out.println(i);
		
		

	}

}
