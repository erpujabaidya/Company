package com.mindtree.company.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.company.dto.ResponseBody;
import com.mindtree.company.entity.Policy;
import com.mindtree.company.exception.CompanyApplicationException;
import com.mindtree.company.service.PolicyService;

@RestController
public class PolicyController {
	@Autowired
	private PolicyService policyService;

	@PutMapping("/policy/{companyId}")
	private Policy assignPolicy(@RequestBody Policy policy, @PathVariable long companyId) {
		Policy policys = policyService.assignPolicy(policy, companyId);
		return policys;
	}
	
	@DeleteMapping("/policy/{policyName}")
	public ResponseEntity<?> deletePolicy(@PathVariable String policyName) throws CompanyApplicationException {
		policyService.deletePolicy(policyName);
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null, null, "Policy Successfully Deleted", true), HttpStatus.OK);
	}

}
