package com.demo.opencart.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutil {

	private static String Test_DataFile = "./src/main/java/com/demo/opencart/qa/testdata/Ecom_opensource_TestData.xlsx";

	private static Workbook book;

	public static Object[][] getTestData(String SheetName) {

		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(Test_DataFile);

			book = WorkbookFactory.create(ip);
			Sheet sheet = book.getSheet(SheetName);

			// Object data[][]=new Object[4][5];**We could have given like this as
			// well.however tomorow if we have more rows getting added then

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString().trim();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
