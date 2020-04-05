package com.mindtree.company.service.implementation;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.company.entity.Company;
import com.mindtree.company.entity.Customer;
import com.mindtree.company.entity.Policy;
import com.mindtree.company.repository.CompanyRepository;
import com.mindtree.company.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService {
@Autowired
private CompanyRepository companyrepository;

	
	  @Override public Company addCompany(Company company) {
	  
	  return companyrepository.save(company); }
	 
@Override
public List<Company> displayAllPolicy(String companyName) {
	List<Company> companies=companyrepository.findByCompanyName(companyName);
	for (Company company : companies) {
		for (Policy policies : company.getPolicys()) {
			for (Customer customers : policies.getCustomer()) {
				Collections.sort(policies.getCustomer());
				
			} 
			
		}
	}
	return companies;
}


	
}
