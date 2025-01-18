package com.sysarcinfomatix.service;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sysarcinfomatix.entity.CitizenPlan;
import com.sysarcinfomatix.repo.CitezenPlanRepository;
import com.sysarcinfomatix.searchDto.SearchRequest;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitezenPlanRepository repo;

	@Override
	public List<String> planname() {
		return repo.getPlanNames();

	}

	@Override
	public List<String> planStatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());

		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
			String planStartDate = request.getPlanStartDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(planStartDate, formater);
			entity.setPlanStartDate(date);
		}

		if (null != request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {
			String planEndDate = request.getPlanEndDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(planEndDate, formater);
			entity.setPlanEndDate(date);
		}

//   		entity.setPlanStartDate();

		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

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
		List<CitizenPlan> records = repo.findAll();

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
//		FileOutputStream fos = new FileOutputStream(new File("plans.xls"));
//		workbook.write(fos);
//		workbook.close(); 
//			 insted of going for FileOutPutStream going below response out put stream
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		return true;
	}

	@Override
	public boolean exportpdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		com.lowagie.text.Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);
		Paragraph p = new Paragraph("Citizen Plans Info", fontTiltle);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);

//	 in the below creating the table with cell size 6 
		PdfPTable table = new PdfPTable(8);
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan status");
		table.addCell("Gender");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		table.addCell("BENIFIT AMOUNT");
		List<CitizenPlan> plans = repo.findAll();
		for (CitizenPlan plan : plans) {

			table.addCell(String.valueOf(plan.getCitezenId()));
			table.addCell(plan.getCitezenName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getGender());
			if (null != plan.getPlanStartDate()) {
				table.addCell(String.valueOf(plan.getPlanStartDate()));

			} else {
				table.addCell(String.valueOf("N/A"));

			}
			if (null != plan.getPlanEndDate()) {
				table.addCell(plan.getPlanEndDate() + "");
			} else {
				table.addCell("N/A");
			}
			table.addCell(plan.getBenifitAmount());
		}
		document.add(table);
		document.close();
		return true;
	}
}
