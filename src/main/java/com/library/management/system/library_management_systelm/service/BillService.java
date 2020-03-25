package com.library.management.system.library_management_systelm.service;

import com.library.management.system.library_management_systelm.Converter.BillConverter;
import com.library.management.system.library_management_systelm.dto.BillDto;
import com.library.management.system.library_management_systelm.entity.Bill;
import com.library.management.system.library_management_systelm.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    BillConverter billConverter = new BillConverter();

    public BillDto add(BillDto billDto) {
        return billConverter.convert(billRepository.save(billConverter.convert(billDto)));
    }

    public void delete(BillDto billDto) {
        billRepository.delete(billConverter.convert(billDto));
    }
    public BillDto update(BillDto billDto) {
        return billConverter.convert(billRepository.save(billConverter.convert(billDto)));
    }
    public List<BillDto> findAll() {
        List<Bill> bills = billRepository.findAll();
        List<BillDto> billsDto = new ArrayList<>();
        bills.forEach(item->{
            billsDto.add(billConverter.convert(item));
        });
        return billsDto;
    }
}
