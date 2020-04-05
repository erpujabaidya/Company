package com.mindtree.company.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.company.dto.CompanyDTO;
import com.mindtree.company.dto.ResponseBody;
import com.mindtree.company.entity.Company;
import com.mindtree.company.exception.CompanyApplicationException;
import com.mindtree.company.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/companies")
	public ResponseEntity<?> addCompany(@Valid @RequestBody CompanyDTO company) {

		Company clientInputDTOToEntity = modelMapper.map(company, Company.class);
		Company serviceOutputEntity = companyservice.addCompany(clientInputDTOToEntity);
		CompanyDTO outputStoreDTOToSend = modelMapper.map(serviceOutputEntity, CompanyDTO.class);
		return new ResponseEntity<ResponseBody<CompanyDTO>>(
				new ResponseBody<CompanyDTO>(outputStoreDTOToSend, null, "Company Added Successfully", true),
				HttpStatus.OK);

	}

	@GetMapping("/companies/{companyName}")
	public List<Company> displayAllPolicy(@PathVariable String companyName) {
		List<Company> companies = companyservice.displayAllPolicy(companyName);
		return companies;
	}

}
