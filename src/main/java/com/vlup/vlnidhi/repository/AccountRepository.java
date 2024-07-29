package com.vlup.vlnidhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlup.vlnidhi.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	
}
