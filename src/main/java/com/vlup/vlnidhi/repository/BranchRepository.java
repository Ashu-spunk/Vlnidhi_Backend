package com.vlup.vlnidhi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlup.vlnidhi.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

	Optional<Branch> findByBranchNam(String branchName);
	
	Optional<Branch> findTopByOrderByIdDesc();

}
