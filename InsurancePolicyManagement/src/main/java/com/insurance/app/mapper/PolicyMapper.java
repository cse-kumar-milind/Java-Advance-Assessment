package com.insurance.app.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insurance.app.dto.PolicyRequestDTO;
import com.insurance.app.dto.PolicyResponseDTO;
import com.insurance.app.model.Customer;
import com.insurance.app.model.Policy;

@Component
public class PolicyMapper {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public Policy toEntity(PolicyRequestDTO dto, Customer customer) {
		
		return new Policy(dto.getPolicyNumber(),
						  dto.getPolicyType(),
						  dto.getPremiumAmount(),
						  dto.getCoverageAmount(),
						  dto.getStartDate(),
						  dto.getEndDate(),
						  "ACTIVE",
						  customer);
	}
	
	
	public PolicyResponseDTO toDto(Policy policy) {
		return new PolicyResponseDTO(policy.getId(),
									 policy.getPolicyNumber(),
									 policy.getPolicyType(), 
									 policy.getPremiumAmount(), 
									 policy.getCoverageAmount(), 
									 policy.getStartDate(),
									 policy.getEndDate(),
									 policy.getStatus(),
									 customerMapper.toDto(policy.getCustomer()));
	}
}
