package com.qa.splashmath.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtil {
	
	public static String TEST_DATA_SHEET_PATH= "/Users/sandeepnegi/eclipse-workspace/SplashmathDemoProject11/src/main/java/com/qa/splashmath/testData/ParentLogin.xls";
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getData(String sheetName) {
		try {
			FileInputStream file = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);
			
			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i =0; i < sheet.getLastRowNum(); i++) {
				for(int j=0; j< sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			return data;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
