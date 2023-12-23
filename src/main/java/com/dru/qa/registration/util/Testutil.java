package com.dru.qa.registration.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.dru.qa.registration.base.Testbase;

public class Testutil extends Testbase{

	public static long page_load = 20;
	public static long implict_wait = 5;

	public static String Test_Data_Sheet = "E:/LRMRegistration/src/main/java/com/dru/qa/registration/testdata/LRMRgistration.xlsx";

	static Workbook book;
	static Sheet sheet;

	// TO READ DATA FROM EXCEL SHEET
	public static Object[][] getTestData(String sheetname){
		 //    getTestDataSheetPath();
			FileInputStream file = null;
			try {
				file = new FileInputStream(Test_Data_Sheet);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
			try {
				book = WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}					
			sheet=book.getSheet(sheetname);
			Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//	  System.out.println(sheet.getLastRowNum() + "--------" );
		//    sheet.getRow(0).getLastCellNum());
			
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
			// System.out.println(sheet.getRow(i+1).getCell(k).toString());
			// System.out.println(i+1);	
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			// System.out.println(data[i][k]);
				}
			}
		  return data;
	}
}
		

