package com.sysarcinfomatix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysarcinfomatix.entity.CitizenPlan;
import com.sysarcinfomatix.repo.CitezenPlanRepository;
import com.sysarcinfomatix.searchDto.SearchRequest;

@Service
public class ReportServiceImpl implements ReportService {

	
	@Autowired
	private CitezenPlanRepository repo;
	
	@Override
	public List<String> planname() {

		
		return null;
	}

	@Override
	public List<String> planStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportpdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
