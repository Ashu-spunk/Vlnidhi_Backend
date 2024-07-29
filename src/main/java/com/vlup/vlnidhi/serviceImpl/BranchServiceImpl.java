package com.vlup.vlnidhi.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlup.vlnidhi.dto.BranchDto;
import com.vlup.vlnidhi.dto.MemberDto;
import com.vlup.vlnidhi.entity.Branch;
import com.vlup.vlnidhi.entity.Member;
import com.vlup.vlnidhi.repository.BranchRepository;
import com.vlup.vlnidhi.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
    private BranchRepository branchRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	 private Branch convertDtoToEntity(BranchDto branchDto) {
	        return this.modelMapper.map(branchDto, Branch.class);
	    }

	    private BranchDto convertEntityToDto(Branch branch) {
	        return this.modelMapper.map(branch, BranchDto.class);
	    } 
	    
	@Override
	public BranchDto createBranch(BranchDto branchDto) {
		Branch branch = convertDtoToEntity(branchDto);
        // Generate and set the branch code
        String newBranchCode = generateNextBranchCode();
       branch.setBranchCode(newBranchCode);
        // Set branchName before saving
        branch.setbranchName(branch.getbranchName());
        // Save the branch entity
        Branch savedBranch = branchRepo.save(branch);
        return convertEntityToDto(savedBranch);
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

}
