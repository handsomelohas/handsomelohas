package com.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIExpExcel {

	public static void main(String[] args) {
		
		String[] title = {"id","name","sex"};
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		
		for (int i = 0; i < title.length; i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		
		for (int i = 1; i < 10; i++){
			HSSFRow nextRow = sheet.createRow(i);
			HSSFCell cell2 = nextRow.createCell(0);
			cell2.setCellValue("a"+i);
			cell2 = nextRow.createCell(1);
			cell2.setCellValue("username"+i);
			cell2 = nextRow.createCell(2);
			cell2.setCellValue("male");
			
		}
		
		File file = new File("e:/Poi_test.xls");
		
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
