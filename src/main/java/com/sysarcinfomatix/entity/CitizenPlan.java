package com.sysarcinfomatix.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="CITIZEN_PLANS_INFO")
public class CitizenPlan {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citezenId;
	private String citezenName;
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String benifitAmount;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminationRsn;
	
	
	public Integer getCitezenId() {
		return citezenId;
	}
	public void setCitezenId(Integer citezenId) {
		this.citezenId = citezenId;
	}
	public String getCitezenName() {
		return citezenName;
	}
	public void setCitezenName(String citezenName) {
		this.citezenName = citezenName;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	public String getBenifitAmount() {
		return benifitAmount;
	}
	public void setBenifitAmount(String benifitAmount) {
		this.benifitAmount = benifitAmount;
	}
	public String getDenialReason() {
		return denialReason;
	}
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	public LocalDate getTerminatedDate() {
		return terminatedDate;
	}
	public void setTerminatedDate(LocalDate terminatedDate) {
		this.terminatedDate = terminatedDate;
	}
	public String getTerminationRsn() {
		return terminationRsn;
	}
	public void setTerminationRsn(String terminationRsn) {
		this.terminationRsn = terminationRsn;
	}
	
	
	
	
}
