package com.library.management.system.library_management_systelm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer bookId;
    private String codeBook;
    private String author;
    private String title;
    private Double price;
    private Integer rackNo;
    private String status;
    private String edition;
    private String dateOfPurchase;
}
