package com.sysarcinfomatix.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.sysarcinfomatix.entity.CitizenPlan;
import com.sysarcinfomatix.repo.CitezenPlanRepository;
import com.sysarcinfomatix.searchDto.SearchRequest;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

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
       
       if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
    	   entity.setPlanName(request.getPlanName());
    	   
       }
       if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
    	   entity.setPlanStatus(request.getPlanStatus());
       }
       if(null!=request.getGender() && !"".equals(request.getGender())) {
    	   entity.setGender(request.getGender());
       }
       
   	if(null!=request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
              String planStartDate = request.getPlanStartDate();
   		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate date = LocalDate.parse(planStartDate, formater);
   	    entity.setPlanStartDate(date);
   	}
   	
   	if(null!=request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {
        String planEndDate = request.getPlanEndDate();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  LocalDate date = LocalDate.parse(planEndDate, formater);
	    entity.setPlanEndDate(date);
	}
   		
//   		entity.setPlanStartDate();

    	   return repo.findAll(Example.of(entity));
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
