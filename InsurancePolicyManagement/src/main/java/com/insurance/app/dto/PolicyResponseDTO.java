package com.insurance.app.dto;

import java.time.LocalDate;

public class PolicyResponseDTO {
	
	private Long id;
	private String policyNumber;
	private String policyType;
	
	private Double premiumAmount;
	private Double coverageAmount;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	private String status;
	private CustomerResponseDTO customer;
	
	public PolicyResponseDTO(Long id, String policyNumber, String policyType, Double premiumAmount,
			Double coverageAmount, LocalDate startDate, LocalDate endDate, String status,
			CustomerResponseDTO customer) {
		this.id = id;
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public String getPolicyType() {
		return policyType;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getStatus() {
		return status;
	}

	public CustomerResponseDTO getCustomer() {
		return customer;
	}
	
	
	
}
