package com.alsis.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead1 {

	public static List<String> getExcellist(String FileName, String SheetName) throws Exception {
		List<String> excellist = null;
		FileInputStream fis = new FileInputStream(FileName);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(SheetName);
		int r = sh.getLastRowNum();
		int c = sh.getRow(r).getLastCellNum();
		excellist = new ArrayList<String>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				String excelvalue = sh.getRow(i + 1).getCell(j).toString();
				excellist.add(excelvalue);
				/*
				 * for(String a:excellist) { System.out.println(a); System.out.println(); }
				 */
			}
		}
		return excellist;
	}

	public static String[][] getExcelData(String FileName, String SheetName) throws IOException {
		String[][] arrayExcelData = null;

		FileInputStream fis = new FileInputStream(FileName);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(SheetName);
		int r = sh.getLastRowNum();
		int c = sh.getRow(r).getLastCellNum();
		arrayExcelData = new String[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arrayExcelData[i][j] = sh.getRow(i + 1).getCell(j).toString();
			}
		}
		return arrayExcelData;
	}

}
