package com.sysarcinfomatix.utils;

import java.io.*;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.sysarcinfomatix.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

// to make this class as spring bean we go for below annotation @Component
@Component
public class ExcelGenerator {

	
	public void generate(HttpServletResponse response,List<CitizenPlan> records,File file) throws Exception {
		
		
//		   HSSFWorkbook implemention class 
//	Workbook is an interface 	  ---"Plans-data" is an sheet name 

//		   XSSFWorkbook workbook = new XSSFWorkbook();  you can use any of the work book
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Plans-data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("CITIZEN NAME");
		headerRow.createCell(2).setCellValue("PLAN NAME");
		headerRow.createCell(3).setCellValue("PLAN STATUS");
		headerRow.createCell(4).setCellValue("PLAN START DATE");
		headerRow.createCell(5).setCellValue("PLAN END DATE");
		headerRow.createCell(6).setCellValue("BENIFIT AMOUNT ");

		int dataRowIndex = 1;
		for (CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitezenId());
			dataRow.createCell(1).setCellValue(plan.getCitezenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			if (null != plan.getPlanStartDate()) {
				dataRow.createCell(4).setCellValue(plan.getPlanStartDate() + "");
			} else {
				dataRow.createCell(4).setCellValue("N/A");
			}
			if (null != plan.getPlanStartDate()) {
				dataRow.createCell(5).setCellValue(plan.getPlanStartDate() + "");
			} else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			if (null != plan.getBenifitAmount()) {

			} else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			dataRowIndex++;
		}

		// to write te data to the file
//		
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close(); 

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	/**
	 * once workboot created, workbook writing to the servelet out put stream and workbook writing to the file output stream
	 * ServletOutputStream is for send to the broswer  and FileOutputStream is send to the mail
	 * 
	 */
	
	}
	



}
