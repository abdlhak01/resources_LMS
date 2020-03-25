package com.library.management.system.library_management_systelm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {

    private Integer billNo;
    private String date;
    private Integer memberId;
    private Integer amount;
}
