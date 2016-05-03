package com.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIExpExcel2 {

	public static void main(String[] args) {
		
		String[] title = {"id","name","sex"};
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		Cell cell = null;
		
		for (int i = 0; i < title.length; i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		for (int i = 1; i < 10; i++){
			Row nextRow = sheet.createRow(i);
			Cell cell2 = nextRow.createCell(0);
			cell2.setCellValue("a"+i);
			cell2 = nextRow.createCell(1);
			cell2.setCellValue("user"+i);
			cell2 = nextRow.createCell(2);
			cell2.setCellValue("male");
		}
		
		File file = new File("e:/poi_test.xlsx");
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
