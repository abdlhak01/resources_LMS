package com.library.management.system.library_management_systelm.Converter;

import com.library.management.system.library_management_systelm.dto.TransactionDto;
import com.library.management.system.library_management_systelm.entity.Transaction;
import com.library.management.system.library_management_systelm.repository.BookRepository;
import com.library.management.system.library_management_systelm.repository.MemberRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionConverter extends Converter<Transaction, TransactionDto> {
    @Autowired
    MemberRecordRepository memberRecordRepository;
    
    @Autowired
    BookRepository bookRepository;

    @Override
    public Transaction convert(TransactionDto source) {
        Transaction transaction = super.convert(source);
        if (source != null){
            transaction.setMemberId(memberRecordRepository.findById(source.getMemberId()).get());
            transaction.setBookId(bookRepository.findById(source.getBookId()).get());
        }
        return transaction;
    }

    @Override
    public TransactionDto convert(Transaction source) {
        TransactionDto transactionDto = super.convert(source);
        if (source != null){
            transactionDto.setMemberId(source.getMemberId().getMemberId());
            transactionDto.setBookId(source.getBookId().getBookId());
        }
        return transactionDto;
    }
}
