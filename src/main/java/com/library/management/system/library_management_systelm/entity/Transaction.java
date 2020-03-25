package com.library.management.system.library_management_systelm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer transId;
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    @ManyToOne
    private MemberRecord memberId;
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    @ManyToOne
    private Book bookId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfIssue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dueDate;
}
