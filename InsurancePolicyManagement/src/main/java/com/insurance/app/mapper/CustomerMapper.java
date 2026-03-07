package com.insurance.app.mapper;

import org.springframework.stereotype.Component;

import com.insurance.app.dto.CustomerRequestDTO;
import com.insurance.app.dto.CustomerResponseDTO;
import com.insurance.app.model.Customer;

@Component
public class CustomerMapper {
	
	public Customer toEntity(CustomerRequestDTO dto) {
		
		return new Customer(
				dto.getName(),
				dto.getEmail(),
				dto.getPhoneNumber(),
				dto.getAddress());
	}
	
	public CustomerResponseDTO toDto(Customer customer) {
		
		return new CustomerResponseDTO(customer.getId(),
									   customer.getName(), 
									   customer.getEmail(), 
									   customer.getPhoneNumber(), 
										customer.getAddress());
		
	}
}
