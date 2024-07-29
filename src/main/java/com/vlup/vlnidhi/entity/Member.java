package com.vlup.vlnidhi.entity;

import java.sql.Date;
import java.util.List;

import com.vlup.vlnidhi.enums.NomineeRelation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "Member")
public class Member {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberCode;
    
    @Column(name = "remarks", columnDefinition = "text")
    private String remarks;
    
    @Column(name = "status")
    private boolean status;

	@Column(name = "memberName")
    private String memberName;
    
    private String searchByCode;
	
	private String sponsorName;
	
	private String introMemCode;
	
	@Column(name = "nomineeName",length = 50)
    private String nomineeName;
    
    @Enumerated(EnumType.STRING)
    private NomineeRelation nomineeRelation;
    
    private String nomineeEmailId;
    
    @Column(length = 10)
    private String nomineemobileNo;

    private int nomineeAge;

    private String nomineePanNo;

    @Column(length = 200)
    private String nomineeAddress;	

	@Lob
	private byte[] applicantPhoto;

	@Lob
    private byte[] signature;  
	
	@Lob
    private byte[] aadharFrontPhoto;
	
	@Lob
    private byte[] aadharBackPhoto;
	
	@Lob
	private byte[] panPhoto;
	
	private Date registrationDate;
	
	private boolean memberStatus;
	
	
	// Many-to-One relationship with Branch
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    
 // One-to-One relationship with MemberPersonalDetail
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_detail_id")
    private MemberPersonalDetail memberPersonalDetail;
    
 // One-to-One relationship with Account
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
	
	public String getSearchByCode() {
		return memberName +" - "+memberCode;
	}

	public void setSearchByCode(String searchByCode) {
		this.searchByCode = searchByCode;
	}
	
}
