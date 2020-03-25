package com.library.management.system.library_management_systelm.dto;

import com.library.management.system.library_management_systelm.entity.Book;
import com.library.management.system.library_management_systelm.entity.MemberRecord;
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
