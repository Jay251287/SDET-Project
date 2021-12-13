package com.Vtiger.genericLib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static ExcelUtil objforExcelUtil()
	{
		ExcelUtil excel = new ExcelUtil();
		return excel;
	}
	
	/**
	 * @author SWATHI
	 * Description : This method reads the data from excel file
	 * @param key
	 * @return excelvalue
	 * @throws IOException
	 */
	public String readDatafromExcelFile(String sheetName, int row, int cell) throws IOException 
	{
		
		FileInputStream fis = new FileInputStream(IAutoConstants.Excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		String excelValue = workbook.getSheet(sheetName).getRow(row).getCell(cell).toString();	
		return excelValue;
	}
	
	/**
	 *  @author SWATHI
	 * Description : This method reads the data from excel file the last row value
	 * @param path
	 * @param sheet
	 * @return lastrow number
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getLastRow(String sheet, int cell, String ddvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IAutoConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount= wb.getSheet(sheet).getLastRowNum();
		String lastrow = "null";
		for(int i=0; i<rowCount; i++)
		{
			lastrow = wb.getSheet(sheet).getRow(i).getCell(cell).getStringCellValue().toString();
			if(lastrow.equalsIgnoreCase(ddvalue))
			{
				break;
			}
		}
		return lastrow;
		
	}

}
