package com.excel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlExpExcel {

	public static void main(String[] args) {
		
		String[] title = {"id","name","sex"};
		
		File file = new File("e:/Jxl_test.xls");
		
		try {
			file.createNewFile();
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			
			for(int i = 0 ; i < title.length ; i++){
				label = new Label(i,0,title[i]);
				sheet.addCell(label);
			}
			
			for(int i = 1 ; i < 10 ; i++){
				label = new Label(0,i,"a"+i);
				sheet.addCell(label);
				label = new Label(1,i,"username"+i);
				sheet.addCell(label);
				label = new Label(2,i,"male");
				sheet.addCell(label);
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
