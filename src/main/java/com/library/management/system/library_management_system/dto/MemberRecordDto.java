package com.library.management.system.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRecordDto {
    private Integer memberId;
    private String type;
    private String dateOfMembership;
    private Integer noBookIssued;
    private Integer maxBookLimit;
    private String name;
    private String adress;
    private String phoneNo;
}
