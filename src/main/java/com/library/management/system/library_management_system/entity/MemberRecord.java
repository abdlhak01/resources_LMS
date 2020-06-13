package com.library.management.system.library_management_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class MemberRecord implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer memberRecordId;
    private String codeMemberRecord;
    private String type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime dateOfMemberRecordship;
    private Integer noBookIssued;
    private Integer maxBookLimit;
    private String fullName;
    private String adress;
    private String phoneNo;

    @JsonIgnore
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "memberRecordId")
    private Set<Bill> billSet;

    @JsonIgnore
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "memberRecordId")
    private Set<Transaction> transactionSet ;


}
