package com.mindtree.company.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.company.entity.Policy;

@Repository

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

	Optional<Policy> findByPolicyName(String policyName);

}
