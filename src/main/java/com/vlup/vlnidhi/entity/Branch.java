package com.vlup.vlnidhi.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "branch")
public class Branch 
 {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "branchCode")
    private String branchCode;
    @Column(length = 30)
    private String branchNam;

    private Date openingDate;
    @Column(length = 255)
    private String branchAddress;

    private int pin;
    
    private String CspCode;
 
    @Column(length = 30)
    private String city;
    @Column(length = 30)
    private String branchState;
    @Column(length = 70)
    private String contactPersonName;
    @Column(length = 20)
    private String contactNo;

    private String branchName; 
    
    @OneToMany(mappedBy = "branch")
    private List<Member> members;
   
 // Getter for concatenatedBranchName
    public String getbranchName() {
        return branchNam + " - " + branchCode;
    }
    // Setter for concatenatedBranchName (if needed)
    public void setbranchName(String branchName) {
        this.branchName = branchName;
    }
 }
