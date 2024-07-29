package com.vlup.vlnidhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlup.vlnidhi.dto.BranchDto;
import com.vlup.vlnidhi.service.BranchService;



@RestController
@RequestMapping("api/branch")
public class BranchController {

	
	@Autowired
    private BranchService branchService;
	
	
	 @PostMapping("/")
	    public ResponseEntity<BranchDto> createBranch(@RequestBody BranchDto branchDto) {
	        try {
	            // Create the branch using the service layer
	            BranchDto createdBranch = branchService.createBranch(branchDto);

	            // Return the created branch with a 201 Created status
	            return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
	        } catch (Exception e) {
	            // Return an error response in case of failure
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
