package com.sysarcinfomatix.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sysarcinfomatix.entity.CitizenPlan;
import com.sysarcinfomatix.repo.CitezenPlanRepository;
@Component
public class DataLoader implements ApplicationRunner{
	@Autowired
	private CitezenPlanRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		CitizenPlan c1 = new CitizenPlan();
c1.setCitezenName("john");
c1.setGender("male");
c1.setPlanName("cash");
c1.setPlanStatus("Approved");
c1.setPlanStartDate(LocalDate.now());
c1.setPlanEndDate(LocalDate.now().plusMonths(6));
c1.setBenifitAmount("5000.00");
CitizenPlan c2 = new CitizenPlan();
c2.setCitezenName("cathy");
c2.setGender("Fe- male");
c2.setPlanName("cash");
c2.setPlanStatus("Dennied");
c2.setDenialReason("rental income");

CitizenPlan c3 = new CitizenPlan();

c3.setCitezenName("cathy");
c3.setGender("Fe- male");
c3.setPlanName("cash");
c3.setPlanStatus("Terminated");
c3.setPlanStartDate(LocalDate.now().minusMonths(4));
c3.setPlanEndDate(LocalDate.now().plusMonths(6));
c3.setBenifitAmount("6000");
c3.setTerminatedDate(LocalDate.now());
c3.setTerminationRsn("Employed");

CitizenPlan c4 = new CitizenPlan();
c4.setCitezenName("Ram");
c4.setGender("male");
c4.setPlanName("Food");
c4.setPlanStatus("Approved");
c4.setPlanStartDate(LocalDate.now());
c4.setPlanEndDate(LocalDate.now().plusMonths(6));
c4.setBenifitAmount("5000.00");
CitizenPlan c5 = new CitizenPlan();
c5.setCitezenName("Roopa");
c5.setGender("Fe- male");
c5.setPlanName("cash");
c5.setPlanStatus("Dennied");
c5.setDenialReason("rental income");
CitizenPlan c6 = new CitizenPlan();
c6.setCitezenName("deepak");
c6.setGender("male");
c6.setPlanName("Food");
c6.setPlanStatus("Terminated");
c6.setPlanStartDate(LocalDate.now().minusMonths(4));
c6.setPlanEndDate(LocalDate.now().plusMonths(6));
c6.setBenifitAmount("10000");
c6.setTerminatedDate(LocalDate.now());
c6.setTerminationRsn("Employed");
CitizenPlan c7 = new CitizenPlan();
c7.setCitezenName("mahesh");
c7.setGender("male");
c7.setPlanName("cash");
c7.setPlanStatus("Approved");
c7.setPlanStartDate(LocalDate.now());
c7.setPlanEndDate(LocalDate.now().plusMonths(6));
c7.setBenifitAmount("5000.00");
CitizenPlan c8 = new CitizenPlan();
c8.setCitezenName("rachana");
c8.setGender("Fe- male");
c8.setPlanName("cash");
c8.setPlanStatus("Dennied");
c8.setDenialReason("rental income");
CitizenPlan c9 = new CitizenPlan();
c9.setCitezenName("ramya");
c9.setGender("Fe- male");
c9.setPlanName("medical");
c9.setPlanStatus("Terminated");
c9.setPlanStartDate(LocalDate.now().minusMonths(4));
c9.setPlanEndDate(LocalDate.now().plusMonths(6));
c9.setBenifitAmount("5000.00");
c9.setTerminatedDate(LocalDate.now());
c9.setTerminationRsn("Employed");
CitizenPlan c10 = new CitizenPlan();
c10.setCitezenName("sudeep");
c10.setGender("male");
c10.setPlanName("cash");
c10.setPlanStatus("Approved");
c10.setPlanStartDate(LocalDate.now());
c10.setPlanEndDate(LocalDate.now().plusMonths(6));
c10.setBenifitAmount("12000.00");
CitizenPlan c11 = new CitizenPlan();
c11.setCitezenName("rachana");
c11.setGender("Fe- male");
c11.setPlanName("food");
c11.setPlanStatus("Dennied");
c11.setDenialReason("rental income");
CitizenPlan c12 = new CitizenPlan();
c12.setCitezenName("kavya");
c12.setGender("Fe- male");
c12.setPlanName("medical");
c12.setPlanStatus("Terminated");
c12.setPlanStartDate(LocalDate.now().minusMonths(4));
c12.setPlanEndDate(LocalDate.now().plusMonths(6));
c12.setBenifitAmount("6000");
c12.setTerminatedDate(LocalDate.now());
c12.setTerminationRsn("Employed");
CitizenPlan c13 = new CitizenPlan();
c13.setCitezenName("cathy");
c13.setGender("Fe- male");
c13.setPlanName("cash");
c13.setPlanStatus("Dennied");
c13.setDenialReason("rental income");
List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13);
repo.saveAll(list);
	}
}
