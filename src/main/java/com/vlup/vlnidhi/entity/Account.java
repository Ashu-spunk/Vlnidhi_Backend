package com.vlup.vlnidhi.entity;

import java.math.BigDecimal;
import java.sql.Date;

import com.vlup.vlnidhi.enums.AccType;
import com.vlup.vlnidhi.enums.AccountStatus;
import com.vlup.vlnidhi.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "account")
public class Account {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(length = 30)
	private String accHolderName;
	
	@Column(length = 20)
	private String accountNo;
	
	@Column()
	private Date accountOpeningDate;
	
	@Column(length = 20)
	private String ifscCode;
	
	@Column()
	private String bankName;
	
	@Column()
	private String bankBranch;
	
	@Enumerated(EnumType.STRING)
	private AccType accType;
	
	@Column()
	private Double accountBalance;
	
	@Column()
	private String mobileNo;
	
	@Column(length = 100)
	private String address;
	
	 @Column(name = "city")
	 private String city;

	 @Column(name = "country")
	 private String country;
	 
	 @Enumerated(EnumType.STRING)
	 private AccountStatus accStatus;
	 
	 private int installmentNo;

		@Column(length = 50)
		private String shareAllotedFrom;

		private int previousShareBalance;
		private int previousNoOfShare;

		@Column(length = 100)
		private String folioNo;

		@Column(length = 100)
		private String dno;

		private String unallotedShare;
		private Date transferDate;
		private BigDecimal transferAmount;

		@Column(length = 20)
		private String shareNumber;

		@Column(precision = 10, scale = 2)
		private BigDecimal shareValue;

		private int totalShares;

		private Date issueDate;

		private BigDecimal fees;

		private Date maturityDate;
		
		private long noOfShare;
		
		private String txnId;
		
		private BigDecimal balance;	

		@Column(length = 20)
		private String paymentBy;

		@Column(precision = 10, scale = 2, columnDefinition = "decimal(10, 2) default '0.00'")
		private BigDecimal dividendsEarned;

		@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
		private Date createdAt;

		@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
		private Date updatedAt;
        
		@Lob
		private String remarks;

		@Enumerated(EnumType.STRING)
		private Status status;

		private BigDecimal memberfees;
		
		private String chequeNo;
		
		private Date chequeDate;
		
		
	    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
	    private Member member;
}
