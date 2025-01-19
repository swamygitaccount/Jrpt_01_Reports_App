package com.sysarcinfomatix.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.sysarcinfomatix.entity.CitizenPlan;
import com.sysarcinfomatix.repo.CitezenPlanRepository;
import com.sysarcinfomatix.searchDto.SearchRequest;
import com.sysarcinfomatix.utils.EmailUtils;
import com.sysarcinfomatix.utils.ExcelGenerator;
import com.sysarcinfomatix.utils.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitezenPlanRepository repo;

	@Autowired
	private ExcelGenerator generator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
	private EmailUtils emailUtils;
	
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

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());

		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
			String planStartDate = request.getPlanStartDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(planStartDate, formater);
			entity.setPlanStartDate(date);
		}

		if (null != request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {
			String planEndDate = request.getPlanEndDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(planEndDate, formater);
			entity.setPlanEndDate(date);
		}

//   		entity.setPlanStartDate();

		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
// single reponiblity principle = one class should perfomr only one action
	File f = new File("plans.xlsx");

 List<CitizenPlan> plans = repo.findAll();
// calling exel generator class 
generator.generate(response, plans,f);
String subject = "Test mail subject";
String body = "<h1>Text mail body</h1>";
String to ="swamy0801234@gmail.com";
emailUtils.sendEmail(subject, body, to,f);
f.delete();// after the sending the file we need to delete the file in the folder
		return true;
	}

	@Override
	public boolean exportpdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("pdfPlans.pdf");
List<CitizenPlan> pdfPlans = repo.findAll();
pdfGenerator.generate(response, pdfPlans,file);

String subject = "Test mail subject";
String body = "<h1>Text mail body pdf</h1>";
String to ="swamy0801234@gmail.com";
emailUtils.sendEmail(subject, body, to,file);

 file.delete();
		return true;
	}
}
