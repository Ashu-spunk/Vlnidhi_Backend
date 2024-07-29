package com.vlup.vlnidhi.dto;

import java.sql.Date;
import java.util.List;

import com.vlup.vlnidhi.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class BranchDto {

	private Long id;
    private String branchCode;
    private String branchNam;
    private Date openingDate;
    private String branchAddress;
    private int pin;
    private String cspCode;
    private String city;
    private String branchState;
    private String contactPersonName;
    private String contactNo;
    private String branchName;
    
    
    public String getBranchName() {
        return branchNam + " - " + branchCode;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
