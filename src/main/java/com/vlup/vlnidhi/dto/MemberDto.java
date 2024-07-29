package com.vlup.vlnidhi.dto;

import java.sql.Date;

import com.vlup.vlnidhi.entity.Account;
import com.vlup.vlnidhi.entity.Branch;
import com.vlup.vlnidhi.entity.MemberPersonalDetail;
import com.vlup.vlnidhi.enums.NomineeRelation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class MemberDto {

	private Long id;
    private String memberCode;
    private String remarks;
    private boolean status;
    private String memberName;
    private String searchByCode;
    private String sponsorName;
    private String introMemCode;
    private String nomineeName;
    private NomineeRelation nomineeRelation;
    private String nomineeEmailId;
    private String nomineemobileNo;
    private int nomineeAge;
    private String nomineePanNo;
    private String nomineeAddress;
    private byte[] applicantPhoto;
    private byte[] signature;
    private byte[] aadharFrontPhoto;
    private byte[] aadharBackPhoto;
    private byte[] panPhoto;
    private Date registrationDate;
    private boolean memberStatus;
    private BranchDto branch;
    private MemberPersonalDetailDto memberPersonalDetail;
    private AccountDto account;
    
    public String getSearchByCode() {
		return memberName +" - "+memberCode;
	}

	public void setSearchByCode(String searchByCode) {
		this.searchByCode = searchByCode;
	}
}
