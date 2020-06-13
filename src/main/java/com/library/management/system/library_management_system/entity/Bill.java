package com.library.management.system.library_management_system.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer billNo;
    private LocalDate date;
    @JoinColumn(name = "memberRecordId", referencedColumnName = "memberRecordId")
    @ManyToOne
    private MemberRecord memberRecordId;
    private Integer amount;
}
