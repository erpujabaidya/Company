package com.mindtree.company.service;

import com.mindtree.company.entity.Policy;
import com.mindtree.company.exception.service.CompanyServiceApplicationException;

public interface PolicyService {

	Policy assignPolicy(Policy policy, long companyId);

	//String deletePolicyByName(String policyName);

	void deletePolicy(String policyName) throws CompanyServiceApplicationException;

	

}
