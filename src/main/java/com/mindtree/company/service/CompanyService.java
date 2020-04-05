package com.mindtree.company.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.company.entity.Company;

public interface CompanyService {

	

	List<Company> displayAllPolicy(String companyName);

	Company addCompany(Company company);

	//List<Company> displayAllPolicy();




}
