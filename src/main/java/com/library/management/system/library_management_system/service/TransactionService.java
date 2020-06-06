package com.library.management.system.library_management_system.service;

import com.google.zxing.WriterException;
import com.library.management.system.library_management_system.converter.TransactionConverter;
import com.library.management.system.library_management_system.dto.TransactionDto;
import com.library.management.system.library_management_system.entity.Transaction;
import com.library.management.system.library_management_system.model.LMSException;
import com.library.management.system.library_management_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionConverter transactionConverter;

    public TransactionDto findFirst() {
        Transaction transaction = transactionRepository.findFirstByOrderByTransactionId();
        if (transaction == null){
            return null;
        } else {
            return transactionConverter.convert(transaction);
        }
    }

    public TransactionDto findByTransactionId(String findByTransCode){
        Transaction transaction = transactionRepository.findByTransactionCode(findByTransCode);
        if (transaction == null){
            return null;
        } else {
            return transactionConverter.convert(transaction);
        }
    }

    public TransactionDto add(TransactionDto transactionDto) throws LMSException, IOException, WriterException {
        if (transactionRepository.existsByTransactionCode(transactionDto.getCodeTrans())) {
            throw new LMSException("Ce code \"code Transaction\" existe déjà");
        }
        TransactionDto transactionDto1 = transactionConverter.convert(transactionRepository.save(transactionConverter.convert(transactionDto)));
        return transactionDto1;
    }

    public void delete(Integer id) throws LMSException, IOException{
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()){
            transactionRepository.deleteById(id);
        } else {
            throw new LMSException("Ce Transaction ne plus existé");
        }
    }

    public TransactionDto update(TransactionDto transactionDto) throws IOException, LMSException, WriterException {
        Optional<Transaction> transaction = transactionRepository.findById(transactionDto.getTransId());
        if (transactionRepository.existsByTransactionCode(transactionDto.getCodeTrans())) {
            throw new LMSException("Ce code \"code Transaction\" existe déjà");
        }
        TransactionDto transactionDto1 = transactionConverter.convert(transactionRepository.save(transactionConverter.convert(transactionDto)));
        return transactionDto1;
    }

    public  List<TransactionDto> findAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionsDto = new ArrayList<>();
        transactions.forEach(item -> {
            transactionsDto.add(transactionConverter.convert(item));
        });
        return transactionsDto;
    }
}
