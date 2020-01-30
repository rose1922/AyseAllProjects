package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility_1 {
	
	public static FileInputStream fis;
	public static Workbook wbook;
	public static Sheet sheet;
	public static void openExcel(String filePath, String sheetName) {
		try {
			fis=new FileInputStream(filePath);
			wbook=new XSSFWorkbook(fis);
			sheet=wbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int colCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	public static String readCell(int rownum, int cellnum) {
		return sheet.getRow(rownum).getCell(cellnum).toString();
	}
	
	public static Object[][] excellToArray(String filePath, String sheetName){
		openExcel(filePath, sheetName);
		Object[][] data=new Object[rowCount()-1][colCount()];
		for(int i=1; i<rowCount(); i++) {
			for(int y=0; y<colCount(); y++) {
				data[i-1][y]=readCell(i, y);
			}
		}
		
		return data;
	}
}
