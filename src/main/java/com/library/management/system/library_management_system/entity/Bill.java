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
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    @ManyToOne
    private MemberRecord memberId;
    private Integer amount;
}
