package com.sysarcinfomatix.service;

import java.util.List;

import com.sysarcinfomatix.entity.CitizenPlan;
import com.sysarcinfomatix.searchDto.SearchRequest;

public interface ReportService {

	
	public List<String> planname();
	public List<String> planStatus();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportExcel();
	public boolean exportpdf();
}
