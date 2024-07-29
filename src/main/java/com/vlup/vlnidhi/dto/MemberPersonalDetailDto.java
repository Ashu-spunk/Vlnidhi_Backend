package com.vlup.vlnidhi.dto;

import java.sql.Date;

import com.vlup.vlnidhi.enums.Gender;
import com.vlup.vlnidhi.enums.MartialStatus;
import com.vlup.vlnidhi.enums.NomineeRelation;
import com.vlup.vlnidhi.enums.State;
import com.vlup.vlnidhi.enums.VerifyWith;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class MemberPersonalDetailDto {

	private Long id;
    private Gender gender;
    private Date dob;
    private String enterAadharNumber;
    private String otp;
    private Long age;
    private MartialStatus maritalStatus;
    private Long aadharNo;
    private String panNo;
    private String voterId;
    private String drivingLiscNo;
    private String mobileNo;
    private String emailId;
    private String occupation;
    private String education;
    private VerifyWith verificationMethod;
    private String address;
    private String district;
    private State state;
    private int pincode;
    private String rationNo;
}
