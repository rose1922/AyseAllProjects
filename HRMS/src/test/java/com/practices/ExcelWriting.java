package com.practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriting {

	@Test
	public void writeExcel() throws IOException {
		
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/practices/Hello.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		Workbook book=new XSSFWorkbook(fis);
		Sheet sheet=book.getSheet("Test");
		sheet.getRow(0).createCell(2).setCellValue("Language");
		sheet.getRow(0).getCell(2).setCellValue("Instructor");
		
		sheet.createRow(4).createCell(0).setCellValue("Kareem");
		sheet.getRow(4).createCell(1).setCellValue("Enes");
		
		FileOutputStream fos=new FileOutputStream(filePath);
		book.write(fos);
		book.close();
		fos.close();
		fis.close();
		
	}
}
