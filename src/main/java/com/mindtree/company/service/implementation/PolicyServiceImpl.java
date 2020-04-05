package com.mindtree.company.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.company.entity.Company;
import com.mindtree.company.entity.Policy;
import com.mindtree.company.exception.service.CompanyServiceApplicationException;
import com.mindtree.company.exception.service.customexception.PolicyNotDeletedException;
import com.mindtree.company.repository.CompanyRepository;
import com.mindtree.company.repository.PolicyRepository;
import com.mindtree.company.service.PolicyService;
@Service
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	private PolicyRepository policyrepository;
	@Autowired
	private CompanyRepository companyrepository;
	@Override
	public Policy assignPolicy(Policy policy, long companyId) {
		Company company=companyrepository.findById(companyId).orElse(null);
		company.getPolicys().add(policy);
		policy.setCompany(company);
		
		return policyrepository.save(policy);
	}

	
	@Override
	public void deletePolicy(String policyName) throws CompanyServiceApplicationException {
		Policy policy=policyrepository.findByPolicyName(policyName).orElseThrow(() -> new PolicyNotDeletedException("Policy With this name is not found"));
		policyrepository.delete(policy);
	}
}
