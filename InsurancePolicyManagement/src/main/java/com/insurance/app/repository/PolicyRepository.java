package com.insurance.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.app.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>{
	
	List<Policy> findByPolicyType(String policyType);
	List<Policy> findByCustomerId(Long customerId);
	List<Policy> findByPremiumAmountBetween(Double minSalary, Double maxSalary);
	
	@Query("SELECT p FROM Policy p WHERE p.customer.email = :email")
	List<Policy> findByCustomerEmail(@Param("email") String email);
	
	Page<Policy> findAll(Pageable pageable);
}
