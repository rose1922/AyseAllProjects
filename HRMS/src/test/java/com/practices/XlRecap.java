package com.practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XlRecap {

	@Test
	public void readXlFile() throws IOException {
		
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/practices/Hello.xlsx";
		
		FileInputStream fis=new FileInputStream(filePath);
		
		Workbook wbook=new XSSFWorkbook(fis);
		
		Sheet sheet=wbook.getSheet("Test");
		
		String value=sheet.getRow(1).getCell(0).toString();
		
		System.out.println(value);
		
		int rows=sheet.getPhysicalNumberOfRows();
		
		int cols=sheet.getRow(0).getLastCellNum();
		
		System.out.println(rows);
		
		System.out.println(cols);
		
		// read entire data 1-1 from excel
		
		Object[][] data=new Object[rows-1][cols];
		
		for(int i=1; i<rows; i++) {
			for(int y=0; y<cols; y++) {
				data[i-1][y]=sheet.getRow(i).getCell(y).toString();
			}
		}
		
		for(Object[] rowArray:data) {
			for(Object val:rowArray) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
		wbook.close();
		fis.close();
	}
}
