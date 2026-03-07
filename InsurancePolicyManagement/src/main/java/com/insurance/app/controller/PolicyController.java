package com.insurance.app.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.app.dto.PolicyRequestDTO;
import com.insurance.app.dto.PolicyResponseDTO;
import com.insurance.app.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
	
	private PolicyService policyService;
	
	

    public PolicyController(PolicyService policyService) {
		this.policyService = policyService;
	}

    @PostMapping
    public ResponseEntity<PolicyResponseDTO> create(@Valid @RequestBody PolicyRequestDTO dto) {
        return new ResponseEntity<>(policyService.createPolicy(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<PolicyResponseDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return ResponseEntity.ok(policyService.getAllPolicies(page, size, sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody PolicyRequestDTO dto) {
        return ResponseEntity.ok(policyService.updatePolicy(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        policyService.cancelPolicy(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PolicyResponseDTO>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(policyService.getPoliciesByType(type));
    }

    @GetMapping("/premium")
    public ResponseEntity<List<PolicyResponseDTO>> getByPremiumRange(
            @RequestParam Double min,
            @RequestParam Double max) {
        return ResponseEntity.ok(policyService.getPoliciesByPremiumRange(min, max));
    }
}
