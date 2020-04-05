package com.mindtree.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.company.entity.Customer;
import com.mindtree.company.exception.service.CompanyServiceApplicationException;
import com.mindtree.company.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	@PutMapping("/customer/{policyId}")
	private ResponseEntity<?> addCustomer(@RequestBody Customer customer,@PathVariable int policyId){
		Customer customers;
		try {
			customers=customerservice.assignCustomer(customer,policyId);
			return new ResponseEntity<Customer>(customers,HttpStatus.ACCEPTED);
		} catch (CompanyServiceApplicationException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}

}
