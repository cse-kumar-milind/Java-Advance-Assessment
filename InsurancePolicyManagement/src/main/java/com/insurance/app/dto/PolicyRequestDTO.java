package com.insurance.app.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class PolicyRequestDTO {
	
	@NotBlank(message = "PolicyNumber cannot be blank")
	private String policyNumber;
	
	private String policyType;
	
	@Positive(message = "Premium amount must be positive")
	private Double premiumAmount;
	@Positive(message = "Coverage amount must be positive")
	private Double coverageAmount;
	
	@NotNull(message = "Start Date cannot be null")
	private LocalDate startDate;
	private LocalDate endDate;
	
	@NotBlank(message = "Status cannot be blank")
	private String status;
	
	@NotNull(message = "Customer Id cannot be null")
	private Long customerId;

	public PolicyRequestDTO() {
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomer(Long customerId) {
		this.customerId = customerId;
	}
	
	
	
}
