package com.sysarcinfomatix.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sysarcinfomatix.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	public void generate(HttpServletResponse response, List<CitizenPlan> plans,File f) throws Exception{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
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
		
	}
	
	
}
