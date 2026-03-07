package com.insurance.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.insurance.app.dto.CustomerRequestDTO;
import com.insurance.app.dto.CustomerResponseDTO;
import com.insurance.app.exception.CustomerNotFoundException;
import com.insurance.app.mapper.CustomerMapper;
import com.insurance.app.model.Customer;
import com.insurance.app.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository repository;
	private CustomerMapper customerMapper;
	
	public CustomerService(CustomerRepository repository, CustomerMapper customerMapper) {
		this.repository = repository;
		this.customerMapper = customerMapper;
	}

	public CustomerResponseDTO createCustomer(CustomerRequestDTO dto){
		
		Customer customer = customerMapper.toEntity(dto);
		
		return customerMapper.toDto(repository.save(customer));
	}
	
	public List<CustomerResponseDTO> getAllCustomers(){
		
		return repository.findAll().stream().map(customerMapper::toDto).collect(Collectors.toList());
	}
	
	public CustomerResponseDTO getCustomerById(Long id) {
		
		Customer customer = repository.findById(id).orElseThrow(
				() -> new CustomerNotFoundException("Customer not found with id: "+id));
		
		return customerMapper.toDto(customer);
	}
	
	public Customer getCustomerEntityById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new CustomerNotFoundException("Customer not found with id: "+id));
	}
}
