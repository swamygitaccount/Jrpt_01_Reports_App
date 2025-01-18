package com.sysarcinfomatix.service;

import java.util.List;


import com.sysarcinfomatix.entity.CitizenPlan;
import com.sysarcinfomatix.searchDto.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {

	
	public List<String> planname();
	public List<String> planStatus();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	public boolean exportpdf(HttpServletResponse response) throws Exception;
}
