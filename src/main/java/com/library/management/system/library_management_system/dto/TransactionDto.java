package com.library.management.system.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Integer transId;
    private Integer memberId;
    private Integer bookId;
    private String dateOfIssue;
    private String dueDate;
}
