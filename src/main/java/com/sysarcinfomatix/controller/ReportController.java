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

@Controller
public class ReportController {

	@Autowired
	private ReportService service;

	@PostMapping("/search")
	public String handleSearch(@ModelAttribute ("search") SearchRequest request, Model model) {

		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		init(model);

		return "index";
	}

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
