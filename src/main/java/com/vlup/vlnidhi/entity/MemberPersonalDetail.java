package com.vlup.vlnidhi.entity;

import java.sql.Date;

import com.vlup.vlnidhi.enums.Gender;
import com.vlup.vlnidhi.enums.MartialStatus;
import com.vlup.vlnidhi.enums.State;
import com.vlup.vlnidhi.enums.VerifyWith;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter  
@Setter
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "MemberPerDetail")
public class MemberPersonalDetail {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "dob")
    private Date dob;

    private String enterAadharNumber;
          
    private String otp;
    
    @Column(name = "age")
    private Long age;

    @Enumerated(EnumType.STRING)
    private MartialStatus maritalStatus;

    @Column(name = "aadharNo")
    private Long aadharNo;

    @Column(name = "panNo", length = 20)
    private String panNo;

    @Column(name = "voterId", length = 20)
    private String voterId;

    @Column(name = "drivingLiscNo", length = 50)
    private String drivingLiscNo;

    @Column(name = "mobileNo", length = 20)
    private String mobileNo;

    @Column(name = "emailId", length = 50)
    private String emailId;

    @Column(name = "occupation", length = 20)
    private String occupation;

    @Column(name = "education", length = 20)
    private String education;
    
    @Enumerated(EnumType.STRING)
    private VerifyWith verificationMethod; 
    
    @Column(name = "address")
    private String address;

    @Column(name = "district", length = 30)
    private String district;

    @Enumerated(EnumType.STRING)
    private State state;
    
    @Column(name = "pincode")
    private int pincode;

    @Column(name = "rationNo", length = 50)
    private String rationNo;
    
 // One-to-One relationship with Member
    @OneToOne(mappedBy = "memberPersonalDetail")
    private Member member;
}
