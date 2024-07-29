package com.vlup.vlnidhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlup.vlnidhi.entity.MemberPersonalDetail;


@Repository
public interface MemberPersonalDetailRepository extends JpaRepository<MemberPersonalDetail, Long> {

	
}
