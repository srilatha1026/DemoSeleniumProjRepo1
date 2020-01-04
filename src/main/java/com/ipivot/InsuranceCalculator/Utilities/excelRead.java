package com.ipivot.InsuranceCalculator.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {

	public Object[][] ExcelDataInObjectArray() throws IOException {
	//public static void main(String args[]) throws IOException {
		//Location of file: We should first know where the excel file is located
		String filepath = System.getProperty("user.dir")+"/src/test/resources/ExcelTestData/VehicleInsCalculator_TestData.xlsx";
		
		//to work withfile we need to create the object of file
		File xlFile = new File(filepath);
		
		//fileinputstream is used to read the data from file
		FileInputStream fis = new FileInputStream(xlFile);
		
		//start reading the data from xlfile so we made fileinputstream object
		//1.create obj for workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		//get the work sheet
		XSSFSheet sheet = wb.getSheet("InsurancePremium");
		
		
		//find total no of rows in xcel
		int totalNoOfRows =sheet.getLastRowNum()+1;
		int totNoOfCols = sheet.getRow(0).getLastCellNum();
		//Creating object array to store map
//		String[][] vehData =new String [totalNoOfRows][totNoOfCols];
		Object[][] vehData =new Object [totalNoOfRows-1][1];
		//create an instance for the map
		Map<String,String> dataMap = new HashMap<String, String>();
		Map<String,String> tempMap ;

		//why array
		//data provider in testng is used in data driven testing
		for(int i=1; i <totalNoOfRows;i++){
			tempMap = new HashMap<String, String>();
			  for(int j=0;j<totNoOfCols;j++) 
			   		{
				   sheet.getRow(i).getCell(j).setCellType(CellType.STRING);//setting the values in excel sheet as string
				   dataMap.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i).getCell(j).getStringCellValue());
					}
			  tempMap.putAll(dataMap);
			 vehData[i-1][0]=tempMap;
			 
			}
//		System.out.println(vehData[1][0]);
//		System.out.println(vehData[2][0]);
//		System.out.println(vehData[3][0]);
		return vehData; 
		
//		wb.close();
		
	}

//	public Map getMapDataFromRow(int rowNum) {
//		Map<String,String> mapData = new HashMap<String,String>();
//		int totNoOfCols = sheet.getRow(0).getLastCellNum();
//		int rowSize = totNoOfCols;
//		for(int i=0;i<=rowSize;i++) {
//			
//		}
//		return mapData;
//	}

}
