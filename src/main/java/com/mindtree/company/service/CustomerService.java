package com.mindtree.company.service;

import com.mindtree.company.entity.Customer;
import com.mindtree.company.exception.service.CompanyServiceApplicationException;

public interface CustomerService {

	Customer assignCustomer(Customer customer, int policyId) throws CompanyServiceApplicationException;

}
