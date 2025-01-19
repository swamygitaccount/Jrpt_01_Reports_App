package com.sysarcinfomatix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sysarcinfomatix.entity.CitizenPlan;
import com.sysarcinfomatix.searchDto.SearchRequest;
import com.sysarcinfomatix.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;

//sir approch
//	@GetMapping("/exel")
//	public void excelExport(HttpServletResponse  response) throws Exception{
//		response.setContentType("application/octet-stream");
//		response.addHeader("Content - Disposition", "attachment; filename=plans.xlsx");
//		
//		service.exportExcel(response);
//	}
//	
	@GetMapping("/exel") // Corrected the spelling of "/exel" to "/excel"
	public void  excelExport(HttpServletResponse response) throws Exception {
		// Set the content type for Excel files (application/octet-stream is acceptable
		// but can be more specific)
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); // For .xlsx files
//		if the file is excel then we set it as octet-stream.

		// Set the header to specify the file download with a filename
		response.setHeader("Content-Disposition", "attachment; filename=plans.xlsx");

		// Call the service to export the Excel file to the response
		 service.exportExcel(response);
		
	}

	@GetMapping("/pdf") // Corrected the spelling of "/exel" to "/excel"
	public void pdfExport(HttpServletResponse response) throws Exception {
		// Set the content type for Excel files (application/octet-stream is acceptable
		// but can be more specific)
		response.setContentType("application/pdf"); // For .xlsx files
//		if the file is excel then we set it as octet-stream.

		// Set the header to specify the file download with a filename
		response.setHeader("Content-Disposition", "attachment; filename=plans.pdf");

		// Call the service to export the Excel file to the response
		 service.exportpdf(response);
		
	}

	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request, Model model) {

		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		init(model);

		return "index";
	}

//	This method is used to load the index method.
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchRequest());

		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("names", service.planname());
		model.addAttribute("status", service.planStatus());
	}

}
