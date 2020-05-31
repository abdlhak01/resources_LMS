package com.library.management.system.library_management_system.converter;

import com.library.management.system.library_management_system.dto.TransactionDto;
import com.library.management.system.library_management_system.entity.Transaction;
import com.library.management.system.library_management_system.repository.BookRepository;
import com.library.management.system.library_management_system.repository.MemberRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionConverter extends Converter<Transaction, TransactionDto> {
    @Autowired
    MemberRecordRepository memberRecordRepository;
    
    @Autowired
    BookRepository bookRepository;

    @Override
    public Transaction convert(TransactionDto source) {
        Transaction transaction = null;
        if (source != null){
            transaction = super.convert(source);
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
