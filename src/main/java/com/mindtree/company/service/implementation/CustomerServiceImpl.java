package com.mindtree.company.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.company.entity.Customer;
import com.mindtree.company.entity.Policy;
import com.mindtree.company.exception.service.CompanyServiceApplicationException;
import com.mindtree.company.exception.service.customexception.CustomerAgeNotMatchException;
import com.mindtree.company.repository.CustomerRepository;
import com.mindtree.company.repository.PolicyRepository;
import com.mindtree.company.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
	private PolicyRepository policyrepository;
	@Override
	public Customer assignCustomer(Customer customer, int policyId) throws CompanyServiceApplicationException {
		Policy policy=policyrepository.findById(policyId).orElse(null);
		int age=customer.getAge();
		if(age>=20 && age <=29 && customer.getGender().equalsIgnoreCase("male")) {
			int result=policy.getAmount();
			int discount=(int) (result-(result*.10));
			customer.setPremiumToPay(discount);
			customer.setPolicy(policy);
		}
		else if(age>=20 && age <=29 && customer.getGender().equalsIgnoreCase("female")){
			int result=policy.getAmount();
			int discount=(int) (result-(result*.15));
			customer.setPremiumToPay(discount);
			customer.setPolicy(policy);
		}
		else if(age>29  && customer.getGender().equalsIgnoreCase("male")){
			customer.setPremiumToPay(policy.getAmount());
			customer.setPolicy(policy);
		}
		
		else if(age>30 && customer.getGender().equalsIgnoreCase("female")){
			int result=policy.getAmount();
			int discount=(int) (result-(result*.05));
			customer.setPremiumToPay(discount);
			customer.setPolicy(policy);
		}
		else {
			throw new CustomerAgeNotMatchException("Customer age is less than 20");
		}
		return customerrepository.save(customer) ;
	}

}
