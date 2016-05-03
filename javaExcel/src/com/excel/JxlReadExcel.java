package com.excel;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class JxlReadExcel {

	public static void main(String[] args) {
		
		try {
			Workbook workbook = Workbook.getWorkbook(new File("e:/Jxl_test.xls"));
			Sheet sheet = workbook.getSheet(0);
			
			for (int i= 0 ; i < sheet.getRows() ; i++){
				for (int j = 0 ; j < sheet.getColumns() ; j++){
					Cell cell = sheet.getCell(j, i);
					System.out.print(cell.getContents()+" ");
				}
				System.out.println();
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
