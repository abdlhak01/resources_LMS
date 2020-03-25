package com.library.management.system.library_management_systelm.Converter;

import com.library.management.system.library_management_systelm.dto.BillDto;
import com.library.management.system.library_management_systelm.entity.Bill;
import com.library.management.system.library_management_systelm.repository.MemberRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillConverter extends Converter<Bill, BillDto> {

    @Autowired
    MemberRecordRepository memberRecordRepository;

    @Override
    public Bill convert(BillDto source) {
        Bill bill = super.convert(source);
        if (source != null)
            bill.setMemberId(memberRecordRepository.findById(source.getMemberId()).get());
        return bill;
    }

    @Override
    public BillDto convert(Bill source) {
        BillDto billDto = super.convert(source);
        if(source != null)
            billDto.setMemberId(source.getMemberId().getMemberId());
        return billDto;
    }
}
