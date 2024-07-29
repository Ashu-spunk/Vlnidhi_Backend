package com.vlup.vlnidhi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlup.vlnidhi.dto.MemberDto;
import com.vlup.vlnidhi.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Optional<Member> findByMemberCode(String memberCode);

	Optional<Member> findTopByOrderByIdDesc();

	List<Member> findBySearchByCode(String searchByCode);
	
	
	
	
}
