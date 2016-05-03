package com.excel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIReadExcel {

	public static void main(String[] args) {
		
		File file = new File("e:/poi_test.xls");
		
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);
			int fristRownum = 0;
			int lastRownum = sheet.getLastRowNum();
			
			for (int i = fristRownum; i <= lastRownum; i++){
				HSSFRow row = sheet.getRow(i);
				int lastCellnum = row.getLastCellNum();
				
				for (int j = 0; j < lastCellnum; j++){
					HSSFCell cell = row.getCell(j);
					String cellValue = cell.getStringCellValue();
					System.out.print(cellValue+" ");
				}
				System.out.println();
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
