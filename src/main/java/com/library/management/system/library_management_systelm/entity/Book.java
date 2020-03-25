package com.library.management.system.library_management_systelm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer bookId;
    private String codeBook;
    private String author;
    private String title;
    private Double price;
    private Integer rackNo;
    private String status;
    private String edition;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfPurchase;

}
