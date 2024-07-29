package com.vlup.vlnidhi.dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.vlup.vlnidhi.enums.AccType;
import com.vlup.vlnidhi.enums.AccountStatus;
import com.vlup.vlnidhi.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class AccountDto {
	private Long id;
    private String accHolderName;
    private String accountNo;
    private Date accountOpeningDate;
    private String ifscCode;
    private String bankName;
    private String bankBranch;
    private AccType accType;
    private Double accountBalance;
    private String mobileNo;
    private String address;
    private String city;
    private String country;
    private AccountStatus accStatus;
    private int installmentNo;
    private String shareAllotedFrom;
    private int previousShareBalance;
    private int previousNoOfShare;
    private String folioNo;
    private String dno;
    private String unallotedShare;
    private Date transferDate;
    private BigDecimal transferAmount;
    private String shareNumber;
    private BigDecimal shareValue;
    private int totalShares;
    private Date issueDate;
    private BigDecimal fees;
    private Date maturityDate;
    private long noOfShare;
    private String txnId;
    private BigDecimal balance;
    private String paymentBy;
    private BigDecimal dividendsEarned;
    private Date createdAt;
    private Date updatedAt;
    private String remarks;
    private Status status;
    private BigDecimal memberfees;
    private String chequeNo;
    private Date chequeDate;
}
