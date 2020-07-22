package com.library.management.system.library_management_system.controller;

import com.google.zxing.WriterException;
import com.library.management.system.library_management_system.dto.TransactionDto;
import com.library.management.system.library_management_system.model.LMSException;
import com.library.management.system.library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/transaction")
@CrossOrigin(origins = "*", maxAge = 3600)

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(path = "/first", produces = MediaType.APPLICATION_JSON_VALUE)
    private TransactionDto findFirst() {
        TransactionDto transactionDto = transactionService.findFirst();
        if (transactionDto != null)
            return transactionDto;
        else
            return new TransactionDto();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private TransactionDto add(@RequestBody TransactionDto transactionDto) throws LMSException, IOException, WriterException {
        return transactionService.add(transactionDto);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private void delete(@PathVariable Integer id) throws LMSException, IOException {
        transactionService.delete(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private TransactionDto update(@RequestBody TransactionDto TransactionDto) throws IOException, LMSException, WriterException {
        return transactionService.update(TransactionDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<TransactionDto> findAll() {
        return transactionService.findAll();
    }
}
