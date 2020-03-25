package com.library.management.system.library_management_systelm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class MemberRecord implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer memberId;
    private String memberCode;
    private String type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfMembership;
    private Integer noBookIssued;
    private Integer maxBookLimit;
    private String name;
    private String adress;
    private String phoneNo;

    @JsonIgnore
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "memberId")
    private Set<Bill> billSet;

    @JsonIgnore
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "memberId")
    private Set<Transaction> transactionSet ;


}
