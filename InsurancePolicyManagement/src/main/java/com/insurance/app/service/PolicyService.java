package com.insurance.app.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.insurance.app.dto.PolicyRequestDTO;
import com.insurance.app.dto.PolicyResponseDTO;
import com.insurance.app.exception.PolicyNotFoundException;
import com.insurance.app.mapper.PolicyMapper;
import com.insurance.app.model.Customer;
import com.insurance.app.model.Policy;
import com.insurance.app.repository.PolicyRepository;

@Service
public class PolicyService {
	private PolicyRepository repository;
	private PolicyMapper mapper;
	private CustomerService customerService;
	
	public PolicyService(PolicyRepository repository, PolicyMapper mapper, CustomerService customerService) {
		this.repository = repository;
		this.mapper = mapper;
		this.customerService = customerService;
	}
	
	
	public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
		Customer customer = customerService.getCustomerEntityById(dto.getCustomerId());
		Policy policy = mapper.toEntity(dto, customer);
		
		return mapper.toDto(repository.save(policy));
	}
	
	public Page<PolicyResponseDTO> getAllPolicies(int page, int size, String sortBy){
		
		return repository.findAll(PageRequest.of(page, size, Sort.by(sortBy))).map(mapper::toDto);
	}
	
	public PolicyResponseDTO getPolicyById(Long id) {
		
		Policy policy = repository.findById(id).orElseThrow(
				() -> new PolicyNotFoundException("Policy not found with id: "+id));
		
		return mapper.toDto(policy); 
	}
	
	public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {
        Policy policy = repository.findById(id)
            .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        
        Customer customer = customerService.getCustomerEntityById(dto.getCustomerId());
        
        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setCustomer(customer);
        
        return mapper.toDto(repository.save(policy));
    }

    public void cancelPolicy(Long id) {
        Policy policy = repository.findById(id)
            .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        
        policy.setStatus("CANCELLED");
        
        repository.save(policy);
    }

    public List<PolicyResponseDTO> getPoliciesByType(String policyType) {
        return repository.findByPolicyType(policyType)
            .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByPremiumRange(Double min, Double max) {
        return repository.findByPremiumAmountBetween(min, max)
            .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByCustomerEmail(String email) {
        return repository.findByCustomerEmail(email)
            .stream().map(mapper::toDto).collect(Collectors.toList());
    }
	
}
