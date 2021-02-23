package com.learningframework.Utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataUtility {
	
	XSSFWorkbook wb ;
	public TestDataUtility()// this constructor will load the excel as soon we create a TestdataUtility class
	{
			
			File src = new File("./TestDataProvider/TestData.xlsx");
			try {
				FileInputStream fis = new FileInputStream(src); // fileinputstream will convert the file into a raw data
				wb = new XSSFWorkbook(fis);
				
				} 
				catch (Exception e)
				{
						System.out.println("Unable to read the Excel File "+e.getMessage());
				}
			
	}
		
	
	public  String  getStringData(int sheetnumber, int rownum, int colnum) // here is an example of Method overloading
	{
		return wb.getSheetAt(sheetnumber).getRow(rownum).getCell(colnum).getStringCellValue();
	}

	
	public   String  getStringData(String worksheename, int rownum, int colnum) // here is an example of Method overloading
	{
		return wb.getSheet(worksheename).getRow(rownum).getCell(colnum).getStringCellValue();
	}
	
	public double  getNumericData()
	{
		return wb.getSheet("").getRow(0).getCell(0).getNumericCellValue();
	}

	
	
	
}
