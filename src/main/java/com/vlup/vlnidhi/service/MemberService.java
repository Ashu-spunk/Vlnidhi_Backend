package com.vlup.vlnidhi.service;

import java.util.List;
import java.util.Optional;

import com.vlup.vlnidhi.dto.MemberCodeDto;
import com.vlup.vlnidhi.dto.MemberDto;
import com.vlup.vlnidhi.entity.Member;

public interface MemberService {
	
	MemberDto createMember(MemberDto memberDto);

	Optional<MemberDto> getMemberByMemberCode(String memberCode);

	List<MemberDto> getAllMembers();

	Optional<MemberDto> updateMemberByMemberCode(String memberCode, MemberDto memberDto);

	List<MemberCodeDto> getMembers(String searchByCode);

	
	
	
}
