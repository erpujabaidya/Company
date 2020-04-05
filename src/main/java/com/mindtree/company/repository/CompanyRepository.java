package com.mindtree.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.company.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findByCompanyName(String companyName);

	//Optional<Company> findByCompanyName1(String companyName);
	

}
