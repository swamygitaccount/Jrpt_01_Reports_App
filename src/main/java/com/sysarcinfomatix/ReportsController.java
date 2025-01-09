package com.sysarcinfomatix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sysarcinfomatix.service.ReportService;

@Controller
public class ReportsController {

	@Autowired
	private ReportService reportService;
	
	@GetMapping("/")
	public String indexPage() {
		
		
		return "index";
	}
}
