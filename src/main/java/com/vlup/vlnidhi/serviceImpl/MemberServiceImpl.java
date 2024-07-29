package com.vlup.vlnidhi.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlup.vlnidhi.dto.MemberCodeDto;
import com.vlup.vlnidhi.dto.MemberDto;
import com.vlup.vlnidhi.entity.Branch;
import com.vlup.vlnidhi.entity.Member;
import com.vlup.vlnidhi.repository.BranchRepository;
import com.vlup.vlnidhi.repository.MemberRepository;
import com.vlup.vlnidhi.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepo;
    
    @Autowired
    private BranchRepository branchRepo;

    @Autowired
    private ModelMapper modelMapper;

    private static final String MEMBER_PREFIX = "VL";
    private static final int MEMBER_CODE_LENGTH = 7;

    private Member convertDtoToEntity(MemberDto memberDto) {
        return this.modelMapper.map(memberDto, Member.class);
    }

    private MemberDto convertEntityToDto(Member member) {
        return this.modelMapper.map(member, MemberDto.class);
    }    

    @Override
    public MemberDto createMember(MemberDto memberDto) {
        // Convert DTO to Entity
        Member member = convertDtoToEntity(memberDto);
        
        
     // Save Branch first to ensure branchCode is generated
        Branch branch = member.getBranch();
        if (branch != null) {
            branch.setBranchCode(generateNextBranchCode());
            
            // Set branchName before saving
            branch.setbranchName(branch.getbranchName());

            branch = branchRepo.save(branch);
            member.setBranch(branch);
        }
        
        // Generate and set memberCode
        member.setMemberCode(generateNextMemberCode());
        
     // Set concatenatedMemberName before saving
     		member.setSearchByCode(member.getSearchByCode());

        // Save Member
        Member savedMember = memberRepo.save(member);

        // Convert saved Entity to DTO
        return convertEntityToDto(savedMember);
    }

    private String generateNextMemberCode() {
        String lastMemberCode = memberRepo.findTopByOrderByIdDesc()
                .map(Member::getMemberCode)
                .orElse(MEMBER_PREFIX + String.format("%0" + (MEMBER_CODE_LENGTH - MEMBER_PREFIX.length()) + "d", 0));

        int nextNumber = Integer.parseInt(lastMemberCode.substring(MEMBER_PREFIX.length())) + 1;
        return MEMBER_PREFIX + String.format("%0" + (MEMBER_CODE_LENGTH - MEMBER_PREFIX.length()) + "d", nextNumber);
    }
    
    private String generateNextBranchCode() {
	    // Fetch the latest branch entry from the repository
	    Optional<Branch> latestBranchOpt = branchRepo.findTopByOrderByIdDesc();
	    // Generate the new branch code
	    if (latestBranchOpt.isEmpty()) {
	        return "001";
	    }
	    Branch latestBranch = latestBranchOpt.get();
	    String latestBranchCode = latestBranch.getBranchCode();
	    // Handle case where latestBranchCode might be null or empty
	    if (latestBranchCode == null || latestBranchCode.isEmpty()) {
	        return "001";
	    }
	    // Convert the latestBranchCode to an integer
	    int latestCodeNumber;
	    try {
	        latestCodeNumber = Integer.parseInt(latestBranchCode);
	    } catch (NumberFormatException e) {
	        // Handle the case where the branch code is not a valid integer
	        return "001";
	    }
	    int nextCodeNumber = latestCodeNumber + 1;
	    // Format the new branch code with leading zeros
	    return String.format("%03d", nextCodeNumber);
	}

    @Override
    public Optional<MemberDto> getMemberByMemberCode(String memberCode) {
        return memberRepo.findByMemberCode(memberCode)
                .map(this::convertEntityToDto);
    }

    @Override
    public List<MemberDto> getAllMembers() {
        return memberRepo.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MemberDto> updateMemberByMemberCode(String memberCode, MemberDto memberDto) {
        return memberRepo.findByMemberCode(memberCode)
                .map(existingMember -> {
                    modelMapper.map(memberDto, existingMember);
                    Member updatedMember = memberRepo.save(existingMember);
                    return convertEntityToDto(updatedMember);
                });
    }
	 	 
    @Override
    public List<MemberCodeDto> getMembers(String searchByCode) {
        List<Member> members;

        if (searchByCode == null || searchByCode.isEmpty()) {
            // Fetch all records if searchByCode is null or empty
            members = memberRepo.findAll();
        } else {
            // Fetch records matching the searchByCode
            members = memberRepo.findBySearchByCode(searchByCode);
        }

        // Convert the list of Member entities to a list of MemberSearchDto
        return members.stream()
                      .map(member -> {
                          MemberCodeDto dto = new MemberCodeDto();
                          dto.setSearchByCode(member.getSearchByCode());
                          return dto;
                      })
                      .collect(Collectors.toList());
    }
	
  
}


