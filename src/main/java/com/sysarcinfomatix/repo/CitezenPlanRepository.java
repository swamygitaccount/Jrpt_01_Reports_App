package com.sysarcinfomatix.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sysarcinfomatix.entity.CitizenPlan;

public interface CitezenPlanRepository extends JpaRepository<CitizenPlan, Integer> {
	
	
	@Query("select distinct (planName) from CitizenPlan")	
	public List<String> getPlanNames();
	
	@Query("select distinct (PlanStatus) from CitizenPlan")
	public List<String> getPlanStatus();

}
